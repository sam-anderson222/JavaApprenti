// Holds methods that are used in workflow classes to reduce having to repeat code to get IDs / PINs.


public class WorkflowUtils {

    // Returns a valid ID if valid input is received, however will print an error message and return false if the ID is invalid.
    public static ResultInt getValidLockerID(LockerService ls) {
        int lockerID = IO.getUserInt("Enter a locker ID: ");
        ResultStr isValidLockerID = ls.isValidLockerID(lockerID);

        if (!isValidLockerID.getStatus()) { // Prints why the lockerID is invalid (either not rented or index-out-of-bounds)
            IO.printResult(isValidLockerID);
            return new ResultInt(false, -1); // -1 is placeholder value, not used.
        }

        return new ResultInt(true, lockerID); // Return a valid ID.
    }

    // Returns a valid PIN if valid input is received, however will print an error message and return false / nothing if the PIN is invalid.
    public static ResultStr getValidLockerPIN(LockerService ls, int lockerID) {
        String lockerPIN = IO.getUserString("Enter a locker PIN: ");
        ResultStr isValidLockerPIN = ls.isValidLockerPIN(lockerID, lockerPIN); // A valid PIN must be in PIN format and open the locker it goes to.

        if (!isValidLockerPIN.getStatus()) { // If the status is false, then that means the PIN is invalid.
            IO.printResult(isValidLockerPIN); // Prints why the lockerPIN is invalid (either incorrect format or PIN doesn't unlock locker)
            return new ResultStr(false, ""); // Empty string is placeholder, printed error message from invalid PIN comes from isValidLockerPIN.
        }

        return new ResultStr(true, lockerPIN);
    }
}
