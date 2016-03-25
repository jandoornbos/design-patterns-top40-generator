package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "Song")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"fileURL", "title", "artist", "album"})
public class Song {
    private String fileURL;
    private String title;
    private String artist;
    private String album;

    public Song() {}

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
