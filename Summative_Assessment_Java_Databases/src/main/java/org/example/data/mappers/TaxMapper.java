package org.example.data.mappers;

import org.example.model.PaymentType;
import org.example.model.Tax;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;

public class TaxMapper {
    public static RowMapper<Tax> taxRowMapper() {
        return (rs, rowNum) -> {
            Tax tax = new Tax();

            tax.setTaxID(rs.getInt("TaxID"));
            tax.setTaxPercentage(rs.getBigDecimal("TaxPercentage"));
            tax.setStartDate(rs.getObject("StartDate", LocalDate.class));
            tax.setEndDate(rs.getObject("EndDate", LocalDate.class));

            return tax;
        };
    }
}
