package com.example.Capstone_Inventory_Manager.view.InventoryCommands;

import com.example.Capstone_Inventory_Manager.model.Result;
import com.example.Capstone_Inventory_Manager.service.InventoryService;
import com.example.Capstone_Inventory_Manager.view.TerminalUtils;

public class RemoveProduct {
    public static void execute(InventoryService is) {
        // Print products
        TerminalUtils.printStockTable(is.getStockTable());

        // Get product to remove and quantity to remove.
        String productID = TerminalUtils.getUserString("Enter productID you wish to remove quantity for: ");

        if (!is.containsProduct(productID)) {
            TerminalUtils.printMessage(String.format("Error, product with ID %s could not be found! Please try again.", productID));
            return;
        } else if (productID.isEmpty()) {
            TerminalUtils.printMessage("Error, ID is blank! Please try again.");
            return;
        }

        int quantity = TerminalUtils.getUserInt("Enter quantity to remove: ");

        if (quantity <= 0) {
            TerminalUtils.printMessage("Error, cannot remove a non-positive quantity.");
            return;
        }

        Result<Void> result = is.removeProduct(productID, quantity);
        TerminalUtils.printMessage(result.message());

    }
}
