package com.examples.Workflows;

import com.examples.*;


public class DisplayCartWorkflow {
    public static void execute(CartService cartService) {
        if (cartService.getCart().isEmpty()) { // Print message is cart is empty.
            TerminalUtils.printMessage("(No items in cart. Please add item(s) before trying again.)");
            return;
        }

        TerminalUtils.printCart(cartService.getCart());
    }
}
