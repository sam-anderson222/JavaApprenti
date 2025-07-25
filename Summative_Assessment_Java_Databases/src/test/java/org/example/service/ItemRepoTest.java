package org.example.service;

import org.example.data.ItemRepo;
import org.example.data.OrderRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Item;
import org.example.model.ItemCategory;
import org.example.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepoTest {
    @Autowired
    private ItemRepo itemRepo;

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
    void getAllItemCategories_getsAllCategories() throws InternalErrorException {
        List<ItemCategory> categories = itemRepo.getAllItemCategories();

        assertEquals(7, categories.size());
    }

    @Test
    void getAllAvailableItems_getsAllItems() throws InternalErrorException {
        List<Item> items = itemRepo.getAllAvailableItems(LocalDate.now());

        assertEquals(29, items.size());
    }

    @Test
    void getAllAvailableItemsFromCategory_getsAllItems() throws InternalErrorException {
        List<Item> items = itemRepo.getItemsByCategory(LocalDate.now(), 1);

        assertEquals(5, items.size());
    }

    @Test
    void getAllAvailableItemsFromCategory_invalidCategory_throwsException(){
        assertThrows(InternalErrorException.class, () ->
        {
            itemRepo.getItemsByCategory(LocalDate.now(), -1);
        });
    }

    @Test
    void getItemById_returnsItem() throws RecordNotFoundException, InternalErrorException {
        Item i = itemRepo.getItemById(2);

        assertEquals("Chicken Wings", i.getItemName());
    }

    @Test
    void getItemById_invalidID_throwsException() {
        assertThrows(RecordNotFoundException.class, () ->
        {
            itemRepo.getItemById(-10);
        });
    }
}