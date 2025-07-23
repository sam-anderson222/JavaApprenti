package org.example.data.impl;

import org.example.data.ServerRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.PaymentTypeMapper;
import org.example.data.mappers.ServerMapper;
import org.example.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
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
        String sql = "SELECT * FROM server WHERE ServerID = ?;";

        try {
            return jdbcTemplate.queryForObject(sql, ServerMapper.serverRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            throw new RecordNotFoundException();
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Server> getAllAvailableServers(LocalDate date) throws InternalErrorException {
        String sql = "SELECT * FROM server WHERE (? BETWEEN HireDate and TermDate) OR (TermDate IS NULL AND ? >= HireDate);";

        try {
            return jdbcTemplate.query(sql, ServerMapper.serverRowMapper(), date, date);
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }
}
