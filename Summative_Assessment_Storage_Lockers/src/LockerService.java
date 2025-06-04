// Handles locker functions / validation

public class LockerService {
    private Locker[] lockers;

    public LockerService(int numberOfLockers) {
        lockers = new Locker[numberOfLockers];
    }

    public Result rentLocker() {
        // If a locker is available
        if (true) {
            return new Result(true, "Locker rented: locker info placeholder.");
        } else {
            // else if no locker is available
            return new Result(false, "Locker not rented: no available lockers left.");
        }
    }


}
