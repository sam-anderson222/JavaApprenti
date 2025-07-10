package com.example.Capstone_Inventory_Manager.config;

import com.example.Capstone_Inventory_Manager.repository.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class InventoryRepositoryConfig {

    @Value("${inventory.repository.type:memory}")
    private String repositoryType;

    @Bean // Will search for instances of InventoryRepository and inject automatically
    public InventoryRepository inventoryRepository() {
        return switch (repositoryType.toLowerCase()) {
            case "csv" -> new CsvInventoryRepository();
            case "memory" -> new InMemoryInventoryRepository();
            default ->
                    throw new IllegalArgumentException("Invalid repository setting: " + repositoryType + ". Valid options are: 'memory', 'csv'");
        };
    }
}
