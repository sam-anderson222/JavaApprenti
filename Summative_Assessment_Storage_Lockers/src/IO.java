import java.util.Scanner;
import java.util.Random;

// Only handles IO

public class IO {
    private static Scanner io = new Scanner(System.in);
    private static Random rng = new Random();

    public static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("(1). Rent a Locker");
        System.out.println("(2). Access a Locker");
        System.out.println("(3). Release a Locker");
        System.out.println("---");
        System.out.println("Any other key to exit");
    }

    public static void printResult(ResultStr result) {
        System.out.println(result.getMessage());
    }

    public static String getUserAction(String prompt) {
        System.out.print(prompt);
        return io.nextLine();
    }

    // Randomly generate a 4-digit PIN that is returned as a string
    public static String generatePIN() {
        String PIN = "";
        // number 0 - 9 will be appended one-by-one until a 4-digit PIN String is created.
        for (int i = 0; i < 4; i++) {
            PIN += Integer.toString(rng.nextInt(10));
        }

        return PIN;
    }
}
