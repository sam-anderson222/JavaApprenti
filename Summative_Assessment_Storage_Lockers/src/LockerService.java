// Handles locker functions / validation.

public class LockerService {
    private Locker[] lockers;

    public LockerService(int numberOfLockers) {
        lockers = new Locker[numberOfLockers];
    }

    public ResultStr rentLocker() {
        ResultInt rentableLocker = checkLockerAvailability(); // Returns a ResultInt that store the index of a locker and a if one is available.
        if (rentableLocker.getStatus()) { // If there is at least one rentable locker, then .getStatus() is true.
            int freeLockerIndex = rentableLocker.getNumber(); // Index of earliest locker that can rented.
            String lockerPIN = IO.generatePIN(); // Generate a random 4-digit PIN String.

            lockers[freeLockerIndex] = new Locker(lockerPIN);
            // One is added to the ResultStr's String to make 1-based index instead of 0-based.
            return new ResultStr(true, String.format("Locker #%d rented. Your PIN is %s", freeLockerIndex + 1, lockerPIN));

        } else {
            // else if no locker is available
            return new ResultStr(false, "Locker not rented: no available lockers left.");
        }
    }

    // locker ID and PIN have already been validated beforehand, so don't have to be checked inside the function.
    public ResultStr accessLocker(int lockerID) {
        return new ResultStr(true, String.format("Locker #%d opened! Make sure to lock it up when you're done.", lockerID));
    }

    // locker ID and PIN have already been validated beforehand, so don't have to be checked inside the function.
    public ResultStr releaseLocker(int lockerID) {
        lockers[lockerID - 1] = null; // Release locker.
        return new ResultStr(true, String.format("Locker #%d released. PIN has been reset and locker is now open to be rented.", lockerID));
    }

    // Check if a received lockerID is a valid index and the locker at that index is being rented.
    public ResultStr isValidLockerID(int lockerID) {
        if ((lockerID >= 1 && lockerID <= lockers.length)) { // If the locker ID is at a valid index in the lockers array.
            if (lockers[lockerID - 1] == null) { // Checks if the locker is currently not being rented. (Goes from 1-based index to 0)
                return new ResultStr(false, "Locker at this ID is not currently being rented.");
            } // If the locker is at a valid index and being rented, then return true.
            return new ResultStr(true, "Valid locker ID received");
        } // If is not a valid index in the lockers array.
        return new ResultStr(false, "Invalid locker ID received. No locker with this ID found.");
    }

    // Checks if a user inputted PIN is valid and opens are certain locker.
    public ResultStr isValidLockerPIN(int lockerID, String PIN) {
        if (!IO.isPINFormat(PIN)) {
            return new ResultStr(false, "Invalid PIN received. Input is not in 4-digit PIN format.");
        }
        if (lockers[lockerID - 1].checkPIN(PIN)) {
            return new ResultStr(true, "Correct PIN received.");
        }
        return new ResultStr(false, "Incorrect PIN received. Inputted PIN does go to this locker.");
    }

    // Returns a ResultInt. The boolean tells if there is an available locker and int tells the index of the earliest available locker.
    // This is public as it is also used to determine if the rent menu option should be displayed in the Main class.
    public ResultInt checkLockerAvailability() {
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i] == null) { // If there is an available locker
                return new ResultInt(true, i);
            }
        }
        // If loop runs fully and no empty spots are found, then all lockers must be rented.
        return new ResultInt(false, -1); // -1 is a placeholder that isn't used.
    }

}
