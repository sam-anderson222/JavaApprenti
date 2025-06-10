public class Image extends Media{
    private String dimesions;
    private String fileFormat;

    public Image(String name, String dimensions, String fileFormat) {
        this.name = name;
        this.dimesions = dimensions;
        this.fileFormat = fileFormat;
    }

    // Getter / Setters
    public String getDimensions() {
        return dimesions;
    }

    public void setDimensions(String dimesions) {
        this.dimesions = dimesions;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public void play() {
        System.out.printf("Displaying image '%s' using image viewer software.%n", name);
    }

    @Override
    public String getDescription() {
        return String.format("Name: %s | Type: %s | Resolution: %s | File Format: %s", name, "Image", dimesions, fileFormat);
    }
}
