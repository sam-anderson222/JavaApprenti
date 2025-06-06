// main handles the menu logic


public class Main {
    // ls is made static so it can be used in other static functions.
    static LockerService ls = new LockerService(6); // A locker system with 6 lockers


    public static void main(String[] args) {
        // Main app loop
        while (true) {
            // ls.checkLockerAvailability.getStatus() returns a true if there is at least one free locker.
            boolean isAvailableLockers = ls.checkLockerAvailability().getStatus();
            IO.printMenu(isAvailableLockers); // Rent locker option is removed if there are no available lockers.
            String user_action = IO.getUserString(">> ");

            // The removal of the rent option in the case where there are no lockers to rent causes the options to shift over.
            // Ex. Access Locker goes from option 2 -> option 1.
            // This function maps the options to their original numbers.
            if (!isAvailableLockers) {
                user_action = unshiftOptions(user_action);
            }

            if (user_action.equals("1")) {
                IO.printResult(ls.rentLocker());
            } else if (user_action.equals("2") || user_action.equals("3")) {
                // Get and check locker ID.
                ResultInt lockerID = getValidLockerID("Enter the locker ID: "); // getUserInt will reprompt user until an int is received.
                if (!lockerID.getStatus()) { // If the status is false, then that means the ID is invalid.
                    continue; // This is only for stopping the main loop. The error message is printed when the getValidLockerID function is called.
                }

                // Get and check locker PIN.
                ResultStr lockerPIN = getValidLockerPIN("Enter the locker PIN: ", lockerID.getNumber()); // LockerID must be passed in to check if a PIN goes to a certain locker.
                if (!lockerPIN.getStatus()) { // If the status is false, then that means the PIN is invalid.
                    continue; // If invalid PIN, restart loop.
                }

                // Only after we are sure we have a valid ID and PIN should we either access or release a locker.
                accessOrReleaseLocker(user_action, lockerID.getNumber());
            } else { // Else exit the program.
                break;
            }
        }

        // Print thank you message.
        IO.printResult(new ResultStr(true, "Thank you for using the Storage Lockers program!"));
    }



    // Returns a valid ID if valid input is received, however will print an error message and return false / nothing if the ID is invalid.
    private static ResultInt getValidLockerID(String prompt) {
        int lockerID = IO.getUserInt(prompt);
        ResultStr isValidLockerID = ls.isValidLockerID(lockerID);

        if (!isValidLockerID.getStatus()) { // Prints why the lockerID is invalid (either not rented or index-out-of-bounds)
            IO.printResult(isValidLockerID);
            return new ResultInt(false, -1); // -1 is placeholder value, not used.
        }

        return new ResultInt(true, lockerID); // Return a valid ID.
    }


    // Returns a valid PIN if valid input is received, however will print an error message and return false / nothing if the PIN is invalid.
    private static ResultStr getValidLockerPIN(String prompt, int lockerID) {
        String lockerPIN = IO.getUserString(prompt);
        ResultStr isValidLockerPIN = ls.isValidLockerPIN(lockerID, lockerPIN); // A valid PIN must be in PIN format and open the locker it goes to.

        if (!isValidLockerPIN.getStatus()) { // If the status is false, then that means the PIN is invalid.
            IO.printResult(isValidLockerPIN); // Prints why the lockerPIN is invalid (either incorrect format or PIN doesn't unlock locker)
            return new ResultStr(false, ""); // Empty string is placeholder, printed error message from invalid PIN comes from isValidLockerPIN.
        }

        return new ResultStr(true, lockerPIN);
    }

    // Accesses or releases a locker. These two action are separate from renting, as accessing and releasing need the input / use a locker ID and PIN.
    private static void accessOrReleaseLocker(String user_action, int lockerID) {
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
    private static boolean confirmRelease(String prompt) {
        String user_input = IO.getUserString(prompt);
        return user_input.equalsIgnoreCase("y");
    }

    // In the case where there are no lockers to rent, the rent option is removed, which causes the access locker option to shift from
    // option 2 to 1, and so on. To fix this, this function maps the user action back to its original values when the rent locker option is present.
    private static String unshiftOptions(String user_action) {
        switch (user_action) {
            case "1":
                return "2";
            case "2":
                return "3";
            default:
                return "exit program";
        }
    }
}
