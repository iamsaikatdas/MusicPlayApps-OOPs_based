public class Songs {
    private String title;
    private double duration;
    private String artist;
    private String genre;

    public Songs(String title, double duration, String artist, String genre) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.genre = genre;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // uses of toString function. - override the toString function.
    // when i will try to printing song object takhn amk object er address print hobe. but ata korle return
    // e ja thakbe seta print hobe. look int - Main function (abc) reference.
    @Override
    public String toString() {
        return "Songs{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
