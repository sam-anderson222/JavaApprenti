package org.example.data.impl;

import org.example.data.OrderRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class MySqlOrderRepo implements OrderRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Order getOrderById(int id) throws RecordNotFoundException, InternalErrorException {
        return null;
    }

    @Override
    public List<Order> getAllOrders() throws InternalErrorException, RecordNotFoundException {
        return List.of();
    }

    @Override
    public Order addOrder(Order order) throws InternalErrorException {
        return null;
    }

    @Override
    public void updateOrder(Order order) throws InternalErrorException {

    }

    @Override
    public Order deleteOrder(int id) throws InternalErrorException {
        return null;
    }
}
