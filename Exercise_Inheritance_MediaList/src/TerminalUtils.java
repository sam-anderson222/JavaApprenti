import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUtils {
    private static Scanner io = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("\n=== Media List Application ===");
        System.out.println("(1). Add Media");
        System.out.println("(2). Remove Media");
        System.out.println("(3). Play Media");
        System.out.println("(4). List All Media");
        System.out.println("(5). Quit");
    }

    public static void displayAddMediaMenu() {
        System.out.println("\nSelect media type: ");
        System.out.println("(1). Video");
        System.out.println("(2). Audio");
        System.out.println("(3). Image");
        System.out.println("(4). Book");
    }

    // Added an input for this function, which is array that contain valid choices that the user must pick from.
    public static String getMenuChoice(String[] choices) {

        // Validation loop
        while (true) {
            String user_input = getString("Enter your choice: ");
            if (isValidChoice(user_input, choices)) {
                return  user_input;
            } else {
                System.out.println("Invalid option, please input an valid menu option!");
            }
        }

    }

    // Returns true if String choice is found in choices array.
    private static boolean isValidChoice(String choice, String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            if (choices[i].equals(choice)) {
                return true;
            }
        }

        return false;
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return io.nextLine();
    }

    public static int getInt(String prompt) {
        // Validation loop
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(io.nextLine());
            } catch (Exception ex) {
                System.out.println("Error! Please input a number, not text!");
            }
        }
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    // Displays all media in the media list along with their descriptions
    public static void displayMediaList(ArrayList<Media> mediaList) {
        if (mediaList.isEmpty()) {
            System.out.println("No medias currently added.");
        } else {
            for (int i = 0; i < mediaList.size(); i++) {
                System.out.printf("(%d). %s%n", i + 1, mediaList.get(i).getDescription());
            }
        }

    }

    public static void displayMediaNames(ArrayList<Media> mediaList) {
        if (mediaList.isEmpty()) {
            System.out.println("No medias currently added.");
        } else {
            for (int i = 0; i < mediaList.size(); i++) {
                System.out.printf("(%d). %s%n", i + 1, mediaList.get(i).getName());
            }
        }
    }
}
