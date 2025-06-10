public class PlayMediaCommand {
    public static void execute(MediaService mediaService) {
        TerminalUtils.displayMediaNames(mediaService.getAllMedia());

        if (mediaService.isEmpty()) { // Don't prompt for input if there are no medias to remove.
            return;
        }

        // User prompting
        int userInput = TerminalUtils.getInt("Choose an media to play: ");

        Media userSelectedMedia = mediaService.findMediaByIndex(userInput);
        if (userSelectedMedia == null) { // If item at this index doesn't exist
            TerminalUtils.displayMessage("Error! Invalid choice, no media exists at index #" + userInput );
        } else {
            userSelectedMedia.play();
        }
    }
}
