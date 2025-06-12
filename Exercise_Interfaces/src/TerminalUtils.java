import java.util.Scanner;
import java.util.ArrayList;


public class TerminalUtils {
    static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("==== Device Manager ====");
        System.out.println("(1). Add device");
        System.out.println("(2). Show devices");
        System.out.println("(3). Turn on device");
        System.out.println("(4). Turn off device");
        System.out.println("Enter any other key to exit.");
        System.out.println("-------");
    }

    public static void printMessage(String prompt) {
        System.out.println(prompt);
    }

    public static String getUserStr(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Since the menu is more for demo purposes, I don't care about validating input.
    public static int getUserInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printDevices(ArrayList<Connectable> devices) {
        for (int i = 0; i < devices.size(); i++) {
            Connectable d = devices.get(i);
            System.out.printf("(%d): Name: %s | Type: %s | State: %b%n", i + 1, d.getDeviceName(), d.getDeviceType() , d.getCurrentState());
        }
    }
}
