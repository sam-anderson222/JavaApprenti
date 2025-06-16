package com.examples;

import java.util.Scanner;

public class TerminalUtils {
    static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("\n=== Spellbook ===");
        System.out.println("(1). Recite a Spell");
        System.out.println("(2). Help");
        System.out.println("-----");
    }

    public static void printHelpMenu(SpellBook spellBook) {
        // Header
        System.out.printf("%14s | %s%n", "Incantation", "Description");
        System.out.println("==========================================");
        for (int i = 0; i < spellBook.getSpells().size(); i++) {
            Spell spell = spellBook.getSpells().get(i);
            System.out.printf("%14s | %s%n", spell.getIncantation(), spell.getDescription());
        }
    }

    public static String getUserStr(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
