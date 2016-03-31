package model;

import java.util.Random;

public class Song {

    private String fileURL;
    private String title;
    private String artist;
    private String album;

    private int streamCount;
    private int cdBuyCount;
    private int itunesBuyCount;

    private static int UPPER_BOUND = 1000000;

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

        Random random = new Random();
        this.streamCount = random.nextInt(UPPER_BOUND) + 1;
        this.cdBuyCount = random.nextInt(UPPER_BOUND) + 1;
        this.itunesBuyCount = random.nextInt(UPPER_BOUND) + 1;
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

    public int getStreamCount() {
        return this.streamCount;
    }

    public int getCdBuyCount() {
        return this.cdBuyCount;
    }

    public int getItunesBuyCount() {
        return this.itunesBuyCount;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%d\t%d\t%d", getArtist(), getTitle(), getStreamCount(), getCdBuyCount(), getItunesBuyCount());
    }
}
