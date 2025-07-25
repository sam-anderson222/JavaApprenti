package org.example.data.mappers;

import org.example.model.Item;
import org.example.model.Order;
import org.example.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDateTime;

public class OrderItemMapper {
    public static RowMapper<OrderItem> orderItemRowMapper() {
        return (rs, rowNum) -> {
            OrderItem oi = new OrderItem();

            oi.setOrderItemID(rs.getInt("OrderItemID"));
            oi.setOrderID(rs.getInt("OrderID"));
            oi.setItemID(rs.getInt("ItemID"));
            oi.setQuantity(rs.getInt("Quantity"));
            oi.setPrice(rs.getBigDecimal("Price"));

            return oi;
        };
    }
}
