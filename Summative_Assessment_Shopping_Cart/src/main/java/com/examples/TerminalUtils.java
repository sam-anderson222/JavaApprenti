package com.examples;

import com.examples.DataObjects.Item;
import com.examples.DataObjects.Result;

import java.util.ArrayList;
import java.util.Scanner;

// Handles user IO functions.
public class TerminalUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserStr(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void printMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("(1). Display Cart");
        System.out.println("(2). Remove an Item");
        System.out.println("(3). Add an Item");
        System.out.println("(4). Checkout");
        System.out.println("(5). Exit");
        System.out.println("------");

    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printCart(ArrayList<Item> cart) {
        System.out.printf("%-14s | %-12s | %-12s | %-12s%n", "Item Name", "Item Price", "Quantity", "Subtotal");
        System.out.println("============================================================");
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            double itemPrice = item.getItemPrice();
            int itemQuantity = item.getItemQuantity();
            System.out.printf("%-14s | $%-11.2f | %-12d | $%-11.2f%n", item.getItemName(), itemPrice, itemQuantity, (itemPrice * itemQuantity));
        }
    }
}
