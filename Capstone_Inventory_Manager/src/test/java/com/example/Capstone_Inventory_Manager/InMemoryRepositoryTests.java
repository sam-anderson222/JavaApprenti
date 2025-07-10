package com.example.Capstone_Inventory_Manager;

import com.example.Capstone_Inventory_Manager.repository.InMemoryInventoryRepository;
import com.example.Capstone_Inventory_Manager.service.InventoryService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTests {
    private InventoryService is;

    @BeforeEach
    public void setUp() {
        is = new InventoryService(new InMemoryInventoryRepository());
    }

    @Test
    void createsInventoryTableOnCreation() {
        assertNotNull(is.getStockTable());
    }

}