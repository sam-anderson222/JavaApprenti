public class Image extends Media implements MediaFunctions{
    private String dimensions;
    private String fileFormat;

    public Image(String name, String dimensions, String fileFormat) {
        this.name = name;
        this.dimensions = dimensions;
        this.fileFormat = fileFormat;
    }

    // Getter / Setters
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
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
        return String.format("Name: %s | Type: %s | Resolution: %s | File Format: %s", name, "Image", dimensions, fileFormat);
    }
}
