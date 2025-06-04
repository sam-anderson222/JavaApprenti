// main only handles the menu logic

public class Main {
    public static void main(String[] args) {
        boolean runProgram = true;
        int numberOfLockers = 10; // This is stored as a variable so it can be passed into IO class functions.
        LockerService ls = new LockerService(numberOfLockers);

        // Main app loop
        while (runProgram) {
            IO.printMenu();
            String user_action = IO.getUserAction(">> ");
            switch (user_action) {
                case "1":
                    IO.printResult(ls.rentLocker());
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    runProgram = false;
                    break;
            }
        }

    }
}
