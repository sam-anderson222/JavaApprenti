package com.examples.Workflows;

import com.examples.CartService;
import com.examples.TerminalUtils;

public class CheckoutWorkflow {
    public static void execute(CartService cartService) {
        if (cartService.getCart().isEmpty()) { // Print message is cart is empty.
            TerminalUtils.printMessage("(Error, no items in cart to check out. Please add item(s) before trying again.)");
            return;
        }

        // Print checkout menu
        TerminalUtils.printCheckOut(cartService);

        String confirmCheckout = TerminalUtils.getUserStr("Pay & Checkout (y/n): ");

        if (confirmCheckout.equalsIgnoreCase("y")) {
            cartService.clearCart();
            TerminalUtils.printMessage("(You've been checkout, thanks for shopping with us!)");
        }
    }
}
