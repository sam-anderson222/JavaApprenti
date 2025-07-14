package com.example.Capstone_Inventory_Manager.repository;

import com.example.Capstone_Inventory_Manager.model.ElectronicProduct;
import com.example.Capstone_Inventory_Manager.model.PerishableProduct;
import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.Result;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public class InMemoryInventoryRepository implements InventoryRepository{
    private final HashMap<String, Product> inventory;

    public InMemoryInventoryRepository() {
        inventory = new HashMap<>();

        // Sample Perishables
        inventory.put("P001", new PerishableProduct("P001", "Apple", 12, new BigDecimal("1.99"), LocalDate.parse("2025-07-12")));
        inventory.put("P002", new PerishableProduct("P002", "Milk", 20, new BigDecimal("2.99"), LocalDate.parse("2025-07-14")));
        inventory.put("P003", new PerishableProduct("P003", "Eggs", 15, new BigDecimal("3.99"), LocalDate.parse("2025-07-21")));


        // Sample Electronics
        inventory.put("E001", new ElectronicProduct("E001", "TV", 8, new BigDecimal("249.99"), "LG"));
        inventory.put("E002", new ElectronicProduct("E002", "Headphones", 10, new BigDecimal("499.99"), "Sony"));
        inventory.put("E003", new ElectronicProduct("E003", "Laptop", 13, new BigDecimal("599.99"), "Microsoft"));

    }




    @Override
    public Result<Void> addProduct(String productID, Product product) {
        if (containsProductID(productID)) { // Checking for reasons why method call could be invalid.
            return new Result<>(false, String.format("Error, product with ID %s already exists.", productID), null);
        } else if (productID == null) {
            return new Result<>(false, "Error, null product ID.", null);
        } else if (productID.isEmpty()) {
            return new Result<>(false, "Error, blank product ID.", null);
        } else if (!product.isValid()) {
            return new Result<>(false, "Error, invalid product quantity / price / name received.", null);
        }

        inventory.put(productID, product);
        return new Result<>(true, String.format("%s added.", productID), null);
    }

    @Override
    public Result<Void> removeProduct(String productID, int quantityToRemove) {
        Product p = getProduct(productID).data(); // We get this product so we can ensure it exists.

        if (productID == null) {
            return new Result<>(false, "Error, null product ID.", null);
        } else if (productID.isEmpty()) {
            return new Result<>(false, "Error, blank product ID.", null);
        } else if (p == null) { // If product isn't found
            return new Result<>(false, String.format("Error, product with ID %s not found.", productID), null);
        } else if (quantityToRemove <= 0) {
            return new Result<>(false, "Error, cannot remove non-positive quantity", null);
        }

        p.setQuantity(p.getQuantity() - quantityToRemove); // Reduce quantity

        // If quantity is less than 0, then remove product from stock
        if (p.getQuantity() <= 0) {
            inventory.remove(p.getProductID());
            return new Result<>(true, String.format("%s successfully removed.", p.getProductName()), null);
        } else {
            return new Result<>(true, String.format("%d %s removed.", quantityToRemove, p.getProductName()), null);
        }
    }

    @Override
    public Result<Void> updateProduct(String productID, Product newProduct) {
        if (productID == null) {
            return new Result<>(false, "Error, null product ID.", null);
        } else if (productID.isEmpty()) {
            return new Result<>(false, "Error, blank product ID.", null);
        } else if (!containsProductID(productID)) {
            return new Result<>(false, String.format("Error, product with ID %s doesn't exist.", productID), null);
        } else if (!newProduct.isValid()) {
            return new Result<>(false, "Error, invalid updated product data received.", null);
        }

        inventory.replace(productID, newProduct);
        return new Result<>(true, "Item successfully updated.", null);
    }

    @Override
    public Result<Product> getProduct(String productIdOrName) {
        // Try to find product via ID or name
        for (Product p : inventory.values()) {
          if (p.getProductID().equalsIgnoreCase(productIdOrName) || p.getProductName().equalsIgnoreCase(productIdOrName)) {
              return new Result<Product>(true, "", p);
          }
        }

        // Return null result if product not found.
        return new Result<Product>(false, String.format("'%s' not found! Please try again.", productIdOrName), null);
    }

    @Override
    public HashMap<String, Product> getStockTable() {
        return inventory;
    }

    @Override
    public boolean containsProductID(String productID) {
        for (String id : inventory.keySet()) {
            // If key already exists, return falling result.
            if (id.equalsIgnoreCase(productID))
                return true;
        }

        return false;
    }
}
