package org.example.service;

import org.example.data.OrderRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepoTest {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate; // Used to access and reset the sql database.

    @BeforeEach
    void setUp() {
        try {
            jdbcTemplate.execute("{CALL set_known_good_state()}");
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    @Test
    void getOrderById_validID() throws RecordNotFoundException, InternalErrorException {
        Order o = orderRepo.getOrderById(1);

        assertEquals(8, o.getServerID()); // Order 1 has a server ID of 8.
    }

    @Test
    void getOrderById_invalidID_throwsException() throws RecordNotFoundException, InternalErrorException {
        assertThrows(RecordNotFoundException.class, () ->
        {
            orderRepo.getOrderById(-1);
        });
    }

    @Test
    void getAllOrders_returnsAllOrders() throws RecordNotFoundException, InternalErrorException {
        List<Order> orders = orderRepo.getAllOrders();

        assertEquals(8, orders.get(0).getServerID());
        assertEquals(365, orders.size()); // The known_good_state data has 365 orders.
    }

    @Test
    void addOrder_addsNewOrderToDB() throws RecordNotFoundException, InternalErrorException {
        Order o = orderRepo.getOrderById(1);
        o = orderRepo.addOrder(o); // Re-add order with ID 1, which creates a new order with id 401 with the same data as order id 1.

        // Checks that the number of orders has increased.
        List<Order> orders = orderRepo.getAllOrders();



        assertEquals(401, o.getOrderID());
        assertEquals(366, orders.size());
    }

    @Test
    void updateOrder_updatesOrderOnDB() throws RecordNotFoundException, InternalErrorException {
        Order o = orderRepo.getOrderById(1);
        o.setItems(null);
        o.setPayments(null);

        orderRepo.updateOrder(o); // Removes all items and payments from order ID 1
        o = orderRepo.getOrderById(1); // Reload the newly updated data from the DB.

        assertEquals(0, o.getItems().size());
        assertEquals(0, o.getPayments().size());
    }

    @Test
    void deleteOrder_removesFirstOrder() throws RecordNotFoundException, InternalErrorException {
        orderRepo.deleteOrder(1);

        List<Order> orders = orderRepo.getAllOrders();

        assertEquals(364, orders.size()); // The known_good_state data has 365 orders.
    }
}