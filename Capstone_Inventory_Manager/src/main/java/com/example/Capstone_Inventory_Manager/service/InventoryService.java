package com.example.Capstone_Inventory_Manager.service;


import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.Result;
import com.example.Capstone_Inventory_Manager.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Result<Void> addStock(String productID, Product product) {
        return inventoryRepository.addProduct(productID, product);
    }

    public Result<Void> removeStock(String productID, int quantityToRemove) {
        return inventoryRepository.removeProduct(productID, quantityToRemove);
    }

    public Result<Void> updateProduct(String productID, Product newProduct) {
        return inventoryRepository.updateProduct(productID, newProduct);
    }

    public Result<Product> getProduct(String productIdOrName) {
        return inventoryRepository.getProduct(productIdOrName);
    }

    public HashMap<String, Product> getStockTable() {
        return inventoryRepository.getStockTable();
    }

    public boolean containsProduct(String productID) {
        return inventoryRepository.containsProductID(productID);
    }

}
