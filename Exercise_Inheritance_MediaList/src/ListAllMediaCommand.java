public class ListAllMediaCommand {
    public static void execute(MediaService mediaService) {
        TerminalUtils.displayMediaList(mediaService.getAllMedia());
    }
}
