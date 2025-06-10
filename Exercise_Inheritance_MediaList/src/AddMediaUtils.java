// A list of functions that are used in the AddMediaCommand menu to prompt the user for
// different inputs depending on which type of media they wish to add.

public class AddMediaUtils {
    public static void addUserVideo(MediaService mediaService) {
        String name = TerminalUtils.getString("Enter video name: ");
        int duration = TerminalUtils.getInt("Enter video duration (minutes): ");
        String resolution = TerminalUtils.getString("Enter video resolution: ");

        // Add video to media list and display success message.
        mediaService.addMedia(new Video(name, duration, resolution));
        TerminalUtils.displayMessage("Video successfully added!");
    }

    public static void addUserAudio(MediaService mediaService) {
        String name = TerminalUtils.getString("Enter audio name: ");
        int duration = TerminalUtils.getInt("Enter video duration (minutes): ");
        String artist = TerminalUtils.getString("Enter artist's name: ");

        // Add audio to media list and display success message.
        mediaService.addMedia(new Audio(name, duration, artist));
        TerminalUtils.displayMessage("Audio successfully added!");
    }

    public static void addUserImage(MediaService mediaService) {
        String name = TerminalUtils.getString("Enter image name: ");
        String dimensions = TerminalUtils.getString("Enter image dimensions (ex: 1920x1080): ");
        String fileFormat = TerminalUtils.getString("Enter image's file format: ");

        // Add image to media list and display success message.
        mediaService.addMedia(new Image(name, dimensions, fileFormat));
        TerminalUtils.displayMessage("Image successfully added!");
    }

    public static void addUserBook(MediaService mediaService) {
        String name = TerminalUtils.getString("Enter book name: ");
        String author = TerminalUtils.getString("Enter author name: ");
        int pageCount = TerminalUtils.getInt("Enter book's page count: ");


        // Add book to media list and display success message.
        mediaService.addMedia(new Book(name, author, pageCount));
        TerminalUtils.displayMessage("Video successfully added!");
    }
}
