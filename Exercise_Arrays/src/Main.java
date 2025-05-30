import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        // 1
        System.out.println("\n(Part 1)");
        String[] cityNames = new String[5];
        cityNames[0] = "Austin";
        cityNames[1] = "Houston";
        cityNames[2] = "Dallas";
        cityNames[3] = "Waco";
        cityNames[4] = "Fort Worth";

        // Print cityNames
        System.out.println("City names:");
        System.out.println(cityNames[0]);
        System.out.println(cityNames[1]);
        System.out.println(cityNames[2]);
        System.out.println(cityNames[3]);
        System.out.println(cityNames[4]);

        // Update 3rd city name and re-print array
        cityNames[2] = "San Antonio";
        System.out.println("\nUpdated city names:");
        System.out.println(cityNames[0]);
        System.out.println(cityNames[1]);
        System.out.println(cityNames[2]);
        System.out.println(cityNames[3]);
        System.out.println(cityNames[4]);

        System.out.println("Total number of cities: " + cityNames.length);

        // 2
        System.out.println("\n(Part 2)");

        // Print each city using a for loop.
        System.out.println("With a for-loop:");
        for (int i = 0; i < cityNames.length; i++) {
            System.out.printf("(%d): %s%n", i, cityNames[i]);
        }
        // Print in reverse order
        System.out.println("\nIn reverse order:");
        for (int i = cityNames.length - 1; i >= 0; i--) {
            System.out.printf("(%d): %s%n", i, cityNames[i]);
        }

        // Prompt user for city name.
        System.out.print("Enter a city name: ");
        boolean cityNameFound = false;
        String user_input = io.nextLine();
        // Check if city is found
        for (int i = 0; i < cityNames.length; i++) {
            if (user_input.equals(cityNames[i])) {
                cityNameFound = true;
                break;
            }
        }
        // Print different text depending on if city was found or not.
        if (cityNameFound) {
            System.out.println("City found!");
        } else {
            System.out.println("City not found!");
        }

        // 3
        System.out.println("\n(Part 3)");
        float[] testScores = new float[] {86, 44, 63, 91, 100}; // 5 test scores

        float sum = 0;
        float lowestScore = testScores[0]; // assume the first score is the lowest.
        float highestScore = testScores[0]; // assume the first score is the largest.

        // Calculate sum / min / max
        for (int i = 0; i < testScores.length; i++) {
            if (testScores[i] < lowestScore) {
                lowestScore = testScores[i];
            } else if (testScores[i] > highestScore) {
                highestScore = testScores[i];
            }
            sum += testScores[i];
        }

        float average = sum / testScores.length;

        // Print results
        System.out.println("Score results: ");
        for (int i = 0; i < testScores.length; i++) { // Print the scores.
            System.out.printf("(%d): %.1f%n", i + 1, testScores[i]);
        }
        System.out.printf("Sum: %.1f%n", sum);
        System.out.printf("Lowest Score: %.1f%n", lowestScore);
        System.out.printf("Highest Score: %.1f%n", highestScore);
        System.out.printf("Average: %.1f%n", average);




        // 4
        // P.10
        System.out.println("\n(Part 4)");
        System.out.println("(10). Finding 3s in 10 random numbers");
        Random rng = new Random(); // Random number generator
        int[] randomNumbers = new int[10];
        int numberOfThrees = 0;

        // Fill random numbers array with random numbers.
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rng.nextInt(1, 6);
            if (randomNumbers[i] == 3) {
                numberOfThrees++;
            }

            System.out.printf("(%d): %d%n", i, randomNumbers[i]);
        }
        System.out.println("Number of 3's: " + numberOfThrees);

        // P.11
        System.out.println("(11). Shifting array over one step left");
        int[] sampleArray = new int[] {1, 2, 3, 4, 5};

        // Shift over array 1.
        int[] temp = new int[5];
        for (int i = 0; i < sampleArray.length; i++) {
            if (i == 4) {
                temp[4] = sampleArray[0];
            } else {
                temp[i] = sampleArray[i + 1];
            }
        }
        sampleArray = temp;

        // print the sampleArray after being shifted
        for (int i = 0; i < sampleArray.length; i++) {
            System.out.println(i + ": " + sampleArray[i]);
        }

        // 12
        System.out.println("(12). Checking for duplicate in student names");
        String[] studentNames = new String[] {"Alan", "Bob", "Bob", "Carl", "Darrel", "Ed"};
        boolean containsDuplicate = false;

        // Searching for duplicate students.
        for (int i = 0; i < studentNames.length - 1; i++) { // Check first student against all students, then second against all students, and so on.
            for (int j = i + 1; j < studentNames.length; j++) {
                if (studentNames[j].equals(studentNames[i])) {
                    containsDuplicate = true;
                    break;
                }
            }
            if (containsDuplicate) { // Breaks out of the outer loop if duplicate is already found.
                break;
            }
        }

        if (containsDuplicate) {
            System.out.println("Duplicates Found!");
        } else {
            System.out.println("No Duplicates Found!");
        }

    }
}
