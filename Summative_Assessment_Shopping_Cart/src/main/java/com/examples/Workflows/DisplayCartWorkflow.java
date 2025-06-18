package com.examples.Workflows;

import com.examples.CartService;
import com.examples.TerminalUtils;

public class DisplayCartWorkflow {
    public static void execute(CartService cartService) {
        if (cartService.getCart().isEmpty()) {
            TerminalUtils.printMessage("(Cart currently empty)");
        } else {
            TerminalUtils.printCart(cartService.getCart());
        }
    }
}
