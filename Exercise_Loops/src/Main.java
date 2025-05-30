import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        Random rng = new Random();
        int userInputInt;
        String userInput;

        // Uncomment exercises if you wish to check them

//        // Basic Loop Practice
//        // Count Up
//        System.out.println("\n(Count Up)");
//        for (int i = 1; i <= 100; i++) {
//            if (i % 2 == 0) {
//                System.out.println(i);
//            }
//        }
//
//        // Countdown Timer
//        System.out.println("\n(Countdown)");
//        System.out.print("Enter the number to start the countdown from: ");
//        userInputInt = Integer.parseInt(io.nextLine());
//        for (int i = userInputInt; i >= 0; i--) {
//            if (i == 0) {
//                System.out.println("0, Blast Off!");
//            } else {
//                System.out.println(i);
//            }
//        }
//
//        // Guess the Number (
//        System.out.println("\n(Guess the number)");
//        int random_number = rng.nextInt( 1, 51);
//        System.out.println("Debug: " + random_number); // Shows you the random number so you don't have to guess for it. For testing purposes.
//
//        do {
//            System.out.print("Enter a guess from 1 to 50: ");
//            userInputInt = Integer.parseInt(io.nextLine());
//        } while(userInputInt != random_number);
//
//        System.out.println("You got it! The number was " + random_number);
//
//        // Intermediate Loop Practice
//
//        // Multiplication Table
//        System.out.println("\n(Multiplication Table)");
//        System.out.print("Enter the number multiply: ");
//        userInputInt = Integer.parseInt(io.nextLine());
//        for (int i = 1; i <= 10; i++) {
//            System.out.printf("%d * %d = %d%n", userInputInt, i, userInputInt * i);
//        }
//
//        // Password
//        System.out.println("\n(Password)");
//        System.out.print("Enter the password: ");
//        userInput = io.nextLine();
//
//        while (!userInput.equals("letmein")) {
//            System.out.print("Incorrect Password! Try Again: ");
//            userInput = io.nextLine();
//        }
//
//        // Find the First Vowel
//        System.out.println("\n(Find First Vowel)");
//        System.out.print("Enter a word: ");
//        userInput = io.nextLine();
//
//        for (int i = 0; i < userInput.length(); i++) {
//             char c = userInput.charAt(i);
//             if (c == 'a' || c == 'e' || c == 'i'|| c == 'o'|| c == 'u') {
//                 System.out.println("First vowel: " + c + ", Position: " + (i+1));
//            }
//        }
//
//
//        // Simple ATM
//        System.out.println("\n(Simple ATM)");
//        double accountBalance = 500;
//
//        do {
//            // print menu
//            System.out.println("(1). Withdraw");
//            System.out.println("(2). Deposit");
//            System.out.println("(3). Check Balance");
//            System.out.println("(4). Exit");
//
//            // prompt user
//            System.out.print(">> ");
//            userInputInt = Integer.parseInt(io.nextLine());
//
//            // do actions
//            switch (userInputInt) {
//                case 1:
//                    System.out.print("How much to withdraw: ");
//                    double withdraw = Integer.parseInt(io.nextLine());
//                    if (withdraw <= accountBalance) {
//                        accountBalance -= withdraw;
//                    } else {
//                        System.out.print("Error! Can't withdraw more than account balance.");
//                    }
//                    break;
//                case 2:
//                    System.out.print("How much to deposit: ");
//                    double deposit = Integer.parseInt(io.nextLine());
//                    accountBalance += deposit;
//                    break;
//                case 3:
//                    System.out.printf("Balance: $%.2f%n", accountBalance);
//                    break;
//                case 4:
//                    System.out.println("Exiting ATM App");
//                    break;
//                default:
//                    System.out.println("Invalid option");
//                    break;
//            }
//
//        } while (userInputInt != 4);
//
//
//
//        // Advanced Loop Practice
//
//        // Fizzbuzz
//        System.out.println("\n(Fizzbuzz)");
//
//        for (int i = 1; i <= 100; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println("Fizzbuzz");
//            } else if (i % 5 == 0) {
//                System.out.println("Buzz");
//            } else if (i % 3 == 0) {
//                System.out.println("Fizz");
//            } else {
//                System.out.println(i);
//            }
//        }
//
//
//        // Reverse a string
//        System.out.println("\n(Reverse a string)");
//        System.out.print("Enter a string: ");
//        userInput = io.nextLine();
//
//        String reversedWord = "";
//        for (int i = userInput.length() - 1; i >= 0; i--) {
//            reversedWord += userInput.charAt(i);
//        }
//        System.out.println(reversedWord);
//
//        // Prime Number Checker
//        System.out.println("\n(Prime number checker)");
//        System.out.print("Enter a number: ");
//        userInputInt = Integer.parseInt(io.nextLine());
//        int factor = 2;
//        boolean isPrime = true; // Assume the number is prime, then check if it not.
//        while (factor < userInputInt - 1) {
//            if (userInputInt % factor == 0) {
//                isPrime = false;
//                break;
//            }
//            factor++;
//        }
//        System.out.println(userInputInt + " is prime: " + isPrime);
//
//
//        // Word Counter
//        System.out.println("\n(Word counter)");
//        System.out.print("Enter a sentence: ");
//        userInput = io.nextLine();
//        String[] words = userInput.split(" ");
//
//        for (int i = 1; i <= words.length; i++) {
//            System.out.println(words[i - 1] + ", " + i);
//        }
//
//
//
//
//        // Break & Continue Challenges
//        System.out.println("\n(Skip Negative)");
//        while (true) {
//            System.out.print("Enter a number: ");
//            userInputInt = Integer.parseInt(io.nextLine());
//            if (userInputInt < 0) {
//                continue;
//            } else if (userInputInt == 0) {
//                break;
//            } else {
//                System.out.println("You entered: "+ userInputInt);
//            }
//
//        }
//
//        // Find the first prime
//        System.out.println("\n(Find the first prime)");
//        System.out.print("Enter the lower bound (min 2): ");
//        int lowerBound = Integer.parseInt(io.nextLine());
//        System.out.print("Enter the upper bound: ");
//        int upperBound = Integer.parseInt(io.nextLine());
//
//        for (int currentNumber = lowerBound; currentNumber <= upperBound; currentNumber++) { // Loop through range
//            boolean isPrime = true;
//            for (int factor = 2; factor < lowerBound; factor++) {
//                if (currentNumber % factor == 0) { // If number is not prime (is divisible)
//                    isPrime = false;
//                }
//            }
//            if (isPrime) {
//                System.out.println("First prime in this range is: " + currentNumber);
//                break;
//            }
//        }
//
//
//        // Infinite Loops
//        // Fix the infinite loop
//        int i = 0;
//        while (i < 10) {
//            System.out.println(i);
//            i++;
//        }
//
//        // Even number checker
//        System.out.println("\n(Even number checker)");
//
//        do {
//            System.out.print("Enter an even number: ");
//            userInputInt = Integer.parseInt(io.nextLine());
//        } while (userInputInt % 2 == 1);


        // Mini Game
        String[] fruits = new String[] {"Apple", "Banana", "Cherry"};
        int randomFruitIndex = rng.nextInt(3);
        do {
            System.out.print("Guess the word (Apple, Banana, Cherry): ");
            userInput = io.nextLine();
        } while (!userInput.equals(fruits[randomFruitIndex]));
        System.out.println("You got it! The fruit was a " + fruits[randomFruitIndex]);


    }
}
