// main only handles the menu logic

public class Main {
    // ls is made static so it can be used in other static functions.
    static LockerService ls = new LockerService(10); // A locker system with 10 lockers
 
    public static void main(String[] args) {
        boolean runProgram = true;
        // Main app loop
        while (runProgram) {
            IO.printMenu();
            String user_action = IO.getUserString(">> ");
            switch (user_action) {
                case "1":
                    IO.printResult(ls.rentLocker());
                    break;
                // For both cases 2 and 3, we need to get and check a lockerID and PIN, so applying DRY, case 2 will fall down to case 3.
                case "2":
                case "3":
                    // Get and check locker ID.
                    ResultInt lockerID = getValidLockerID("Enter the locker ID: "); // getUserInt will reprompt user until a int is received.
                    if (!lockerID.getStatus()) { // If the status is false, then that means the ID is invalid.
                        break;
                    }

                    // Get and check locker PIN.
                    ResultStr lockerPIN = getValidLockerPIN("Enter the locker PIN: ", lockerID.getNumber()); // LockerID must be passed in to check if a PIN goes to a certain locker.
                    if (!lockerPIN.getStatus()) { // If the status is false, then that means the PIN is invalid.
                        break;
                    }

                    // Access or release a locker after validating ID and PIN depending on user's input.
                    doLockerAction(user_action, lockerID.getNumber(), lockerPIN.getMessage());
                    break;
                default:
                    runProgram = false;
                    break;
            }
        }
    }



    // Returns a valid ID if valid input is received, however will print an error message and return false / nothing if the ID is invalid.
    public static ResultInt getValidLockerID(String prompt) {
        int lockerID = IO.getUserInt(prompt);
        ResultStr isValidLockerID = ls.isValidLockerID(lockerID);

        if (!isValidLockerID.getStatus()) { // Prints why the lockerID is invalid (either not rented or index-out-of-bounds)
            IO.printResult(isValidLockerID);
            return new ResultInt(false, -1); // -1 is placeholder value, not used.
        }

        return new ResultInt(true, lockerID); // Return a valid ID.
    }


    // Returns a valid PIN if valid input is received, however will print an error message and return false / nothing if the PIN is invalid.
    public static ResultStr getValidLockerPIN(String prompt, int lockerID) {
        String lockerPIN = IO.getUserString(prompt);
        ResultStr validLockerPIN = ls.isValidLockerPIN(lockerID, lockerPIN); // A valid PIN must be in PIN format and open the locker it goes to.

        if (!validLockerPIN.getStatus()) { // If the status is false, then that means the PIN is invalid.
            IO.printResult(validLockerPIN); // Prints why the lockerID is invalid (either not rented or index-out-of-bounds)
            return new ResultStr(false, ""); // Empty string is placeholder, error message from invalid PIN comes from validLockerPIN.
        }

        return new ResultStr(true, lockerPIN);
    }

    // Accesses or releases a locker. These two action are separate from renting, as accessing and releasing need the input / use a locker ID and PIN.
    public static void doLockerAction(String user_action, int lockerID, String lockerPIN) {
        if (user_action.equals("2")) {
            IO.printResult(ls.accessLocker(lockerID));
        } else {
            if (confirmRelease("Confirm locker release? (y/n): ")) {
                IO.printResult(ls.releaseLocker(lockerID));
            } else {
                IO.printResult(new ResultStr(false, "Locker not released."));
            }
        }
    }

    // Confirms if a user wishes to release their locker.
    public static boolean confirmRelease(String prompt) {
        String user_input = IO.getUserString(prompt);
        return user_input.equalsIgnoreCase("y");
    }
}
