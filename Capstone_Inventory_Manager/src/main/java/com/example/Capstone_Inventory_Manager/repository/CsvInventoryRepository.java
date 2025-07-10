package com.example.Capstone_Inventory_Manager.repository;

import com.example.Capstone_Inventory_Manager.model.PerishableProduct;
import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.ProductTypes;
import com.example.Capstone_Inventory_Manager.model.Result;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;

public class CsvInventoryRepository implements InventoryRepository{

    private final HashMap<String, Product> inventory;

    public CsvInventoryRepository() {
        inventory = new HashMap<>();
    }

    @Value("${inventory.csv.filepath:data/inventory.csv}")
    private String filePath;

    @PostConstruct
    public void init() {
        load(); // Loads all data from file after Spring is done setting up.
    }


    @Override
    public Result<Void> addStock(String productID, Product product) {
        return null;
    }

    @Override
    public Result<Void> removeStock(String productIdOrName, int quantityToRemove) {
        return null;
    }

    @Override
    public Result<Void> updateProduct(String productIdOrName, Product newProduct) {
        return null;
    }

    @Override
    public Result<Product> getProduct(String productIdOrName) {
        return null;
    }

    @Override
    public HashMap<String, Product> getStockTable() {
        return inventory;
    }

    @Override
    public boolean containsProduct(String productID) {
        return true;
    }

    private void load() {
        File file = new File(filePath);
        if (!file.exists()) {
            return; // Do nothing if file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + filePath, e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error parsing data from file: " + filePath, e);
        }
    }

    private void save() {
        try(PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Product product : inventory.values()) {
                writer.printf("%s,%s,%d,%.2f,%s",
                        product.getProductID(),
                        product.getProductName(),
                        product.getQuantity(),
                        product.getPrice(),
                        product.getProductType());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
