package com.example.Capstone_Inventory_Manager.repository;

import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.Result;

import java.math.BigDecimal;
import java.util.HashMap;

public interface InventoryRepository {
    Result<Void> addProduct(String productID, Product product);

    Result<Void> removeProduct(String productID, int quantityToRemove);

    Result<Void> updateProduct(String productID, Product newProduct);

    Result<Product> getProduct(String productIdOrName); // Can search on either productID or productName.

    HashMap<String, Product> getStockTable();

    boolean containsProductID(String productID); // Have to create custom contains method, so can check productID while also ignoring case.
}
