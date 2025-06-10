import java.util.Scanner;

// Handles IO

public class IO {
    private static final Scanner io = new Scanner(System.in);

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

    // Confirms if a user wishes to release their locker.
    public static boolean confirmRelease() {
        String user_input = IO.getUserString("Confirm locker release? (y/n): ");
        return user_input.equalsIgnoreCase("y");
    }
}
