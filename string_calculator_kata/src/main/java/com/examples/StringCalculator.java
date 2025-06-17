package com.examples;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        String[] nums = splitWithDelimiters(numbers);

        if (numbers.isEmpty()) {
            return 0;
        } else {
            return getSum(nums);
        }
    }

    private int getSum(String[] nums) {
        checkForNegatives(nums); // Throws error if there are negative numbers.
        int sum = 0;

        // Only runs if there are no negatives.
        for (String strNum: nums) {
            int number = Integer.parseInt(strNum);
            if (number < 1000) { // Ignores numbers bigger than 1,000.
                sum += number;
            }
        }
        return sum;
    }

    // Throws an error if there are negative numbers in nums.
    private void checkForNegatives(String[] nums) throws IllegalArgumentException{
        boolean hasNegativeNumbers = false; // assume has no negatives.
        String errorMessage = "Negatives not allowed:";

        for (String strNum: nums) {
            int number = Integer.parseInt(strNum);
            if (number < 0) {
                hasNegativeNumbers = true;
                errorMessage += String.format(" %s", strNum);
            }
        }

        if (hasNegativeNumbers) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // Cannot split on regex characters.
    private String[] splitWithDelimiters(String numbers) {
        String defaultDelimiter = ",|\n"; // Separates on ',' and '\n'.

        // If text is too small to have a delimiter, return. You do this so you don't access an empty String.
        if (numbers.isEmpty()) {
            return null;
        }

        //        numbers          args[0],    args[1]
        // "//[d1][d2]\n[nums]"-> "//[d1][d2]", "[nums]"
        //   "//c\n[numbers]"  ->  "//c", "[nums]"
        //         "1\n2,3"    ->  "1", "2,3", since arg[0] doesn't contain "//" we know to use the default delimiters ("," or "\n")

        // Delimiter is always separated by \n.
        String[] arguments = numbers.split("\n"); //   "//c\n[numbers]"  ->  "//c", "[numbers]"
        if (arguments[0].contains("//")) { // If contains the delimiter signifier ('//') then there is a delimiter.
            if (arguments[0].contains("[")) { // If in the //[delim1][delim2]\n format, then more work needs to be done.
                return arguments[1].split(parseDelimiters(arguments[0]));

            } else { // If is in format //c\n[nums] then split [nums] on c.
                return arguments[1].split(arguments[0].substring(2, 3));

            }
        } else {
            return numbers.split(defaultDelimiter); // If no delimiter signifier, use default delimiter.
        }
    }

    // Turns from //[delim1][delim2][...][delimN]\n into a regex in the form "delim1|delim2|...|delimN"
    private String parseDelimiters(String delimiterArgument) {
        // Using a pointer algorithm to find all delimiters.
        String regexExpression = "";
        boolean addToRegex = false; // Only add to regex after '[' is found, then stop when ']' is found.

        for (int i = 0; i < delimiterArgument.length(); i++) {
            String s = delimiterArgument.substring(i, i+1); // Gets single character, but not as a char.
            if (s.equals("[")) {
                addToRegex = true;
                continue;
            } else if (s.equals("]")) {
                regexExpression += "|"; // add regex OR operator.
                addToRegex = false;
                continue;
            }

            if (addToRegex) {
                regexExpression += s;
            }
        }

        regexExpression = regexExpression.substring(0,regexExpression.length() - 1); // Remove extra '|' character.
        return regexExpression;
    }
}
