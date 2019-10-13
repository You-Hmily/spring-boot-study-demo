package soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc{

    private String title;

    private String artist;

    private List<String> tracks;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.printf("Playing %s by %s \n",title,artist);
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }
}
