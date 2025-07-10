package com.example.Capstone_Inventory_Manager.view.InventoryCommands;

import com.example.Capstone_Inventory_Manager.service.InventoryService;
import com.example.Capstone_Inventory_Manager.view.TerminalUtils;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class AddProduct {
    public static void execute(InventoryService is) {
        // Header
        System.out.println("");

        String productID = TerminalUtils.getUserString("Enter product ID: ");

        // If product with ID already in stock table, then boot user back to main menu.
        if (is.containsProduct(productID)) {
            TerminalUtils.printMessage(String.format("Error, product with ID %s already exists! Please try again.", productID));
            return;
        }

        // Getting other fields
        String productName = TerminalUtils.getUserString("Enter product name: ");

        int productQuantity = TerminalUtils.getUserInt("Enter product quantity: ");

        BigDecimal productPrice = TerminalUtils.getUserBigDecimal("Enter product price: ");

        // Separate logic for each type of product (Perishable / Electronic)
        TerminalUtils.printProductTypes();
        String productType = TerminalUtils.getUserString("Enter option: ");
        switch (productType) { // Left of here EOD Thursday. Finish adding logic for adding each type of child product!!!
            case "1":
                System.out.println("Perishable");
                break;
            case "2":
                System.out.println("Electronic");
                break;
            default:
                TerminalUtils.printMessage("Error, invalid product type!");
                return;
        }

    }
}
