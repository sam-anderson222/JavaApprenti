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
class BistroServiceTest {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private BistroService svc;

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
    void testCalculateOrderTotals() throws RecordNotFoundException, InternalErrorException {
        Order expected = orderRepo.getOrderById(1);
        Order actual = orderRepo.getOrderById(1);

        svc.calculateOrderTotals(actual);
        assertEquals(expected, actual);
    }
}