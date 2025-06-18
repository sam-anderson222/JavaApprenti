package com.examples;

import com.examples.Workflows.DisplayCartWorkflow;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CartService cartService = new CartService(); // Holds the shopper's cart.
        boolean runShoppingCartProgram = true;

        while (runShoppingCartProgram) {
            TerminalUtils.printMenu();
            String userChoice = TerminalUtils.getUserStr("Enter an option: ");
            switch (userChoice) {
                case "1": // Display Cart Workflow
                    DisplayCartWorkflow.execute(cartService);
                    break;
                case "2": // Remove Item Workflow
                    break;
                case "3": // Add Item Workflow
                    break;
                case "4": // Checkout Workflow
                    break;
                case "5": // Exit Program
                    runShoppingCartProgram = false;
                    break;
                default:
                    TerminalUtils.printMessage("Error - Unknown input received. Please try again.");
                    break;
            }
        }

        // Thank you for using message
        TerminalUtils.printMessage("\n(Thank you for using the shopping cart application!)");
    }
}
