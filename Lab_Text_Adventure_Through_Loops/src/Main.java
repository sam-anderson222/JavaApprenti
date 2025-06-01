import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables
        Scanner io = new Scanner(System.in);
        String user_input = "";
        boolean visitedFirstPOI = false;
        boolean visitedSecondPOI = false;
        boolean visitedThirdPOI = false;
        String hubDescription = "You find yourself in a strange white room, three doors sit in front of you. "; // Text that is displayed before the menu is printed.


        while (!user_input.equals("4")) {
            System.out.println("\n" + hubDescription);
            // Print action menu
            System.out.println("(1). Enter First Door");
            System.out.println("(2). Enter Second Door");
            System.out.println("(3). Enter Third Door");
            System.out.println("(4). Exit Game");
            System.out.print("Enter your choice: ");

            // Get user input
            user_input = io.nextLine();

            System.out.println("-------------------------------------"); // Divider.
            // Decision tree based on user input.
            switch (user_input) {
                case "1": // Enter the first door
                    if (!visitedFirstPOI) { // If it is the first time visiting this location.
                        System.out.println("You enter the first door.");
                        System.out.println("You find yourself in a lush jungle.");
                        System.out.println("The air is heavy and humid.");
                        System.out.println("As you survey your surrounding, you find a key hidden in brush.");
                        System.out.println("You take the key with you as you return to the white room through the door you came.");
                        visitedFirstPOI = true;
                    } else { // If the user is revisiting the location.
                        System.out.println("You re-enter the first door.");
                        System.out.println("Your back in the lush jungle.");
                        System.out.println("The air has cooled. A heavy rain has started.");
                        System.out.println("You watch the rain under the cover of the canopy.");
                        System.out.println("After some time you return to the white room.");
                    }
                    hubDescription = "You return to the white room. It's pure white floor now stained with the mud you've tracked in on your shoes.";
                    break;
                case "2": // Enter the second door
                    if (!visitedSecondPOI) { // If it is the first time visiting this location.
                        System.out.println("You enter the second door.");
                        System.out.println("You find yourself in a barren desert.");
                        System.out.println("The sun bears down on you, not a cloud in sight.");
                        System.out.println("As you survey your surrounding, you find a key hidden buried in the sand.");
                        System.out.println("You take the key with you as you return to the white room through the door you came.");
                        visitedSecondPOI = true;
                    } else { // If the user is revisiting the location.
                        System.out.println("You enter the second door.");
                        System.out.println("You find yourself back in the desert.");
                        System.out.println("Looking off into the distance you see a dust devil.");
                        System.out.println("You watch as the funnel sways across the desert dunes.");
                        System.out.println("After the dust devil subsides you return to the white room.");
                    }
                    hubDescription = "You return to the pure white room. Beads of sweat run down your face, the desert heat is no joke. You sigh with relief, at least there's AC in this strange place.";
                    break;
                case "3": // Enter the third door
                    if (visitedFirstPOI && visitedSecondPOI) { // If the player has already collected two keys.
                        System.out.println("You use the two keys to unlock the third door, before entering");
                        System.out.println("You find yourself on a beach.");
                        System.out.println("Looking off into the distance you watch as the sun sets.");
                        System.out.println("You turn around to return, like you've done in the previous rooms.");
                        System.out.println("However, the door you came through is gone.");
                        System.out.println("\n(The End).");
                        user_input = "4"; // Causes the game to exit.
                    } else { // If the player hasn't gone to all the locations yet.
                        System.out.println("You walk up to the third door.");
                        System.out.println("Next to the doorknob, are two keyholes.");
                        System.out.println("You attempt to open the door, but it's locked.");
                        System.out.println("It seems you need two keys to open this door.");
                    }
                    break;
                case "4": // Don't print error text, just do nothing and let the loop run again so it re-eval it's boolean expression.
                    break;
                default:
                    System.out.println("Error invalid choice! Please input (1/2/3) to do an action.");
                    break;
            }

        }
        System.out.println("\n(Thanks for playing!)");
    }
}
