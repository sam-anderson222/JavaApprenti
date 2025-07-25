package org.example.service;

import org.example.data.OrderRepo;
import org.example.data.TaxRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Order;
import org.example.model.PaymentType;
import org.example.model.Tax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaxRepoTest {
    @Autowired
    private TaxRepo taxRepo;

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
    void getCurrentTax_getsPresentTaxRate() throws RecordNotFoundException, InternalErrorException {
        Tax t = taxRepo.getCurrentTax(LocalDate.now());

        assertEquals(t.getTaxPercentage(), new BigDecimal("6.25"));
    }

    @Test
    void getCurrentTax_getsOldTaxRate() throws RecordNotFoundException, InternalErrorException {
        Tax t = taxRepo.getCurrentTax(LocalDate.parse("2021-01-01"));

        assertEquals(t.getTaxPercentage(), new BigDecimal("5.75"));
    }

    @Test
    void getCurrentTax_invalidDate_returnsException() {
        assertThrows(RecordNotFoundException.class, () ->
        {
            taxRepo.getCurrentTax(LocalDate.parse("1970-01-01"));
        });
    }

    @Test
    void getCurrentTax_nullDate_returnsException() {
        assertThrows(RecordNotFoundException.class, () ->
        {
            taxRepo.getCurrentTax(null);
        });
    }
}
