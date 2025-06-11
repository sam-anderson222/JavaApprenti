public class IO {


    public static void printMessage(String message) {
        System.out.println(message);
    }

    // Prints the (A, B, C, D, E, ...) header
    public static void printBoardHeader(int numColumns) {
        System.out.print("    ");
        char header = 'A';
        for (int k = 0; k < numColumns; k++) {
            System.out.printf(" %c  ", header);
            header++;
        }
        System.out.println();
    }
}
