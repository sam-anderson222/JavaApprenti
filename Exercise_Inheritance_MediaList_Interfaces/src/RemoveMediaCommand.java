public class RemoveMediaCommand {
    public static void execute(MediaService mediaService) {
        TerminalUtils.displayMediaNames(mediaService.getAllMedia());

        if (mediaService.isEmpty()) { // Don't prompt for input if there are no medias to remove.
            return;
        }

        // User prompting
        int userInput = TerminalUtils.getInt("Choose an media to remove: ");

        boolean removalSuccessful = mediaService.removeMedia(userInput);

        if(removalSuccessful) {
            TerminalUtils.displayMessage("Media successfully removed!");
        } else {
            TerminalUtils.displayMessage("Error, could not remove! Invalid choice, no media exists at index #" + userInput );
        }
    }
}
