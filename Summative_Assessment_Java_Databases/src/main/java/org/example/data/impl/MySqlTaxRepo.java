package org.example.data.impl;

import org.example.data.TaxRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.TaxMapper;
import org.example.model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@Primary
public class MySqlTaxRepo implements TaxRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Tax getCurrentTax(LocalDate dateOf) throws InternalErrorException, RecordNotFoundException {
        String sql = "SELECT * FROM tax WHERE (? BETWEEN StartDate AND EndDate) OR (EndDate IS NULL AND ? >= StartDate)";

        try {
            Tax tax = jdbcTemplate.queryForObject(sql, TaxMapper.taxRowMapper(), dateOf, dateOf);

            return tax;
        } catch (EmptyResultDataAccessException ex) {
            throw new RecordNotFoundException();
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }
}
