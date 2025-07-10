package com.example.Capstone_Inventory_Manager.view;

import com.example.Capstone_Inventory_Manager.service.InventoryService;
import com.example.Capstone_Inventory_Manager.view.InventoryCommands.ViewStockTable;
import org.springframework.stereotype.Component;

@Component
public class Inventory {

    private final InventoryService inventoryService;

    public Inventory(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void run() {
        boolean runProgram = true;

        while (runProgram) {
            TerminalUtils.printMainMenu();
            String userInput = TerminalUtils.getUserString("Enter option: ");

            switch (userInput) {
                case "1": // Add product
                    break;
                case "2": // Remove product
                    break;
                case "3": // Update product
                    break;
                case "4": // Get and print single product
                    break;
                case "5": // Print entire stock
                    ViewStockTable.execute(inventoryService);
                    break;
                case "6": // Exit program
                    runProgram = false;
                    break;
                default:

                    break;
            }
        }

        // Print goodbye message when program is exited.
        TerminalUtils.printGoodbyeMessage();
    }
}
