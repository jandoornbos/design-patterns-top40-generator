package model;

import java.util.ArrayList;

/**
 * Created by Ferdi on 15-3-2016.
 */
public class Playlist {
    private ArrayList<Song> songs;

    public Playlist()
    {

    }

    public void addSong()
    {
        this.songs.add(new Song("C:/Users/Ferdi/Documents/Design Patterns/Testje.mp3", "Test", "Testsong", "albumtest"));
    }

    public ArrayList<Song> getSongs()
    {
        return songs;
    }
}
