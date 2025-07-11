package com.example.Capstone_Inventory_Manager.view.InventoryCommands;

import com.example.Capstone_Inventory_Manager.model.ElectronicProduct;
import com.example.Capstone_Inventory_Manager.model.PerishableProduct;
import com.example.Capstone_Inventory_Manager.model.Result;
import com.example.Capstone_Inventory_Manager.service.InventoryService;
import com.example.Capstone_Inventory_Manager.view.TerminalUtils;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddProduct {
    public static void execute(InventoryService is) {
        // Header
        System.out.println();

        String productID = TerminalUtils.getUserString("Enter product ID: ");

        // If product with ID already in stock table, then boot user back to main menu.
        if (is.containsProduct(productID)) {
            TerminalUtils.printMessage(String.format("Error, product with ID %s already exists! Please try again.", productID));
            return;
        } else if (productID.isEmpty()) {
            TerminalUtils.printMessage("Error, ID is blank! Please try again.");
            return;
        }

        // Getting other fields
        String productName = TerminalUtils.getUserString("Enter product name: ");

        if (productName.isEmpty()) {
            TerminalUtils.printMessage("Error, invalid product. Name cannot be blank. Please try again.");
            return;
        }

        int productQuantity = TerminalUtils.getUserInt("Enter product quantity: ");

        if (productQuantity <= 0) {
            TerminalUtils.printMessage("Error, invalid product quantity. Must be positive integer. Please try again.");
            return;
        }

        BigDecimal productPrice = TerminalUtils.getUserBigDecimal("Enter product price: ");

        if (productPrice.compareTo(BigDecimal.ZERO) <= 0) {
            TerminalUtils.printMessage("Error, invalid product price. Must be positive decimal. Please try again.");
            return;
        }

        // Separate logic for each type of product (Perishable / Electronic)
        TerminalUtils.printProductTypes();
        String productType = TerminalUtils.getUserString("Enter option: ");

        Result<Void> result;
        switch (productType) {
            case "1": // Perishable case
                LocalDate expirationDate = TerminalUtils.getUserLocalDate("Enter expiration date in (yyyy-mm-dd) format: ");
                result = is.addProduct(productID, new PerishableProduct(productID, productName, productQuantity, productPrice, expirationDate));
                break;
            case "2": // Electronic case
                String brand = TerminalUtils.getUserString("Enter company brand: ");
                result = is.addProduct(productID, new ElectronicProduct(productID, productName, productQuantity, productPrice, brand));
                break;
            default:
                TerminalUtils.printMessage("Error, invalid product type!");
                return;
        }

        TerminalUtils.printMessage(result.message());

    }
}
