package com.example.Capstone_Inventory_Manager.view;

import com.example.Capstone_Inventory_Manager.model.Product;
import com.example.Capstone_Inventory_Manager.model.ProductTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class TerminalUtils {
    private static Scanner scanner = new Scanner(System.in);

    // _______________ Output Functions ____________________
    public static void printMainMenu() {
        System.out.println("\n════════════════════════");
        System.out.println("   Inventory Manager");
        System.out.println("════════════════════════");
        System.out.println("(1). Add Product");
        System.out.println("(2). Remove Product");
        System.out.println("(3). Update Product");
        System.out.println("(4). Get Product");
        System.out.println("(5). Print Stock Table");
        System.out.println("(6). Exit");
        System.out.println("---------------------");

    }

    public static void printGoodbyeMessage() {
        System.out.println("\n═════════════════════════════════════════════════════════");
        System.out.println("   Thank you for using the inventory manager program!");
        System.out.println("═════════════════════════════════════════════════════════");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printStockTable(HashMap<String, Product> productTable) {
        System.out.println("═══ Stock Table ═══\n");
        System.out.printf("%6s | %14s | %8s | %10s | %16s | %10s | %12s%n", "ID", "Name", "Quantity", "Price", "Type", "Expiration", "Brand");
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════════════════");
        for (Product p : productTable.values()) {
            System.out.println(p.toProductTableRow());
        }
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════════════════\n");
    }

    public static void printProduct(Product p) {
        System.out.println("\n<════════════════════════════════>");
        System.out.print(p);
        System.out.println("<════════════════════════════════>");
    }

    public static void printProductTypes() {
        System.out.println("\n<══ Product Types ══>");
        for (int i = 0; i < ProductTypes.values().length; i++) {
            System.out.printf("(%d). %s%n", i+1, ProductTypes.values()[i]);
        }
        System.out.println("<═══════════════════>");
    }

    // _______________ Input Functions ____________________
    public static String getUserString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getUserInt(String prompt) {
       while (true) {
           try {
               System.out.print(prompt);
               return Integer.parseInt(scanner.nextLine());
           } catch (Exception ex) {
               System.out.println("Error, please input an valid integer!");
           }
       }
    }

    public static BigDecimal getUserBigDecimal(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return new BigDecimal(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Error, please input an valid decimal number!");
            }
        }
    }

    public static LocalDate getUserLocalDate(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Error, please input an valid date in (yyyy-mm-dd) format!");
            }
        }
    }

}
