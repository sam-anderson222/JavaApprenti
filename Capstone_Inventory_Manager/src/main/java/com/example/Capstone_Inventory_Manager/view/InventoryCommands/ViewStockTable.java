package com.example.Capstone_Inventory_Manager.view.InventoryCommands;

import com.example.Capstone_Inventory_Manager.service.InventoryService;
import com.example.Capstone_Inventory_Manager.view.TerminalUtils;

public class ViewStockTable {
    public static void execute(InventoryService is) {
        TerminalUtils.printStockTable(is.getStockTable());
    }
}
