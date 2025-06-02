public class Main {
    public static void main(String[] args) {
        // Task 1, calling a simple method
        printWelcomeMessage();

        // Task 2: sum of 2 numbers
        System.out.printf("%d + %d = %d%n", 5, 13, sum(5,13));

        // Task 3: C to F
        System.out.printf("%.1fC equals %.1fF%n", 35f, convertToFahrenheit(35f));

        // Task 4: is even function
        System.out.printf("%d is even? %b%n", 5, isEven(5));
        System.out.printf("%d is even? %b%n", 16, isEven(16));
        System.out.printf("%d is even? %b%n", 4, isEven(4));
        System.out.printf("%d is even? %b%n", 11, isEven(11));

        // Task 5: print multiple times
        printMultipleTimes("Hello World", 4);

        // Task 6: max of three numbers
        System.out.printf("The max of (%d, %d, %d) is %d%n", 4, 3, 2, findMax(3,10,100));

        // Task 7: factorial with recursion
        System.out.printf("%d! = %d%n", 5, factorial(5));
        System.out.printf("%d! = %d%n", 7, factorial(7));
        System.out.printf("%d! = %d%n", 10, factorial(10));

        // Task 8: Overloading greeting function
        greet("Mozart");
        greet("Beethoven", 37);

        // Task 9: Count vowels
        System.out.printf("In '%s' there are %d vowels.%n", "hello world", countVowels("hello world"));
        System.out.printf("In '%s' there are %d vowels.%n", "java programming", countVowels("java programming"));

        // Task 10: Mini calculator
        System.out.printf("%d %c %d = %.1f%n", 4, '+', 8, calculator(4,8,'+'));
        System.out.printf("%d %c %d = %.1f%n", 2, '-', 6, calculator(2,6,'-'));
        System.out.printf("%d %c %d = %.1f%n", 9, '*', 4, calculator(9,4,'*'));
        System.out.printf("%d %c %d = %.1f%n", 1, '/', 2, calculator(1,2,'/'));
        System.out.printf("%d %c %d = %.1f%n", 4, '/', 0, calculator(4,0,'/'));
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Java Methods Exercise!");
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static double convertToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static boolean isEven(int number) {
        return (number % 2 == 0);
    }

    public static void printMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    public static int findMax(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void greet(String name) {
        System.out.printf("Hello %s!%n", name);
    }

    public static void greet(String name, int age) {
        System.out.printf("Hello %s! You are %d years old.%n", name, age);
    }

    public static int countVowels(String text) {
        int vowelCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }

        return vowelCount;
    }

    public static double calculator(int num1, int num2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error division by zero, returning zero");
                    result = 0;
                } else {
                    result = num1 / (double) num2;
                }
                break;
            default:
                System.out.println("Error invalid operation, returning zero");
                result = 0;
                break;
        }
        return result;
    }
}
