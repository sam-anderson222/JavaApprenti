package org.example.data.mappers;

import org.example.model.Item;
import org.example.model.ItemCategory;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;

// We are joining item on itemCategory, so the ItemCategory object will also be created here.
public class ItemMapper {
    public static RowMapper<Item> itemRowMapper() {
        return (rs, rowNum) -> {
            Item item = new Item();

            item.setItemID(rs.getInt("ItemID"));
            item.setItemCategoryID(rs.getInt("ItemCategoryID"));
            item.setItemName(rs.getString("ItemName"));
            item.setItemDescription(rs.getString("ItemDescription"));
            item.setStartDate(rs.getObject("StartDate", LocalDate.class));
            item.setEndDate(rs.getObject("EndDate", LocalDate.class));
            item.setUnitPrice(rs.getBigDecimal("UnitPrice"));

            item.setItemCategory(new ItemCategory(item.getItemCategoryID(), rs.getString("ItemCategoryName")));

            return item;
        };
    }
}
