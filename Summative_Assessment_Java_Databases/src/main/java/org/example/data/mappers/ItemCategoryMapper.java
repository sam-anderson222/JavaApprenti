package org.example.data.mappers;

import org.example.model.ItemCategory;
import org.example.model.PaymentType;
import org.springframework.jdbc.core.RowMapper;

public class ItemCategoryMapper {
    public static RowMapper<ItemCategory> itemCategoryRowMapper() {
        return (rs, rowNum) -> {
            ItemCategory ic = new ItemCategory();

            ic.setItemCategoryID(rs.getInt("ItemCategoryID"));
            ic.setItemCategoryName(rs.getString("ItemCategoryName"));

            return ic;
        };
    }
}
