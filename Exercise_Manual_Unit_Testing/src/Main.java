import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        runTests();
    }

    private static String selectDrink(String choice) {
        System.out.println("\nReceived input: " + choice);
        choice = choice.toLowerCase();
        System.out.println("Lowercased Input: " + choice);
        switch (choice) {
            case "water":
                return "You selected Water";
            case "soda":
                return "You selected Soda";
            case "juice":
                return "You selected Juice";
            default:
                System.out.println("Invalid selection detected!");
                return "Invalid selection";
        }
    }

    private static void runTests() {
        String[] inputs = {"water", "soda", "juice", "WATER", "Tea", ""};
        String[] expectedOutputs = {
                "You selected Water",
                "You selected Soda",
                "You selected Juice",
                "You selected Water",
                "Invalid selection",
                "Invalid selection"
        };
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expected = expectedOutputs[i];
            System.out.print("Testing with " + input + "... ");
            String actual = selectDrink(input);
            if (expected.equals(actual)) {
                System.out.println("Passed!");
            } else {
                System.out.println("FAIL: Expected '" + expected + "', got '" +
                        actual + "'");
            }
        }
    }
}