import java.util.ArrayList;

public class LockerManager {
    private ArrayList<Locker> lockers;

    public LockerManager() {
        lockers = new ArrayList<>();
    }

    public void addLocker(String lockerID) {
        lockers.add(new Locker(lockerID));
    }

    public Locker getLocker(String lockerID) {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockerID.equals(lockers.get(i).getLockerID())) {
                return lockers.get(i);
            }
        }

        return null; // Returns null if locker isn't found.
    }

    public void removeLocker(String lockerID) {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockerID.equals(lockers.get(i).getLockerID())) {
                lockers.remove(i);
            }
        }
    }

    public void displayAllLockers() {
        for (int i = 0; i < lockers.size(); i++) {
            System.out.println(lockers.get(i).toString());
        }
    }
}
