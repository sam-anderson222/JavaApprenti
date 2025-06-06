import java.util.Scanner;
import java.util.Random;

// Handles IO and other utilities like creating / validating PINs.

public class IO {
    private static Scanner io = new Scanner(System.in);
    private static Random rng = new Random();

    public static void printMenu(boolean notAllLockersRented) {
        System.out.println("What would you like to do?");
        if (notAllLockersRented) {
            System.out.println("(1). Rent a Locker");
            System.out.println("(2). Access a Locker");
            System.out.println("(3). Release a Locker");
        } else {
            System.out.println("(1). Access a Locker");
            System.out.println("(2). Release a Locker");
        }
        System.out.println("---");
        System.out.println("Any other key to exit");
    }

    // Print message with extra formatting.
    public static void printResult(ResultStr result) {
        System.out.printf("(%s)%n", result.getMessage());
    }

    public static String getUserString(String prompt) {
        System.out.print(prompt);
        return io.nextLine();
    }

    // Asks for a string, user is reprompted until valid input is received.
    public static int getUserInt(String prompt) {
        // Ensure user input a number
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(io.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please input a number.");
            }
        }
    }


    // PIN methods

    // Randomly generate a 4-digit PIN that is returned as a string
    public static String generatePIN() {
        String PIN = "";
        // number 0 - 9 will be appended one-by-one until a 4-digit PIN String is created.
        for (int i = 0; i < 4; i++) {
            PIN += Integer.toString(rng.nextInt(10));
        }
        return PIN;
    }

    // Checks if a string is in PIN format. (4 length string with only numbers)
    public static boolean isPINFormat(String PIN) {
        if (PIN.length() != 4) { // If PIN isn't 4-digits
            return false;
        }
        // If PIN is correct length, then each char is checked to see if it is a number.
        for (int i = 0; i < PIN.length(); i++) {
            if (!isNumber(PIN.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Return true if char is a number 0 - 9.
    private static boolean isNumber(char c) {
        return (c >= '0' && c <= '9'); // Compares ascii values to determine if char is a number or not.
    }
}
