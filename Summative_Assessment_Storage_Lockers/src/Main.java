// main handles the menu logic


public class Main {
    // ls is made static so it can be used in other static functions.
    static LockerService ls = new LockerService(6); // A locker system with 6 lockers


    public static void main(String[] args) {
        // Main app loop
        while (true) {
            String user_action = MenuWorkflow.execute(ls);

            if (user_action.equals("1")) {
                IO.printResult(ls.rentLocker()); // Method is simple, so no workflow class was created.
            } else if (user_action.equals("2")) {
                AccessLockerWorkflow.execute(ls);
            } else if (user_action.equals("3")) {
                ReleaseLockerWorkflow.execute(ls);
            } else { // Else exit the program.
                break;
            }
        }

        // Print thank you message.
        IO.printResult(new ResultStr(true, "Thank you for using the Storage Lockers program!"));
    }
}
