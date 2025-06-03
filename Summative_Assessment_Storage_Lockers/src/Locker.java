public class Locker {
    private String lockerPIN;

    public Locker(String lockerPIN) {
        this.lockerPIN = lockerPIN;
    }

    // Checks if inputted PIN is equal to the PIN on the locker.
    public boolean validatePIN(String PIN) {
        return lockerPIN.equals(PIN);
    }

    // No getter / setter as lockerPIN should be immutable after creation and hidden.

}
