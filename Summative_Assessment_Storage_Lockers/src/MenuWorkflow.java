// Handle printing different menus and getting the user action based on if all locker as rented or not.

public class MenuWorkflow {
    // returns String as this will return the user's action after accounting for the case where the menu option have shifted over due to all lockers being rented.
    public static String execute(LockerService ls) {
        boolean isAvailableLockers = ls.checkLockerAvailability().getStatus();
        IO.printMenu(isAvailableLockers); // Rent locker option is removed if there are no available lockers.
        String user_action = IO.getUserString(">> ");

        // The removal of the rent option in the case where there are no lockers to rent causes the options to shift over.
        // Ex. Access Locker goes from option 2 -> option 1.
        // This function maps the options to their original numbers.
        if (!isAvailableLockers) {
            user_action = unshiftOptions(user_action);
        }

        return user_action;
    }

    // In the case where there are no lockers to rent, the rent option is removed, which causes the access locker option to shift from
    // option 2 to 1, and so on. To fix this, this function maps the user action back to its original values when the rent locker option is present.
    private static String unshiftOptions(String user_action) {
        return switch (user_action) {
            case "1" -> "2";
            case "2" -> "3";
            default -> "exit program";
        };
    }
}
