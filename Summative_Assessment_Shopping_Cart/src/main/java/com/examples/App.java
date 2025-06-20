package com.examples;

import com.examples.DataObjects.CartEntry;
import com.examples.Workflows.AddItemWorkflow;
import com.examples.Workflows.CheckoutWorkflow;
import com.examples.Workflows.DisplayCartWorkflow;
import com.examples.Workflows.RemoveItemWorkflow;

public class App {
    public static void main(String[] args) {
        CartService cartService = new CartService(); // Holds the user's cart.
        boolean runProgram = true;


        // Main app loop
        while (runProgram) {
            TerminalUtils.printMenu();
            String userInput = TerminalUtils.getUserStr("Enter an option: ");

            switch (userInput) {
                case "1": // Display the cart
                    DisplayCartWorkflow.execute(cartService);
                    break;
                case "2": // Remove item from cart
                    RemoveItemWorkflow.execute(cartService);
                    break;
                case "3": // Add item from cart
                    AddItemWorkflow.execute(cartService);
                    break;
                case "4": // Checkout
                    CheckoutWorkflow.execute(cartService);
                    break;
                case "5":// Exit program
                    runProgram = false;
                    break;
                default:
                    TerminalUtils.printMessage("Error, unknown choice selected. Please try again.");
                    break;
            }
        }

        // Thank you message / end of program
        TerminalUtils.printMessage("\n(Thank you for using the shopping cart application!)");
    }
}
