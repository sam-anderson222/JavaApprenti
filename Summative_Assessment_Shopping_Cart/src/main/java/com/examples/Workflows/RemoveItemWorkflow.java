package com.examples.Workflows;

import com.examples.CartService;
import com.examples.DataObjects.Result;
import com.examples.TerminalUtils;

public class RemoveItemWorkflow {
    public static void execute(CartService cartService) {
        if (cartService.getCart().isEmpty()) { // return if shopping cart is empty.
            TerminalUtils.printMessage("(Shopping cart is empty. Nothing to remove)");
            return;
        }

        // Print current items in cart
        TerminalUtils.printCart(cartService.getCart());

        // Get user index of item they wish to remove
        int itemIndex = TerminalUtils.getUserInt("Enter the index number of the item you wish to remove: ");
        int itemQuantityToRemove = TerminalUtils.getUserInt("Enter the number of units you wish to remove: ");

        Result<String> itemRemovalResult = cartService.removeItemFromCart(itemIndex, itemQuantityToRemove);

        // Print success or error message depending on if the item removal was successful or not.
        TerminalUtils.printMessage(itemRemovalResult.getData());

    }
}
