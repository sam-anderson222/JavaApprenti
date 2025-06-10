public class AccessLockerWorkflow {
    public static void execute(LockerService ls) {
        // Get and check locker ID.
        ResultInt lockerID = WorkflowUtils.getValidLockerID(ls);
        if (!lockerID.getStatus()) { // If the status is false, then ID is invalid.
            return; // If invalid ID, do nothing, causing the loop to kick the user back to the main menu.
        }

        // Get and check locker PIN.
        ResultStr lockerPIN = WorkflowUtils.getValidLockerPIN(ls, lockerID.getNumber()); // LockerID must be passed in to check if a PIN goes to a certain locker.
        if (!lockerPIN.getStatus()) { // If the status is false, then that means the PIN is invalid.
            return; // If invalid PIN, do nothing, causing the loop to kick the user back to the main menu.
        }

        IO.printResult(ls.accessLocker(lockerID.getNumber()));
    }
}
