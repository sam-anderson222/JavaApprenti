import java.util.Scanner;
/*
        Storage Locker used by a service representative

        Rent a locker
        Access a locker
        Release a locker
        (added feature) show locker states

        Locker (Has a number and PIN and a state (is rented?))

        Data: Locker number, Locker PIN, and locker state
        The state can be determined using the PIN (if PIN == null) then locker isn't rented.

        Actions: Renting / Accessing / Releasing a locker.

        Locker() store locker information
        LockerSystem() holds all key locker actions and lockers array
        Main() Provides the menu for the rep. to use

        (added class) utils, handles and validates user input.

         */

public class Main {
    public static void main(String[] args) {
        LockerSystem ls = new LockerSystem(10); // A locker system with 10 lockers
        ls.createLocker(0, "8123");
        ls.createLocker(1, "5435");
        ls.createLocker(2, "8234");
        ls.createLocker(3, "1233");
        ls.printLockers();
        ls.deleteLocker(4, "1234");
        ls.deleteLocker(3, "1111");
        ls.deleteLocker(0, "8123");
        ls.printLockers();


    }
}
