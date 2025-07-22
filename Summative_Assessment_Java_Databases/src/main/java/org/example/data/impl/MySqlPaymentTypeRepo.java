package org.example.data.impl;

import org.example.data.PaymentTypeRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.mappers.PaymentTypeMapper;
import org.example.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class MySqlPaymentTypeRepo implements PaymentTypeRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PaymentType> getAll() throws InternalErrorException {
        String sql = "SELECT * FROM paymenttype";

        try {
             return jdbcTemplate.query(sql, PaymentTypeMapper.paymentTypeRowMapper());
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }
}
