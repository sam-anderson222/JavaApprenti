public class Main {
    public static void main(String[] args) {
        boolean runProgram = true;
        MediaService mediaService = new MediaService();

        // Main app loop
        while(runProgram) {
            TerminalUtils.displayMainMenu();
            String userInput = TerminalUtils.getMenuChoice(new String[]{"1", "2", "3", "4", "5"}); // Gets and validates user input.

            switch (userInput) {
                case "1":
                    AddMediaCommand.execute(mediaService);
                    break;
                case "2":
                    RemoveMediaCommand.execute(mediaService);
                    break;
                case "3":
                    PlayMediaCommand.execute(mediaService);
                    break;
                case "4":
                    ListAllMediaCommand.execute(mediaService);
                    break;
                case "5":
                    runProgram = false;
                    break;
                default: // If user somehow gets pass input validation, do nothing.
                    break;
            }
        }

        // Print thank you message
        TerminalUtils.displayMessage("\n(Thank you for using the media manager!)");
    }
}
