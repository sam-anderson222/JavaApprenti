package com.example.Capstone_Inventory_Manager;

import com.example.Capstone_Inventory_Manager.model.PerishableProduct;
import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.repository.InMemoryInventoryRepository;
import com.example.Capstone_Inventory_Manager.service.InventoryService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {
    private InventoryService is;

    @BeforeEach
    public void setUp() {
        is = new InventoryService(new InMemoryInventoryRepository());
    }

    @Test
    void createsInventoryTableOnCreation() {
        assertNotNull(is.getStockTable());
    }

    @Test
    void canGetValidProductViaID() {
        Product actual = is.getProduct("P001").getData();
        Product expected = new PerishableProduct("P001", "Apple", 12, new BigDecimal("1.99"), LocalDate.parse("2025-07-12"));
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void canGetValidProductViaName() {
        Product actual = is.getProduct("Apple").getData();
        Product expected = new PerishableProduct("P001", "Apple", 12, new BigDecimal("1.99"), LocalDate.parse("2025-07-12"));
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void returnNullResult() {
        Product actual = is.getProduct("Invalid product id / name").getData();
        assertNull(actual);
    }

    @Test
    void addingProductWithIDThatAlreadyExists() {
        boolean success = is.addStock("P001", null).isSuccess();
        assertFalse(success);
    }

}