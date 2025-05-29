public class Exercise_Strings {
    public static void main(String[] args) {
        // Part 1

        // Declare and assign
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName + " " + lastName;

        // Printing
        System.out.println("\n(Part 1)\n");
        System.out.println("Full name: " + fullName);
        System.out.println("Length: " + fullName.length());
        System.out.println("First character: " + fullName.charAt(0));
        System.out.println("Index of 'r': " + fullName.indexOf('r'));

        // Part 2
        String sentence = "Learning Java is fun!";

        System.out.println("\n(Part 2)\n");
        System.out.println("First word: " + sentence.substring(0,8));
        System.out.println("Second word: " + sentence.substring(9,13));
        System.out.println("Last word: " + sentence.substring(17));

        // Part 3
        String csvData = "apple,banana,grape,orange";
        String[] fruits = csvData.split(",");

        System.out.println("\n(Part 3)\n");
        for (int i = 0; i < fruits.length; i++) {
            System.out.printf("Fruit %d: %s%n", i+1, fruits[i]);
        }

        // Part 4
        sentence = "The quick brown fox.";
        String modifiedSentence = sentence.replace("quick", "slow").replace(" ", "_");

        // Printing
        System.out.println("\n(Part 4)\n");
        System.out.println("Modified sentence: " + modifiedSentence);
    }
}
