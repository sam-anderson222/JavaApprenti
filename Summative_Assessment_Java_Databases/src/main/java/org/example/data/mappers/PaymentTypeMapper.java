package org.example.data.mappers;

import org.example.model.PaymentType;
import org.springframework.jdbc.core.RowMapper;

public class PaymentTypeMapper {
    // Mapper for PaymentType objects.
    public static RowMapper<PaymentType> paymentTypeRowMapper() {
        return (rs, rowNum) -> {
          PaymentType pt = new PaymentType();

          pt.setPaymentTypeID(rs.getInt("PaymentTypeID"));
          pt.setPaymentTypeName(rs.getString("PaymentTypeName"));

          return pt;
        };
    }
}
