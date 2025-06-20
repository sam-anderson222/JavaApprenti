package com.examples;

import com.examples.DataObjects.CartEntry;
import com.examples.DataObjects.Product;
import com.examples.DataObjects.ProductParentClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TerminalUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("(1). Display Cart");
        System.out.println("(2). Remove an Item");
        System.out.println("(3). Add an Item");
        System.out.println("(4). Checkout");
        System.out.println("(5). Exit");
        System.out.println("------");
    }

    public static void printProductTable(HashMap<String, Product> productTable) {
        System.out.println("==== Products Available ====");
        System.out.println("  ID    Name              Price     Extra           Description");
        for (String key: productTable.keySet()) {
            Product p = productTable.get(key);
            System.out.printf("%5s - %s%n", key,  p.toString());
        }
    }

    public static void printCart(ArrayList<CartEntry> cart) {
        System.out.println("==== Current Cart ====");
        for (int i = 0; i < cart.size(); i++) {
            CartEntry cartItem = cart.get(i);
            System.out.printf("(%2d). %4dx  ==>  %s%n", i + 1, cartItem.getProductQuantity(), cartItem.getProduct().toString());
        }
        System.out.println("---------------\n");
    }

    public static void printCheckOut(CartService cartService) {
        ArrayList<CartEntry> cart = cartService.getCart();

        // Print checkout
        System.out.println("==== Current Cart ====");
        for (int i = 0; i < cart.size(); i++) {
            CartEntry cartItem = cart.get(i);
            System.out.printf("(%2d). %4dx  ==>  %s | $%.2f%n", i + 1, cartItem.getProductQuantity(), cartItem.getProduct().toString(), cartItem.getCartEntryPrice());
        }
        System.out.println("<+++-----------------------------+++>");
        System.out.printf("Total: $%.2f%n", cartService.calculateTotal());
    }

    public static String getUserStr(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getUserInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Error, please input a valid number.");
            }
        }

    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
