package com.example.Capstone_Inventory_Manager.view.InventoryCommands;

import com.example.Capstone_Inventory_Manager.model.ElectronicProduct;
import com.example.Capstone_Inventory_Manager.model.PerishableProduct;
import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.Result;
import com.example.Capstone_Inventory_Manager.service.InventoryService;
import com.example.Capstone_Inventory_Manager.view.TerminalUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateProduct {
    public static void execute(InventoryService is) {
        // Print products
        TerminalUtils.printStockTable(is.getStockTable());

        // Get product user is trying to update.
        String productID = TerminalUtils.getUserString("Enter ID of product you wish to edit: ");

        if (!is.containsProduct(productID)) {
            TerminalUtils.printMessage(String.format("Error, product with ID %s could not be found! Please try again.", productID));
            return;
        } else if (productID.isEmpty()) {
            TerminalUtils.printMessage("Error, ID is blank! Please try again.");
            return;
        }

        Product originalProduct = is.getProduct(productID).data();

        if (originalProduct == null) {
            TerminalUtils.printMessage("Error, null product. Please try again.");
            return;
        }

        // Reassign productID to ensure case is kept (ex: ID: p001 returns item with ID: P001, then p001 is assigned P001 so case doesn't change when updated.)
        productID = originalProduct.getProductID();

        // Getting other fields
        String productName = TerminalUtils.getUserString("Enter product name (leave blank to keep original name): ");

        if (productName.isEmpty()) {
            productName = originalProduct.getProductName();
        }

        int productQuantity = TerminalUtils.getUserInt("Enter product quantity (enter 0 to keep same): ");


        if (productQuantity == 0) {
            productQuantity = originalProduct.getQuantity();
        } else if (productQuantity < 0) {
            TerminalUtils.printMessage("Error, invalid product quantity. Must be positive integer. Please try again.");
            return;

        }

        BigDecimal productPrice = TerminalUtils.getUserBigDecimal("Enter product price (enter 0 to keep same): ");

        if ((productPrice.compareTo(BigDecimal.ZERO) == 0)) {
            productPrice = originalProduct.getPrice();
        } else if (productPrice.compareTo(BigDecimal.ZERO) <= 0) {
            TerminalUtils.printMessage("Error, invalid product price. Must be positive decimal. Please try again.");
            return;
        }

        // Separate logic for each type of product (Perishable / Electronic)

        Result<Void> result;
        switch (originalProduct.getProductType()) {
            case PERISHABLE: // Perishable case
                LocalDate expirationDate = TerminalUtils.getUserLocalDate("Enter new expiration date in (yyyy-mm-dd) format: ");

                result = is.updateProduct(productID, new PerishableProduct(productID, productName, productQuantity, productPrice, expirationDate));
                break;
            case ELECTRONIC: // Electronic case
                String brand = TerminalUtils.getUserString("Enter company brand (leave blank to keep original brand): ");

                if (brand.isEmpty()) {
                    brand = originalProduct.getExtraInfo();
                }

                result = is.updateProduct(productID, new ElectronicProduct(productID, productName, productQuantity, productPrice, brand));
                break;
            default:
                TerminalUtils.printMessage("Error, invalid product type!");
                return;
        }

        TerminalUtils.printMessage(result.message());
    }
}
