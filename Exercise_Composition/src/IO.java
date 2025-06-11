import java.util.Scanner;

public class IO {
    private static final Scanner io = new Scanner(System.in);

    public static void printArtifact(Artifact artifact) {
        System.out.print("\n"); // Added space between input and printArtifact
        System.out.printf("Artifact: %s (%d)%n", artifact.getName(), artifact.getYearOfDiscovery());
        System.out.printf("Discoverer: %s%n", artifact.getDiscoverer().toString());
        System.out.printf("Curator: %s%n", artifact.getCurator().toString());
    }

    public static String getUserStr(String prompt) {
        System.out.print(prompt);
        return io.nextLine();
    }

    public static int getUserInt(String prompt) {
        // Validation loop
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(io.nextLine());
            } catch (Exception ex) {
                System.out.println("Error! Please input a number, not text.");
            }
        }
    }

}
