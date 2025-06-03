import java.util.Scanner;

public class Main {
    private static Scanner io = new Scanner(System.in);

    public static void main(String[] args) {
        int PIN;
        int age;
        String email;

        while (true) {
            try {
                age = getAge("Enter your age: ");
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input! Must enter number for age!");
            }
        }

        while (true) {
            try {
                email = getEmail("Enter your email: ");
                break;
            } catch (NullPointerException ex) {
                System.out.println("Invalid Email! Cannot enter empty text as email!");
            }
        }

        while (true) {
            try {
                PIN = getPIN("Enter your 4-digit PIN: ");
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input! Must enter number for PIN!");
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid PIN! PIN must be 4-digits long!");
            }
        }

        System.out.println("Registration Successful!");
        System.out.printf("Age: %d%nEmail: %s%nPIN: %d%n", age, email, PIN);

    }

    public static int getAge(String prompt) {
        System.out.printf(prompt);
        return Integer.parseInt(io.nextLine()); // throws NumberFormatException
    }

    public static String getEmail(String prompt) {
        System.out.printf(prompt);
        String email = io.nextLine();
        if (email.isEmpty()) {
            throw new NullPointerException("Invalid / Empty Email");
        }

        return email;
    }

    public static int getPIN(String prompt) {
        System.out.printf(prompt);
        int pin = Integer.parseInt(io.nextLine()); // NumberFormatException
        if (pin < 1000 || pin > 9999) {
            throw new IllegalArgumentException("Pin must be 4-digits");
        }

        return pin;
    }
}
