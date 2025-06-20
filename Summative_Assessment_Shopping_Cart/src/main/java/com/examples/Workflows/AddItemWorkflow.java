package com.examples.Workflows;

import com.examples.CartService;
import com.examples.DataObjects.Product;
import com.examples.DataObjects.Result;
import com.examples.TerminalUtils;

public class AddItemWorkflow {
    public static void execute(CartService cartService) {
        TerminalUtils.printProductTable(cartService.getProductTable()); // Show all the products.

        String productID = TerminalUtils.getUserStr("Enter a product ID: ");

        // Check if product ID is valid. .getData() of this result gives the product the user is trying to purchase.
        if (!cartService.getProductWithID(productID).getStatus()) { // If product was not found
            TerminalUtils.printMessage("Error, item with this ID not found! Please try again.");
            return;
        }

        int productQuantity = TerminalUtils.getUserInt("Enter quantity you'd like to purchase: ");

        Result<String> addItemToCartResult = cartService.addItemToCart(productID, productQuantity);

        TerminalUtils.printMessage(addItemToCartResult.getData());



    }
}
