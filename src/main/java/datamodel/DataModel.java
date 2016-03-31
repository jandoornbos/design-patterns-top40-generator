package datamodel;

import model.Playlist;
import model.Song;

public class DataModel {

    private static DataModel sharedInstance = new DataModel();

    private Playlist dutchPlaylist;
    private Playlist englishPlaylist;

    /**
     * Constructor.
     * Setups the playlist.
     */
    private DataModel()
    {
        // Setup Dutch playlist
        dutchPlaylist = new Playlist();
        dutchPlaylist.setTitle("Dutch");

        // Setup English playlist
        englishPlaylist = new Playlist();
        englishPlaylist.setTitle("English");
        englishPlaylist.addSong(new Song("http://top40.doornbosagrait.tk/uploads/kensington-riddles.mp3", "Riddles", "Kensington", "Vultures"));
        englishPlaylist.addSong(new Song("http://top40.doornbosagrait.tk/uploads/marcoborsato-alsrennengeenzinmeerheeft.mp3", "Als Rennen Geen Zin Meer Heeft", "Marco Borsato", "Dromen Durven Delen"));
    }

    /**
     * Get the singleton instance.
     *
     * @return A DataModel object.
     */
    public static DataModel getInstance()
    {
        return sharedInstance;
    }

    /**
     * Get the Dutch playlist.
     *
     * @return Dutch playlist.
     */
    public Playlist getDutchPlaylist()
    {
        return dutchPlaylist;
    }

    /**
     * Get the English playlist.
     *
     * @return English playlist.
     */
    public Playlist getEnglishPlaylist()
    {
        return englishPlaylist;
    }

}
