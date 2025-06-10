public class Video extends Media{
    private int duration;
    private String resolution;

    public Video(String name, int duration, String resolution) {
        this.name = name;
        this.duration = duration;
        this.resolution = resolution;
    }

    // Getter / Setters
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getResolution() {
        return resolution;
    }

    public void setDuration(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public void play() {
        System.out.printf("Playing video '%s' using video player software.%n", name);
    }

    @Override
    public String getDescription() {
        return String.format("Name: %s | Type: %s | Duration : %dm | Resolution: %s", name, "Video", duration, resolution);
    }
}
