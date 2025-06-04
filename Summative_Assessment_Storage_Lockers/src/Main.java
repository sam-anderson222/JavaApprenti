import java.util.Scanner;

/*
        Storage Locker used by a service representative

        Rent a locker
        Access a locker
        Release a locker
        Number of lockers in use.
        (added feature) show locker states

        Locker (Has a number and PIN and a state (is rented?))

        Data: Locker number, Locker PIN, and locker state
        The state can be determined using the PIN (if PIN == null) then locker isn't rented.

        Actions: Renting / Accessing / Releasing a locker.

        Locker() store locker information
        LockerSystem() holds all key locker actions and lockers array
        Main() Provides the menu for the rep. to use

        (added class) utils, handles and validates user input.

         */

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        LockerSystem ls = new LockerSystem(20); // A locker system with 20 lockers
        boolean runProgram = true;

        // Menu
        while (runProgram) {
            printMenu(ls); // ls is passed in, and if the locker system is full, then the 'rent locker' option shouldn't be printed.
            String user_input = io.nextLine();
            switch (user_input) {
                case "1":
                    String PIN = utils.getPIN();
                    ls.rentLocker(PIN);
                    break;
                case "2":
                    break;
                case "3":
                    // Confirming if locker ID and PIN are valid before doing action.
                    break;
                default:
                    runProgram = false; // Exits application loop.
                    break;
            }
        }

        System.out.println("Thank you for using the storage locker program!");
    }


    public static void printMenu(LockerSystem ls) {
        System.out.println("What would you like to do?");
        System.out.println("(1). Rent a Locker");
        System.out.println("(2). Access a Locker");
        System.out.println("(3). Rent a Locker");
        System.out.println("---");
        System.out.print("Any other key to exit\n>> ");
    }

    public static void checkIDAndPIN(Scanner io, LockerSystem ls) {


    }
}
