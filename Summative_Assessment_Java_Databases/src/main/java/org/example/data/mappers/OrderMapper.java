package org.example.data.mappers;

import org.example.model.ItemCategory;
import org.example.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

// Gets the only order primitives, other objects like Server, Payment, and OrderItem are gotten differently.
public class OrderMapper {
    // The full mapper gets all data for an order object.
    public static RowMapper<Order> orderRowMapper() {
        return (rs, rowNum) -> {
            Order order = new Order();

            order.setOrderID(rs.getInt("OrderID"));
            order.setServerID(rs.getInt("ServerID"));
            order.setOrderDate(rs.getObject("OrderDate", LocalDateTime.class));
            order.setSubTotal(rs.getBigDecimal("SubTotal"));
            order.setTax(rs.getBigDecimal("Tax"));
            order.setTip(rs.getBigDecimal("Tip"));
            order.setTotal(rs.getBigDecimal("Total"));

            // Initialized so can be added to later.
            order.setItems(new ArrayList<>());
            order.setPayments(new ArrayList<>());

            return order;
        };
    }
}
