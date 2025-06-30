package com.examples.utils;
import com.examples.model.Flight;
import com.examples.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TerminalUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("\n=== Airport Terminal Program === ");
        System.out.println("(1). Add Reservation");
        System.out.println("(2). Get Passengers From Flight");
        System.out.println("(3). Exit");
        System.out.println("---------------");
    }

    public static String getUserStr(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printFlights(HashMap<String, Flight> flights) {
        System.out.println("\n== Flights == ");
        System.out.printf("%8s | %10s | %11s | %14s%n", "No.", "Date", "Price", "Aircraft");
        System.out.println("====================================================");
        for (String key: flights.keySet()) {
            System.out.println(flights.get(key));
        }
        System.out.println();
    }

    public static void printPassengersFromFlight(ArrayList<Passenger> passengers) {
        System.out.printf("\n%3s | %14s | %10s%n", "No.", "Name", "PassportNo.");
        System.out.println("===================================");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.printf("(%d) | %s%n", i + 1, passengers.get(i));
        }
        System.out.println();
    }
}
