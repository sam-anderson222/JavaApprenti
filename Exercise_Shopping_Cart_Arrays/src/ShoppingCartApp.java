import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        // Variable declaration
        Scanner console = new java.util.Scanner(System.in);

        double productPrice = 4.99;
        int productQuantity; // This variable is now inputted by the user through the console (Scanner object)
        double totalCost; // Cost of order.
        double totalCostWithTax, totalCostAfterDiscount, shippingCost, finalTotalCost;
        String taxExempt, shipping, promoCode, shippingAddress, productSize;

        // Array declaration (Added for arrays exercise)
        String[] shippingAddresses = new String[] {"123 Oak St.", "435 Elm Rd.", "834 Pine Ln."};
        String[] productSizes = new String[] {"Small", "Medium", "Large"};

        // discounts, shipping, taxes
        double taxRate = .07;
        double hundredDollarDiscount = .05;
        double fiveHundredDollarDiscount = .10;
        double standardShipping = 2.00;
        double overnightShipping = 10.00;
        double twoDayShipping = 5.00;


        // Added loop for Loops Exercise

            System.out.print("\n(Welcome to the shopping cart app!)\n");

        do {
            // Prompt for shipping address
            for (int i = 0; i < shippingAddresses.length; i++) {
                System.out.printf("(%d): %s%n", i+1, shippingAddresses[i]);
            }
            System.out.print("Enter shipping address? (1/2/3)\n>> ");
            shippingAddress = shippingAddresses[Integer.parseInt(console.nextLine()) - 1];

            // Prompt for product size
            for (int i = 0; i < productSizes.length; i++) {
                System.out.printf("(%d): %s%n", i+1, productSizes[i]);
            }
            System.out.print("Enter product size? (1/2/3)\n>> ");
            productSize = productSizes[Integer.parseInt(console.nextLine()) - 1];

            // Prompt for product quantity
            System.out.print("Enter number of unit you wish to purchase\n>> ");
            productQuantity = Integer.parseInt(console.nextLine());

            // Prompt for tax exempt
            System.out.print("Are you tax-exempt? (y/n)\n>> ");
            taxExempt = console.nextLine();
            // Prompt for shipping
            System.out.print("Shipping? (standard / overnight / two-day)\n>> ");
            shipping = console.nextLine();
            // Prompt for promo code
            System.out.print("Promo code for free shipping (only applies for standard shipping)?\n>> ");
            promoCode = console.nextLine();
            System.out.print("Confirm order? (y/n)\n>> ");
        } while(!console.nextLine().equals("y"));


        // Calculation for price.
        totalCost = productPrice * productQuantity;
        // Tax calculations
        if (taxExempt.equals("n")) { // Only apply tax if customer isn't tax exempt.
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


        // Added shipping costs / promo codes for free shipping
        switch (shipping) {
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
        System.out.println("Shipping: " + shipping);
        System.out.println("Promo code: " + promoCode);
        System.out.printf("Sub-total: $%.2f%n", totalCost);
        System.out.printf("Total w/ Tax: $%.2f%n", totalCostWithTax);
        System.out.printf("Total After Discount: $%.2f%n", totalCostAfterDiscount);
        System.out.printf("Shipping Costs: $%.2f%n", shippingCost);
        System.out.printf("Final Total: $%.2f%n", finalTotalCost);
        System.out.println("Bye");

    }
}
