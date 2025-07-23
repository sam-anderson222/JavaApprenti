package org.example.data.impl;

import org.example.data.ItemRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.ItemCategoryMapper;
import org.example.data.mappers.ItemMapper;
import org.example.data.mappers.PaymentTypeMapper;
import org.example.model.Item;
import org.example.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Primary
public class MySqlItemRepo implements ItemRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Item getItemById(int id) throws RecordNotFoundException, InternalErrorException {
        return null;
    }

    @Override
    public List<Item> getAllAvailableItems(LocalDate today) throws InternalErrorException {
        String sql = "SELECT ItemID, item.ItemCategoryID, ItemName, ItemDescription, StartDate, EndDate, UnitPrice, ItemCategoryName FROM item \n" +
                "INNER JOIN itemcategory ic ON item.ItemCategoryID = ic.ItemCategoryID\n" +
                "WHERE (? BETWEEN StartDate AND EndDate) OR\n" +
                "(EndDate IS NULL AND ? >= StartDate)";

        try {
            return jdbcTemplate.query(sql, ItemMapper.itemRowMapper(), today, today);
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Item> getItemsByCategory(LocalDate today, int itemCategoryID) throws InternalErrorException {
        return List.of();
    }

    @Override
    public List<ItemCategory> getAllItemCategories() throws InternalErrorException {
        String sql = "SELECT * FROM itemcategory";

        try {
            return jdbcTemplate.query(sql, ItemCategoryMapper.itemCategoryRowMapper());
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }
}
