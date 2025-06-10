import java.util.Random;

// All PIN methods are here.

public class PinUtils {

    // Randomly generate a 4-digit PIN that is returned as a string
    public static String generatePIN() {
        Random rng = new Random();
        String PIN = "";
        // number 0 - 9 will be appended one-by-one until a 4-digit PIN String is created.
        for (int i = 0; i < 4; i++) {
            PIN += Integer.toString(rng.nextInt(10));
        }
        return PIN;
    }

    // Checks if a string is in PIN format. (4 length string with only numbers)
    public static boolean isPINFormat(String PIN) {
        if (PIN.length() != 4) { // If PIN isn't 4-digits
            return false;
        }
        // If PIN is correct length, then each char is checked to see if it is a number.
        for (int i = 0; i < PIN.length(); i++) {
            if (!isNumber(PIN.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Return true if char is a number 0 - 9.
    private static boolean isNumber(char c) {
        return (c >= '0' && c <= '9'); // Compares ascii values to determine if char is a number or not.
    }
}
