package com.examples;

import com.examples.DataObjects.Product;

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
        // TO DO THURSDAY OR FRIDAY
    }

    public static String getUserStr(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
