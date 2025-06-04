public class Locker {
    private final int lockerID;
    private final String lockerPIN;

    public Locker(int lockerID, String lockerPIN) {
        this.lockerID = lockerID;
        this.lockerPIN = lockerPIN;
    }

    public int getLockerID() {
        return lockerID;
    }

    // Checks if a user inputted PIN is the correct PIN to open the locker.
    public boolean checkPIN(String PIN) {
        return this.lockerPIN.equals(PIN);
    }
}
