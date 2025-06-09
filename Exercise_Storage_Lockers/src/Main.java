import java.util.Scanner;

public class Main {
    static LockerManager lm = new LockerManager();
    static Scanner io = new Scanner(System.in);

    public static void main(String[] args) {
        boolean runLockerManager = true;
        // App loop
        while (runLockerManager) {
            printMenu();
            String user_input = getUserString(">> ");
            switch (user_input) {
                case "1":
                    addLocker();
                    break;
                case "2":
                    removeLocker();
                    break;
                case "3":
                    storeItem();
                    break;
                case "4":
                    removeItem();
                    break;
                case "5":
                    lm.displayAllLockers();
                    break;
                default:
                    runLockerManager = false; // Stop the program if any other key is inputted.
                    break;
            }
        }

        // Print thank you text.
        System.out.println("(Thank you for using the locker manager!)");
    }

    static void printMenu() {
        System.out.println("\nLocker Manager");
        System.out.println("(1). Add Locker");
        System.out.println("(2). Remove Locker");
        System.out.println("(3). Store Item In Locker");
        System.out.println("(4). Retrieve Item From Locker");
        System.out.println("(5). Show All Lockers");
        System.out.println("----");
        System.out.println("Enter any other key to exit.");
    }

    static String getUserString(String prompt) {
        System.out.print(prompt);
        return io.nextLine();
    }

    // These four function require user input, which is done inside the function instead of in the menu loop.
    static void addLocker() {
        String lockerID = getUserString("Enter locker ID: ");
        if (lm.getLocker(lockerID) == null) {
            lm.addLocker(lockerID);
            System.out.printf("Locker with ID: %s created.%n", lockerID);
        } else {
            System.out.printf("Locker with ID: %s already exists.%n", lockerID);
        }


    }

    static void removeLocker() {
        String lockerID = getUserString("Enter locker ID: ");
        if (lm.getLocker(lockerID) != null) { // If locker with this ID exists.
            lm.removeLocker(lockerID);
            System.out.printf("Locker with ID: %s deleted.%n", lockerID);
        } else {
            System.out.printf("No locker with ID: %s found.%n", lockerID);
        }
    }

    static void storeItem() {
        String lockerID = getUserString("Enter locker ID: ");
        if (lm.getLocker(lockerID) != null) { // If locker with this ID exists.
            String item = getUserString("Enter item you wish to store: ");
            lm.getLocker(lockerID).storeItem(item); // store item inside locker.
            System.out.printf("%s stored inside locker with ID: %s%n", item, lockerID);
        } else {
            System.out.printf("No locker with ID: %s found.%n", lockerID);
        }
    }

    static void removeItem() {
        String lockerID = getUserString("Enter locker ID: ");
        if (lm.getLocker(lockerID) != null) { // If locker with this ID exists.
            if (lm.getLocker(lockerID).getIsOccupied()) { // Check if locker is occupied.
                lm.getLocker(lockerID).removeItem();
                System.out.printf("Items from locker with ID: %s retrieved.%n", lockerID);
            } else {
                System.out.printf("No items stored at locker with ID: %s.%n", lockerID);
            }
        } else {
            System.out.printf("No locker with ID: %s found.%n", lockerID);
        }
    }
}

