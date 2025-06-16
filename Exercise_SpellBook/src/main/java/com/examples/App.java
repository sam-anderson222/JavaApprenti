package com.examples;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        SpellBook spellBook = new SpellBook();

        // Main app loop
        while (true) {
            TerminalUtils.printMenu();
            String userInput = TerminalUtils.getUserStr("Enter choice: ");

            switch (userInput) {
                case "1":
                    String spellIncant = TerminalUtils.getUserStr("Recite a spell: ");
                    spellBook.tryIncantation(spellIncant);
                    break;
                case "2":
                    // To-do add help menu
                    TerminalUtils.printHelpMenu(spellBook);
                    break;
                default:
                    TerminalUtils.printMessage("Error, unknown input received! Try again.");
                    break;
            }
        }
    }
}
