import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables / Scanner object
        Scanner io = new Scanner(System.in);
        String user_input = "";
        String ending_flag = ""; // This flag determines which text is printed at the end of the game.

        // Game decisions
        System.out.println("Welcome to this text-based adventure game!");


        // First decision (enter the cave)
        System.out.println("\n(You find yourself before a mysterious cave. A sense of adventure calls you in.)");
        System.out.println("Do you wish to enter? (yes/no)");
        user_input = getValidUserInput(new String[]{"yes", "no"}, io);

        if (user_input.equals("yes")) { // User enters the cave.
            System.out.println("\n(You enter the cave. Ahead of you are two paths.)");
            System.out.println("Which one will you take? (left/right)");
            user_input = getValidUserInput(new String[]{"left", "right"}, io);

            if (user_input.equals("left")) { // User takes the left path and encounters a monster.
                System.out.println("\n(You encounter a monster will travelling down the left path.)");
                System.out.println("How will you react? (fight/flee)");
                user_input = getValidUserInput(new String[]{"fight", "flee"}, io);
                if (user_input.equals("fight")) { // Player tries to fight monster.
                    System.out.println("\n(In your confidence, you attempt to fight the monster. Let's just say things don't go well for you.)");
                    ending_flag = "overConfident";
                } else if (user_input.equals("flee")) { // User flees from the monster.
                    System.out.println("\n(You run away from the monster screaming like a little girl. You've escaped with your life, but not your dignity.)");
                    ending_flag = "coward";
                }

            } else if (user_input.equals("right")) { // User takes the right path to the treasure room.
                System.out.println("\n(You reach a room full of treasure. In front of you are three artifacts.)");
                System.out.println("(1). A magical gem\n(2). An mysterious key\n(3). A glimmering book");
                System.out.println("(Due to contrived plot reasons, you may only take one)");
                System.out.println("Which one will you take? (gem/key/book)");
                user_input = getValidUserInput(new String[]{"gem", "key", "book"}, io);
                if (user_input.equals("gem")) {
                    System.out.println("\n(You choose the gem. As you pick it up you think to yourself 'Isn't this just stealing?' You did just barge your way into someone's cave after all and started looting their stuff.)");
                    ending_flag = "gem";
                } else if (user_input.equals("key")) {
                    System.out.println("\n(You choose the key. You search for the lock the pair goes to, but find nothing.)");
                    ending_flag = "key";
                } else if (user_input.equals("book")) {
                    System.out.println("\n(You choose the book. You open it, however whoever write the book had absolutely horrible handwriting. You are unable to decipher the great knowledge held within.)");
                    ending_flag = "book";

                }

            }

        } else if (user_input.equals("no")) { // User doesn't enter the cave.
            System.out.println("\n(You leave the cave and nothing happens. That's it. The end! So much for adventure I guess.)");
            ending_flag = "doNothing";
        }

        // Thanks for playing and ending text.
        switch (ending_flag) {
            case "doNothing":
                System.out.println("Your journey ends here, before it even started.");
                break;
            case "overConfident":
                System.out.println("Your journey ends here, there's such a thing as picking your battle, you know?");
                break;
            case "coward":
                System.out.println("Your journey ends here, shaken up but still in one piece.");
                break;
            case "gem":
                System.out.println("Your journey ends here, a lingering sense of guilt linger in your heart.");
                break;
            case "key":
                System.out.println("Your journey ends here, you never find what the key goes to.");
                break;
            case "book":
                System.out.println("Your journey ends here, the wisdom in the book is obscured by the author's chicken-scratch.");
                break;
            default:
                System.out.println("Error, unintended ending reached.");
                break;
        }

        System.out.println("\n(Thanks for playing!)");

    }
    // Return a string that is a valid option for the user to take. User is reprompted until a valid option is given.
    public static String getValidUserInput(String[] options, Scanner ioObject) {
        String user_in = "";
        do {
            System.out.print(" >> ");
            user_in = ioObject.nextLine();
        } while (!isValidOption(options, user_in.toLowerCase()));
        return user_in.toLowerCase();
    }

    // Checks if a user inputted a valid option.
    public static boolean isValidOption(String[] options, String attemptedOption) {
        // If the user's option is found in the options list, then true is returned. If not, then false.
        for (int i = 0; i < options.length; i++) {
            if (attemptedOption.equals(options[i])) {
                return true; // Option is valid.
            }
        }
        return false; // Option is invalid.
    }
}
