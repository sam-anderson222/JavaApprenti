package org.example.data.impl;

import org.example.data.OrderRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.*;
import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.sql.Date;
import java.util.*;

@Repository
@Primary
public class MySqlOrderRepo implements OrderRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Order getOrderById(int id) throws RecordNotFoundException, InternalErrorException {
        try {
            return jdbcTemplate.execute("{CALL get_order_with_details(?)}",
                    (CallableStatementCallback<Order>) cs -> {
                        cs.setInt(1, id);

                        boolean hasResults = cs.execute();

                        // Getting the order and server objects
                        Order order = null;
                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()){
                                if (rs.next()) {
                                    order = OrderMapper.orderRowMapper().mapRow(rs, 1);
                                    order.setServer(ServerMapper.serverRowMapper().mapRow(rs, 1));
                                }
                            }
                        }

                        // Getting OrderItems / Items / IteCategories
                        List<OrderItem> items = new ArrayList<>();
                        hasResults = cs.getMoreResults(); // Moves to the next rs in the procedure.

                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()){
                                while (rs.next()) {
                                    OrderItem oi = OrderItemMapper.orderItemRowMapper().mapRow(rs, 1);
                                    Item i = ItemMapper.itemRowMapper().mapRow(rs, 1);
                                    i.setItemCategory(ItemCategoryMapper.itemCategoryRowMapper().mapRow(rs, 1));
                                    oi.setItem(i);

                                    items.add(oi);
                                }
                            }
                        }

                        // Getting Payments / PaymentTypes
                        List<Payment> payments = new ArrayList<>();
                        hasResults = cs.getMoreResults();

                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()){
                                while (rs.next()) {
                                    Payment p = PaymentMapper.paymentRowMapper().mapRow(rs, 1);
                                    p.setPaymentType(PaymentTypeMapper.paymentTypeRowMapper().mapRow(rs, 1));

                                    payments.add(p);
                                }
                            }
                        }

                        // Add fields to order
                        if (order != null) {
                            order.setItems(items);
                            order.setPayments(payments);
                        } else {
                            throw new EmptyResultDataAccessException(1);
                        }

                        return order;
                    });

        } catch (EmptyResultDataAccessException ex) {
            throw new RecordNotFoundException();
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Order> getAllOrders() throws InternalErrorException, RecordNotFoundException {

        try {
            return jdbcTemplate.execute("{CALL get_all_orders_with_details()}",
                    (CallableStatementCallback<List<Order>>) cs -> {
                        boolean hasResults = cs.execute();

                        // Used to find which Order object a payment orderItem goes to.
                        HashMap<Integer, Order> orderTable = new HashMap<>();

                        // Get orders
                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()){
                                while (rs.next()) {
                                    Order order = OrderMapper.orderRowMapper().mapRow(rs, 1);
                                    order.setServer(ServerMapper.serverRowMapper().mapRow(rs, 1));

                                    orderTable.put(order.getOrderID(), order);
                                }
                            }
                        }

                        // Get orderItems
                        hasResults = cs.getMoreResults(); // Moves to the next rs in the procedure.

                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()){
                                while (rs.next()) {
                                    OrderItem oi = OrderItemMapper.orderItemRowMapper().mapRow(rs, 1);
                                    Item i = ItemMapper.itemRowMapper().mapRow(rs, 1);
                                    i.setItemCategory(ItemCategoryMapper.itemCategoryRowMapper().mapRow(rs, 1));
                                    oi.setItem(i);

                                    orderTable.get(oi.getOrderID()).getItems().add(oi); // Get the order object and add the orderItem object to it.

                                }
                            }
                        }

                        // Get payments
                        hasResults = cs.getMoreResults(); // Moves to the next rs in the procedure.

                        if (hasResults) {
                            try (ResultSet rs = cs.getResultSet()){
                                while (rs.next()) {
                                    Payment p = PaymentMapper.paymentRowMapper().mapRow(rs, 1);
                                    p.setPaymentType(PaymentTypeMapper.paymentTypeRowMapper().mapRow(rs, 1));

                                    orderTable.get(p.getOrderID()).getPayments().add(p);
                                }
                            }
                        }


                        return new ArrayList<>(orderTable.values());
                    });

        } catch (EmptyResultDataAccessException ex) {
            throw new RecordNotFoundException();
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }

    @Override
    public Order addOrder(Order order) throws InternalErrorException {
        // First, add the order object
        String sql = "INSERT INTO `order` (ServerID, OrderDate, SubTotal, Tax, Tip, Total) VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                ps.setInt(1, order.getServerID());
                ps.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
                ps.setBigDecimal(3, order.getSubTotal());
                ps.setBigDecimal(4, order.getTax());
                ps.setBigDecimal(5, order.getTip());
                ps.setBigDecimal(6, order.getTotal());

                return ps;
            }, keyHolder);

            order.setOrderID(keyHolder.getKey().intValue());
        } catch (Exception ex) {
            throw new InternalErrorException();
        }

        // Second, batch insert the orderItem objects
        insertOrderItems(order);

        // Last, batch insert the payment objects.
        insertPayments(order);


        return order;
    }

    @Override
    public void updateOrder(Order order) throws InternalErrorException {
        try {
            Boolean isSuccess = jdbcTemplate.execute("{CALL update_order_drop_orderitems_payments(?, ?, ?, ?, ?, ?, ?, ?)}",
                    (CallableStatementCallback<Boolean>) cs -> {
                        cs.setInt(1, order.getOrderID());
                        cs.setInt(2, order.getServerID());
                        cs.setTimestamp(3, Timestamp.valueOf(order.getOrderDate()));
                        cs.setBigDecimal(4, order.getSubTotal());
                        cs.setBigDecimal(5, order.getTax());
                        cs.setBigDecimal(6, order.getTip());
                        cs.setBigDecimal(7, order.getTotal());
                        cs.registerOutParameter(8, Types.INTEGER);
                        cs.execute();
                        int rowsAffected = cs.getInt(8);

                        return (rowsAffected == 1); // Checks to see
                    });

            if (Boolean.FALSE.equals(isSuccess)) { // Throws if user tried to update that doesn't exist.
                throw new InternalErrorException();
            } else {
                // Insert the new orderItems and payments as the old ones were deleted.
                insertOrderItems(order);
                insertPayments(order);

            }


        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }

    @Override
    public Order deleteOrder(int id) throws InternalErrorException {
        try {
            return jdbcTemplate.execute("{CALL delete_order(?)}",
                    (CallableStatementCallback<Order>) cs -> {
                        cs.setInt(1, id);
                        cs.executeQuery();

                        return null; // If you are deleting an order, you don't need to get its data back. I don't even know why this method returns an order?
                    } );
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }


    private void insertOrderItems(Order order) {
        if (order.getItems() == null) {
            return;
        }

        jdbcTemplate.batchUpdate(
                "INSERT INTO orderitem (OrderID, ItemID, Quantity, Price) VALUES (?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        OrderItem oi = order.getItems().get(i);
                        ps.setInt(1, order.getOrderID());
                        ps.setInt(2, oi.getItemID());
                        ps.setInt(3, oi.getQuantity());
                        ps.setBigDecimal(4, oi.getPrice());

                        // The oi's orderItemID doesn't need to be set, as it will be gotten when the object is reloaded via the DB.
                    }

                    @Override
                    public int getBatchSize() {
                        return order.getItems().size();
                    }
                }
        );
    }

    private void insertPayments(Order order) {
        if (order.getPayments() == null) {
            return;
        }

        jdbcTemplate.batchUpdate(
                "INSERT INTO payment (PaymentTypeID, OrderID, Amount) VALUES (?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Payment p = order.getPayments().get(i);
                        ps.setInt(1, p.getPaymentTypeID());
                        ps.setInt(2, order.getOrderID());
                        ps.setBigDecimal(3, p.getAmount());
                    }

                    @Override
                    public int getBatchSize() {
                        return order.getPayments().size();
                    }
                }
        );
    }
}
