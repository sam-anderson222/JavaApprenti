import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        double productPrice = 4.99;
        int productQuantity; // This variable is now inputted by the user through the console (Scanner object)
        double totalCost; // Cost of order.
        double totalCostWithTax, totalCostAfterDiscount, shippingCost, finalTotalCost;
        String taxExempt, shippingType, promoCode, shippingAddress, productSize;

        // Array declaration (Added for arrays exercise)
        String[] shippingAddresses = new String[] {"123 Oak St.", "435 Elm Rd.", "834 Pine Ln."};
        String[] productSizes = new String[] {"Small", "Medium", "Large"};

        // discounts, shippingType, taxes
        double taxRate = .07;
        double hundredDollarDiscount = .05;
        double fiveHundredDollarDiscount = .10;
        double standardShipping = 2.00;
        double overnightShipping = 10.00;
        double twoDayShipping = 5.00;


        // Added loop for Loops Exercise

            System.out.print("\n(Welcome to the shopping cart app!)\n");

        do {
            // Prompt for shippingType address
            displayChoices(shippingAddresses); // Replaced for-loop with static method.
            while (true) {
                try {
                    shippingAddress = shippingAddresses[promptUserForInt("Enter shipping address? (1/2/3)\n>> ") - 1];
                    break;
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Invalid choice! Please enter a valid menu option.");
                }
            }


            // Prompt for product size
            displayChoices(productSizes);
            while (true) {
                try {
                    productSize = productSizes[promptUserForInt("Enter product size? (1/2/3)\n>> ") - 1];
                    break;
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Invalid choice! Please enter a valid menu option.");
                }
            }

            // Prompt for product quantity
            productQuantity = promptUserForInt("Enter number of unit you wish to purchase\n>> ");

            // Prompt for tax exempt
            taxExempt = promptUserForString("Are you tax-exempt? (y/n)\n>> ");
            // Prompt for shippingType
            shippingType = promptUserForString("Shipping? (standard / overnight / two-day)\n>> ");
            // Prompt for promo code
            promoCode = promptUserForString("Promo code for free shipping (only applies for standard shipping)?\n>> ");

        } while(!promptUserForString("Confirm order? (y/n)\n>> ").equals("y"));


        // Calculation for price.
        totalCost = productPrice * productQuantity;
        // Tax calculations
        if (taxExempt.equals("n")) { // Only apply tax if customer isn't tax-exempt.
            totalCostWithTax = totalCost + (totalCost * taxRate);
        } else {
            totalCostWithTax = totalCost;
        }

        // Discounts
        if (totalCostWithTax >= 500) {
            totalCostAfterDiscount = totalCostWithTax - (totalCostWithTax * fiveHundredDollarDiscount);
        } else if (totalCost >= 100) {
            totalCostAfterDiscount = totalCostWithTax - (totalCostWithTax * hundredDollarDiscount);
        } else {
            totalCostAfterDiscount = totalCostWithTax;
        }


        // Added shippingType costs / promo codes for free shippingType
        switch (shippingType) {
            case "standard":
                shippingCost = standardShipping;
                if (promoCode.equals("FREE")) {
                    shippingCost = 0;
                }
                break;
            case "overnight":
                shippingCost = overnightShipping;
                break;
            case "two-day":
                shippingCost = twoDayShipping;
                break;
            default:
                shippingCost = 0;
                System.out.println("Error, invalid shipping cost.");
                break;
        }

        finalTotalCost = totalCostAfterDiscount + shippingCost;

        // Print details
        System.out.println("\nDetails:");
        System.out.println("Shipping Address: " + shippingAddress);
        System.out.println("Product Price: " + productPrice);
        System.out.println("Product Quantity: " + productQuantity);
        System.out.println("Product Size: " + productSize);
        System.out.println("Tax-exempt: " + taxExempt);
        System.out.println("Shipping: " + shippingType);
        System.out.println("Promo code: " + promoCode);
        System.out.printf("Sub-total: $%.2f%n", totalCost);
        System.out.printf("Total w/ Tax: $%.2f%n", totalCostWithTax);
        System.out.printf("Total After Discount: $%.2f%n", totalCostAfterDiscount);
        System.out.printf("Shipping Costs: $%.2f%n", shippingCost);
        System.out.printf("Final Total: $%.2f%n", finalTotalCost);
        System.out.println("Bye");

    }

    private static void displayChoices(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.printf("(%d): %s%n", i+1, choices[i]);
        }
    }

    private static String promptUserForString(String prompt) {
        Scanner io = new Scanner(System.in);
        System.out.print(prompt);
        return io.nextLine();
    }

    private static int promptUserForInt(String prompt) {
        Scanner io = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(io.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid option! Please enter a valid number!");
            }
        }

    }
}
