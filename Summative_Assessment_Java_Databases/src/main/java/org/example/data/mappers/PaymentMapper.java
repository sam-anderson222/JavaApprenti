package org.example.data.mappers;

import org.example.model.Order;
import org.example.model.Payment;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDateTime;

public class PaymentMapper {
    public static RowMapper<Payment> paymentRowMapper() {
        return (rs, rowNum) -> {
            Payment p = new Payment();

            p.setPaymentID(rs.getInt("PaymentID"));
            p.setPaymentTypeID(rs.getInt("PaymentTypeID"));
            p.setOrderID(rs.getInt("OrderID"));
            p.setAmount(rs.getBigDecimal("Amount"));

            return p;
        };
    }
}
