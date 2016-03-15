package model;

import java.io.File;
import com.mpatric.mp3agic.Mp3File;

/**
 * Created by Ferdi on 15-3-2016.
 */
public class Song {
    private String fileURL;
    private String title;
    private String artist;
    private String album;


    /**
     * Constructor for adding a song
     * @param fileURL File of the song
     * @param title Title of the song
     * @param artist Artist of the song
     * @param album Album of the song
     */
    public Song(String fileURL, String title, String artist, String album) {
        this.fileURL = fileURL;
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public String getFile()
    {
        return fileURL;
    }

    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getAlbum()
    {
        return album;
    }
}
