package com.examples.Workflows;

import com.examples.CartService;
import com.examples.TerminalUtils;

public class AddItemWorkflow {
    public static void execute(CartService cartService) {
        TerminalUtils.printProductTable(cartService.getProductTable());

        String productID = TerminalUtils.getUserStr("Enter a product ID: ");

    }
}
