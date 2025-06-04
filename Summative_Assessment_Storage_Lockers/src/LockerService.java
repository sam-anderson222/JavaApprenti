// Handles locker functions / validation

public class LockerService {
    private Locker[] lockers;

    public LockerService(int numberOfLockers) {
        lockers = new Locker[numberOfLockers];
    }

    public ResultStr rentLocker() {
        // If a locker is available
        ResultInt rentableLocker = checkLockerAvailability();
        if (rentableLocker.getStatus()) { // If there is at least one rentable locker, then .getStatus() is true.
            int freeLockerIndex = rentableLocker.getNumber();
            String lockerPIN = IO.generatePIN();

            lockers[freeLockerIndex] = new Locker(freeLockerIndex + 1, lockerPIN); // One is added to make 1-based index instead of 0-based.
            return new ResultStr(true, String.format("Locker #%d rented. Your PIN is %s%n", freeLockerIndex + 1, lockerPIN));

        } else {
            // else if no locker is available
            return new ResultStr(false, "Locker not rented: no available lockers left.");
        }
    }

    public ResultStr accessLocker() {
        return null;
    }

    public ResultStr releaseLocker() {
        return null;
    }

    // Returns a ResultInt. The boolean tells if there is an available locker and int tells the index of the earliest available locker.
    // This is private as it is only used in the LockerService class.
    private ResultInt checkLockerAvailability() {
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i] == null) { // If there is an available locker
                return new ResultInt(true, i);
            }
        }
        // If loop runs fully and no empty spots are found, then all lockers must be rented.
        return new ResultInt(false, -1); // -1 is a placeholder that isn't used.
    }


}
