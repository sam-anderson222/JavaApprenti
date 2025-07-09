package com.example.Capstone_Inventory_Manager.view;

import java.util.Scanner;

public class TerminalUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String getUserString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
