package org.example.data.impl;

import org.example.data.ServerRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.PaymentTypeMapper;
import org.example.data.mappers.ServerMapper;
import org.example.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Primary
public class MySqlServerRepo implements ServerRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Server getServerById(int id) throws InternalErrorException, RecordNotFoundException {
        return null;
    }

    @Override
    public List<Server> getAllAvailableServers(LocalDate date) throws InternalErrorException {
        String sql = "SELECT * FROM server";

        try {
            return jdbcTemplate.query(sql, ServerMapper.serverRowMapper());
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }
}
