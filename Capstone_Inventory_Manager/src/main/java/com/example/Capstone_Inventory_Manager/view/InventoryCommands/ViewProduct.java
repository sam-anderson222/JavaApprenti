package com.example.Capstone_Inventory_Manager.view.InventoryCommands;

import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.Result;
import com.example.Capstone_Inventory_Manager.service.InventoryService;
import com.example.Capstone_Inventory_Manager.view.TerminalUtils;

public class ViewProduct {
    public static void execute(InventoryService is) {

        // Get user input
        String userInput = TerminalUtils.getUserString("Enter a product ID or name: ");

        Result<Product> productSearchResult = is.getProduct(userInput);

        // Print error message if product is not found.
        if (!productSearchResult.isSuccess()) {
            TerminalUtils.printMessage(productSearchResult.getMessage());
            return;
        }

        // Print product info.
        TerminalUtils.printProduct(productSearchResult.getData());


    }
}
