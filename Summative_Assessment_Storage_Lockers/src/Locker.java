public class Locker {
    private final String lockerPIN;

    public Locker(String lockerPIN) {
        this.lockerPIN = lockerPIN;
    }

    // Checks if a user inputted PIN is the correct PIN to open the locker.
    public boolean checkPIN(String PIN) {
        return this.lockerPIN.equals(PIN);
    }
}
