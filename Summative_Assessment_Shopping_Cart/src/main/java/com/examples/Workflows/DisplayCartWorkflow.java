package com.examples.Workflows;

import com.examples.*;


public class DisplayCartWorkflow {
    public static void execute(CartService cartService) {
        TerminalUtils.printCart(cartService.getCart());
    }
}
