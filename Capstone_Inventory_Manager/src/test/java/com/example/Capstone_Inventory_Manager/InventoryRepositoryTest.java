package com.example.Capstone_Inventory_Manager;

import com.example.Capstone_Inventory_Manager.model.ElectronicProduct;
import com.example.Capstone_Inventory_Manager.model.PerishableProduct;
import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.Result;
import com.example.Capstone_Inventory_Manager.repository.CsvInventoryRepository;
import com.example.Capstone_Inventory_Manager.repository.InMemoryInventoryRepository;
import com.example.Capstone_Inventory_Manager.repository.InventoryRepository;
import com.example.Capstone_Inventory_Manager.service.InventoryService;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {
    private InventoryService is;
    String testFilePath = "data/test/inventory-test.csv";

    @BeforeEach
    public void setUp() {
        File file = new File(testFilePath);

        // Clear test file before each test.
        if (file.exists()) {
            file.delete();
        }

        // Create inventory service.
        is = new InventoryService(new CsvInventoryRepository(testFilePath));

        // Create Sample Data
        is.addProduct("P001", new PerishableProduct("P001", "Apple", 20, new BigDecimal("2.99"), LocalDate.parse("2025-07-17")));
        is.addProduct("E001", new ElectronicProduct("E001", "TV", 8, new BigDecimal("249.99"), "LG"));



    }

    @Test
    void canGetInventoryTableAfterCreation() {
        assertNotNull(is.getStockTable());
    }

    @Test
    void canSaveAndReloadFromFile() {
        Product p = new PerishableProduct("P002", "Pear", 20, new BigDecimal("2.99"), LocalDate.parse("2025-07-17"));
        is.addProduct("P002", p);

        InventoryService is2 = new InventoryService(new CsvInventoryRepository(testFilePath));

        assertEquals(3, is2.getStockTable().size()); // Should be three products in stock table.
        assertEquals(p.toString(), is2.getProduct("P002").data().toString());
    }

    @Test
    void getProduct_getProductByID() {
        Result<Product> expected = new Result<>(true, "", new PerishableProduct("P001", "Apple", 20, new BigDecimal("2.99"), LocalDate.parse("2025-07-17")));
        Result<Product> actual = is.getProduct("P001");

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getProduct_getProductByName() {
        Result<Product> expected = new Result<>(true, "", new PerishableProduct("P001", "Apple", 20, new BigDecimal("2.99"), LocalDate.parse("2025-07-17")));
        Result<Product> actual = is.getProduct("Apple");

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getProduct_ProductNotFound_ReturnsFalseResult() {
        Result<Product> expected = new Result<Product>(false, "'Invalid' not found! Please try again.", null);
        Result<Product> actual = is.getProduct("Invalid");

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void addProduct_NullID_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, null product ID.", null);
        Result<Void> actual = is.addProduct(null, null);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void addProduct_EmptyID_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, blank product ID.", null);
        Result<Void> actual = is.addProduct("", null);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void addProduct_InvalidProduct_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, invalid product received.", null);
        // Invalid product as has negative quantity / price
        Result<Void> actual = is.addProduct("E002", new ElectronicProduct("E002", "TV", -10, new BigDecimal("-100.99"), "LG"));

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void removeProduct_NullID_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, null product ID.", null);
        Result<Void> actual = is.removeProduct(null, 2);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void removeProduct_EmptyID_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, blank product ID.", null);
        Result<Void> actual = is.removeProduct("", 2);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void removeProduct_NotFoundItem_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, product with ID P003 not found.", null);
        Result<Void> actual = is.removeProduct("P003", 2);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void removeProduct_NonPositiveQuantity_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, cannot remove non-positive quantity", null);
        Result<Void> actual = is.removeProduct("P001", -2);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void removeProduct_RemoveSomeOfProduct_ReturnsTrueResult() {
        Result<Void> expected = new Result<>(true, "2 Apple removed.", null);
        Result<Void> actual = is.removeProduct("P001", 2);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void removeProduct_RemoveAllOfProduct_ReturnsTrueResult() {
        Result<Void> expected = new Result<>(true, "Apple successfully removed.", null);
        Result<Void> actual = is.removeProduct("P001", 20);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void updateProduct_NullID_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, null product ID.", null);
        Result<Void> actual = is.updateProduct(null, null);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void updateProduct_EmptyID_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, blank product ID.", null);
        Result<Void> actual = is.updateProduct("", null);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void updateProduct_NotFoundItem_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, product with ID P003 doesn't exist.", null);
        Result<Void> actual = is.updateProduct("P003", null);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void updateProduct_InvalidProduct_ReturnsFalseResult() {
        Result<Void> expected = new Result<>(false, "Error, invalid updated product data received.", null);
        // Invalid product as has negative quantity / price
        Result<Void> actual = is.updateProduct("P001", new PerishableProduct("P001", "Apple", -10, new BigDecimal("-1.99"), LocalDate.parse("2025-05-05")));

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void updateProduct_ValidProduct_ReturnsTrue() {
        Result<Void> expected = new Result<>(true, "Item successfully updated.", null);
        // Invalid product as has negative quantity / price
        Result<Void> actual = is.updateProduct("P001", new PerishableProduct("P001", "Apple", 10, new BigDecimal("1.99"), LocalDate.parse("2025-05-05")));

        assertEquals(expected.toString(), actual.toString());
    }
}