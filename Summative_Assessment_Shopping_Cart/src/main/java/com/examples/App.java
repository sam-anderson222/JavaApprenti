package com.examples;

public class App {
    public static void main(String[] args) {
        boolean runProgram = true;


        // Main app loop
        while (runProgram) {
            TerminalUtils.printMenu();
            String userInput = TerminalUtils.getUserStr("Enter an option: ");

            switch (userInput) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    runProgram = false;
                    break;
                default:
                    TerminalUtils.printMessage("Error, unknown choice selected. Please try again.");
                    break;
            }
        }

        // Thank you message / end of program
        TerminalUtils.printMessage("\n(Thank you for using the shopping cart application!)");
    }
}
