public class Audio extends Media {
    private int duration;
    private String artist;

    public Audio(String name, int duration, String artist) {
        this.name = name;
        this.duration = duration;
        this.artist = artist;
    }

    // Getter / Setters
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.printf("Playing audio '%s' using audio player software.%n", name);
    }

    @Override
    public String getDescription() {
        return String.format("Name: %s | Type: %s | Duration : %dm | Artist: %s", name, "Audio", duration, artist);
    }
}
