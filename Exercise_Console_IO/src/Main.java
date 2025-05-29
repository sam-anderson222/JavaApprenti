import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner
        Scanner io = new Scanner(System.in);
        // Variables
        String name, productName;
        int quantity;
        double unitPrice;

        // Gather user input
        System.out.println("Welcome to the order form!");

        // Get user's name
        System.out.print("What is your name?\n>> ");
        name = io.nextLine();

        // Get product info.
        System.out.print("What type of product would you like to purchase?\n>> ");
        productName = io.nextLine();

        System.out.print("How many would you like?\n>> ");
        quantity = Integer.parseInt(io.nextLine());

        System.out.print("What is the unit price?\n>> ");
        unitPrice = Double.parseDouble(io.nextLine());

        // Calculating
        double subtotal = unitPrice * quantity;
        double tax = subtotal * 0.07; // 0.07 is the tax rate.
        double grandTotal = subtotal + tax;

        // Printing order summary
        System.out.println("Order Summary");
        System.out.println("--------------------------");
        System.out.printf(" %-15s %s%n", "Item: ", productName);
        System.out.printf(" %-15s %s%n", "Quantity: ", quantity);
        System.out.printf(" %-15s $%.2f%n", "Unit Price: ", unitPrice);
        System.out.println("--------------------------");
        System.out.printf(" %-15s $%.2f%n", "Subtotal: ", subtotal);
        System.out.printf(" %-15s $%.2f%n", "Tax (7%): ", tax);
        System.out.printf(" %-15s $%.2f%n", "Subtotal: ", grandTotal);
        System.out.println("--------------------------");
        System.out.printf("Thank you for your order, %s!%n", name);

    }
}
