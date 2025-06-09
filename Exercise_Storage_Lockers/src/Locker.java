public class Locker {
    private final String lockerID;
    private boolean isOccupied;
    private String contents;

    public Locker(String lockerID) {
        this.lockerID = lockerID;
        this.isOccupied = false;
        this.contents = "";
    }

    public void storeItem(String item) {
        this.contents = item;
        this.isOccupied = true;
    }

    public void removeItem() {
        this.contents = "";
        this.isOccupied = false;
    }

    public String getLockerID() {
        return this.lockerID;
    }

    public boolean getIsOccupied() {
        return this.isOccupied;
    }

    public String toString() {
        return String.format("ID: %s | Rented: %b | Contents: %s", lockerID, isOccupied, contents);
    }
}
