package com.example.Capstone_Inventory_Manager.repository;

import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.Result;

import java.math.BigDecimal;
import java.util.HashMap;

public interface InventoryRepository {
    Result<Void> addStock(String productID, Product product);

    Result<Void> removeStock(String productIdOrName, int quantityToRemove);

    Result<Void> updatePrice(String productIdOrName, BigDecimal newPrice);

    Result<Product> getProduct(String productIdOrName); // Can search on either productID or productName.

    HashMap<String, Product> getStockTable();
}
