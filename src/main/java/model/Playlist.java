package model;

import java.util.ArrayList;

/**
 * Created by Ferdi on 15-3-2016.
 */
public class Playlist {

    private String title;
    private ArrayList<Song> songs;

    public Playlist()
    {
        songs = new ArrayList<Song>();
    }

    public void addSong(Song song)
    {
        this.songs.add(song);
    }

    public ArrayList<Song> getSongs()
    {
        return songs;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

}
