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

        // Generate some random numbers
        Random random = new Random();
        this.streamCount = random.nextInt(UPPER_BOUND) + 1;
        this.cdBuyCount = random.nextInt(UPPER_BOUND) + 1;
        this.itunesBuyCount = random.nextInt(UPPER_BOUND) + 1;
    }

    /**
     * Get the URL where the MP3 is hosted.
     *
     * @return The url.
     */
    public String getFile()
    {
        return fileURL;
    }

    /**
     * Get the song title.
     *
     * @return The song title.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Get the song artist.
     *
     * @return The song artist.
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Get the song album.
     *
     * @return The song album.
     */
    public String getAlbum()
    {
        return album;
    }

    /**
     * Get the amount of times the song is streamed by Spotify.
     *
     * @return The stream count.
     */
    public int getStreamCount()
    {
        return this.streamCount;
    }

    /**
     * How many times is this song sold on a CD?
     *
     * @return The amount of sold songs on CD.
     */
    public int getCdBuyCount()
    {
        return this.cdBuyCount;
    }

    /**
     * Get the amount of times the song is purchased on iTunes.
     *
     * @return The iTunes buy count.
     */
    public int getItunesBuyCount()
    {
        return this.itunesBuyCount;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%d\t%d\t%d", getArtist(), getTitle(), getStreamCount(), getCdBuyCount(), getItunesBuyCount());
    }
}
