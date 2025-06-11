public class AddMediaCommand {
    // AddMediaCommand has its own menu, instead of making one workflow class for each menu option (adding a book / video / image)
    // I instead created just one workflow class for this workflow class
    public static void execute(MediaService mediaService) {
        TerminalUtils.displayAddMediaMenu();
        String userInput = TerminalUtils.getMenuChoice(new String[]{"1", "2", "3", "4"});

        switch (userInput) {
            case "1": // Add video
                AddMediaUtils.addUserVideo(mediaService);
                break;
            case "2": // Add audio
                AddMediaUtils.addUserAudio(mediaService);
                break;
            case "3": // Add image
                AddMediaUtils.addUserImage(mediaService);
                break;
            case "4": // Add book
                AddMediaUtils.addUserBook(mediaService);
                break;
            default: // If user somehow gets pass input validation, do nothing.
                break;
        }
    }
}
