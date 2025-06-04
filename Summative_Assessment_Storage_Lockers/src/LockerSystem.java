public class LockerSystem {
    private final Locker[] lockers;

    // if lockers[i] is null, then that locker isn't rented.
    public LockerSystem(int numberOfLockers) {
        lockers = new Locker[numberOfLockers];
    }

    // Rents a locker if there is at least one that is free, if all are taken, then a message is printed informing the rep.
    public void rentLocker(String lockerPIN) {
        if (isAvailableLocker()) {
            int lockerID = findNextAvailableLocker(); // Return the first available index from the lockers[] array.
            lockers[lockerID] = new Locker(lockerPIN);
            System.out.printf("Locker #%d has been rented with PIN %s%nUse this PIN to access / reset the locker.%n", lockerID, lockerPIN);
        } else {
            System.out.println("No available lockers to rent. All locker are already rented.");
        }
    }


    public void accessLocker(int lockerID) {
        System.out.printf("Locker #%d has been opened. Make sure to lock it up when you're done.%n", lockerID);
    }

    public void deleteLocker(int lockerID) {
        lockers[lockerID] = null;
        System.out.printf("Locker #%d has been released. PIN has been reset.", lockerID);
    }

    // Returns true if locker isn't rented, else false.
    public boolean isLockerEmpty(int lockerID) {
        return lockers[lockerID] == null;
    }

    // Allows for a PIN of a certain locker in the lockers[] array to checked. Used for validating PINs inputted into the program.
    public boolean validatePIN(int lockerID, String PIN) {
        return lockers[lockerID].validatePIN(PIN);
    }

    // Checks to see if there is at least one available locker.
    public boolean isAvailableLocker() {
        for (int i = 0; i < lockers.length; i++) {
            if (isLockerEmpty(i)) {
                return true;
            }
        }
        return false;
    }


    // finds earliest lockerID that is free. Only is called if there is at least one free locker. If somehow this function is called and there isn't a free locker, an error is thrown.
    private int findNextAvailableLocker() throws IllegalStateException {
        for (int i = 0; i < lockers.length; i++) {
            if (isLockerEmpty(i)) {
                return i;
            }
        }
        // If the function has somehow been invoked when there all lockers are already rented.
        throw new IllegalStateException("Illegal Function Call: No Lockers Available to Rent");
    }

    // Prints all lockers with their ID and their state (rented or free)
    public void printLockers() {
        System.out.println("ID | State");
        for (int i = 0; i < lockers.length; i++) {
            if (isLockerEmpty(i)) {
                System.out.printf("%3d| Free%n", i);
            } else {
                System.out.printf("%3d| Rented%n", i);
            }
        }
    }
}