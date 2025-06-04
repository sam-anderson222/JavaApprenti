// main only handles the menu logic

public class Main {
    public static void main(String[] args) {
        LockerService ls = new LockerService(10);

        // Main app loop
        while (true) {
            IO.printMenu();
            break;
            //String user_action = IO.getUserAction("");
        }

    }
}
