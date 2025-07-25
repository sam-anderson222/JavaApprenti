package org.example.data.impl;

import org.example.data.ItemRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.ItemCategoryMapper;
import org.example.data.mappers.ItemMapper;
import org.example.data.mappers.PaymentTypeMapper;
import org.example.data.mappers.ServerMapper;
import org.example.model.Item;
import org.example.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class MySqlItemRepo implements ItemRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Item getItemById(int id) throws RecordNotFoundException, InternalErrorException {
        try {
            Item item = jdbcTemplate.execute("{CALL get_item_with_id(?)}",
                    (CallableStatementCallback<Item>) cs -> {
                        cs.setInt(1, id);
                        ResultSet rs = cs.executeQuery();

                        Item result = null;
                        if (rs.next()) {
                            result = ItemMapper.itemRowMapper().mapRow(rs, 1);
                            result.setItemCategory(ItemCategoryMapper.itemCategoryRowMapper().mapRow(rs, 1));
                        }

                        return result;
                    } );

            // Ensure item was found from DB.
            if (item == null) {
                throw new EmptyResultDataAccessException(1); // Expected 1 item, but got zero.
            }

            return item;

        } catch (EmptyResultDataAccessException ex) {
            throw new RecordNotFoundException();
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Item> getAllAvailableItems(LocalDate today) throws InternalErrorException {
        try {
            return jdbcTemplate.execute("{CALL get_all_available_items(?)}",
                    (CallableStatementCallback<List<Item>>) cs -> {
                        cs.setDate(1, Date.valueOf(today));
                        ResultSet rs = cs.executeQuery();
                        List<Item> items = new ArrayList<>();


                        while (rs.next()) {
                            Item item = ItemMapper.itemRowMapper().mapRow(rs, 1);
                            item.setItemCategory(ItemCategoryMapper.itemCategoryRowMapper().mapRow(rs, 1));

                            items.add(item);
                        }

                        return items;
                    } );
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Item> getItemsByCategory(LocalDate today, int itemCategoryID) throws InternalErrorException {
        try {
            List<Item> items = jdbcTemplate.execute("{CALL get_all_available_item_from_category(?, ?)}",
                    (CallableStatementCallback<List<Item>>) cs -> {
                        cs.setDate(1, Date.valueOf(today));
                        cs.setInt(2, itemCategoryID);
                        ResultSet rs = cs.executeQuery();
                        List<Item> result = new ArrayList<>();


                        while (rs.next()) {
                            Item item = ItemMapper.itemRowMapper().mapRow(rs, 1);
                            item.setItemCategory(ItemCategoryMapper.itemCategoryRowMapper().mapRow(rs, 1));

                            result.add(item);
                        }

                        return result;
                    } );

            if (items.isEmpty()) {
                throw new InternalErrorException();
            }

            return items;
        } catch (Exception ex) {
            throw new InternalErrorException();
        }
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
