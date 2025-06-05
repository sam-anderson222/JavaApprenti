// main only handles the menu logic

public class Main {
    public static void main(String[] args) {
        boolean runProgram = true;
        LockerService ls = new LockerService(10); // A locker system with 10 lockers

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
                    int lockerID = IO.getUserInt("Enter the locker ID: "); // getUserInt will reprompt user until a int is received.
                    ResultStr validLockerID = ls.isValidLockerID(lockerID);


                    if (!validLockerID.getStatus()) { // Break if the lockerID is not valid.
                        IO.printResult(validLockerID); // Prints why the lockerID is invalid (either not rented or index-out-of-bounds)
                        break;
                    }

                    // Get and check locker PIN.
                    String PIN = IO.getUserString("Enter the locker PIN: ");
                    ResultStr validLockerPIN = ls.isValidLockerPIN(lockerID, PIN); // A valid PIN must be in PIN format and open the locker it goes to.


                    if (!validLockerPIN.getStatus()) {
                        IO.printResult(validLockerPIN);
                        break;
                    }

                    // Access or release a locker after validating ID and PIN depending on user's input.
                    if (user_action.equals("2")) {
                        IO.printResult(ls.accessLocker(lockerID));
                    } else {
                        if (confirmRelease("Confirm locker release? (y/n): ")) {
                            IO.printResult(ls.releaseLocker(lockerID));
                        } else {
                            IO.printResult(new ResultStr(false, "Locker not released."));
                        }
                    }
                    break;
                default:
                    runProgram = false;
                    break;
            }
        }
    }

    // Confirms if a user wishes to release their locker.
    public static boolean confirmRelease(String prompt) {
        String user_input = IO.getUserString(prompt);
        return user_input.equalsIgnoreCase("y");
    }
}
