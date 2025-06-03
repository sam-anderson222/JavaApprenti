public class LockerSystem {
    private Locker[] lockers;

    public LockerSystem(int numberOfLockers) {
        lockers = new Locker[numberOfLockers];
    }

    public void printLockers() {
        for (int i = 0; i < lockers.length; i++) {
            System.out.println(i + ", " + lockers[i]);
        }
    }

    public void createLocker(int lockerID, String lockerPIN) {
        if (lockers[lockerID] == null) {
            lockers[lockerID] = new Locker(lockerPIN);
            System.out.printf("Locker %d created with PIN %s%n", lockerID, lockerPIN);
        } else {
            System.out.println("Error, locker already created with this lockerID");
        }
    }

    public void deleteLocker(int lockerID, String lockerPIN) {
        if (lockers[lockerID] == null) {
            System.out.println("Cannot delete an empty locker.");
        } else if (lockers[lockerID].validatePIN(lockerPIN)) {
            lockers[lockerID] = null;
            System.out.printf("Locker %d deleted with PIN %s%n", lockerID, lockerPIN);
        } else {
            System.out.println("Incorrect PIN, could not delete.");
        }
    }
}
