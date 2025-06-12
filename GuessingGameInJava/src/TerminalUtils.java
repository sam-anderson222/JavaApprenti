import java.util.Scanner;

public class TerminalUtils {
    private static Scanner io = new Scanner(System.in);

    public static void printMessage(String prompt) {
        System.out.println(prompt);
    }

    public static int getUserInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(io.nextLine());
            } catch (Exception ex) {
                System.out.println("Error! Received text instead of number.");
            }
        }
    }

    public static int getMaxNumber(String prompt) {
        while (true) {
           int maxNumber = getUserInt(prompt);

           if (maxNumber > 1) {
               return maxNumber;
           } else {
               System.out.println("Invalid max number! Max number must be bigger than 1.");
           }
        }
    }

    public static int getPlayerGuess(int maxNumber) {
        while (true) {
            int playerGuess = getUserInt("Enter your guess: ");

            if (playerGuess >= 1 && playerGuess <= maxNumber) {
                return playerGuess;
            } else {
                System.out.printf("Invalid guess. Guess must be between 1 - %d.%n", maxNumber);
            }
        }
    }

    public static boolean askIfWantToStopPlaying() {
        System.out.print("Do you want to play again? (y/n): ");
        return (io.nextLine().equalsIgnoreCase("n"));
    }
}
