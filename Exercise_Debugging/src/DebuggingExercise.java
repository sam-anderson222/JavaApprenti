public class DebuggingExercise {
    /*
    Reflection Questions

    1. The issue with the calculateSum method was the for-loop. The i variable was set to 1, which
    eventually caused the value to exceed the range of the array as the conditional was less than or equal to the length of the array.
    This caused an out-of-bounds array index error.

    2. Step in allowed me to see all the recursive function calls in order as n was reduced until it reached it base case (n == 0)
    when all the factorial function calls then returned.

    3. If you use step over, you'll execute the entire method with stopping, and any code ran inside that method will be run.
    If you step into the method however, then you'll be able to step through and see any local variables as the method is run.
    For example, during this exercise, I stepped into the calculateSum method, which allowed me to see its code and variables like
    'total' and 'i' (from the for-loop), which helped me in debugging the error in the method.

    4. The memory state is a useful tool that allows you to see the value of variables at a certain point in the program's execution.
    This is helpful as it allow the programmer to check if the value stored in the program are what's to be expected or if there is an error.
    For example, during this exercise, the memory state panel allowed me to the 'total' which was being calculated inside the calculateSum function.
    I saw that the first number added to the total wasn't 5, but 10, which gave me a hint at where a possible bug in the program could be located.

     */

    public static void main(String[] args) {
        System.out.println("Starting Debugging Exercise...");

        int[] numbers = {5, 10, 15, 20, 25};

        System.out.println("Calculating Sum...");
        int total = calculateSum(numbers);
        System.out.println("Sum: " + total);
        System.out.println("Calculating Factorial...");
        int factorialResult = factorial(5);
        System.out.println("Factorial of 5: " + factorialResult);
        System.out.println("Debugging Exercise Complete!");
    }
    // Method to calculate sum of an array (contains a bug)
    public static int calculateSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) { // Fixed: by making the index start at 0 instead of one, and changing the condition.
            sum += nums[i]; // Bug: Incorrect index usage
        }
        return sum;
    }
    // Recursive method to calculate factorial
    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
