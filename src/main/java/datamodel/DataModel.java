package datamodel;

import model.Playlist;
import model.Song;

public class DataModel {

    private static DataModel sharedInstance = new DataModel();

    private Playlist dutchPlaylist;
    private Playlist englishPlaylist;

    /**
     * Constructor.
     */
    private DataModel() {

        // Setup Dutch playlist
        dutchPlaylist = new Playlist();
        dutchPlaylist.setTitle("Dutch");

        englishPlaylist = new Playlist();
        englishPlaylist.setTitle("English");
        englishPlaylist.addSong(new Song("http://top40.doornbosagrait.tk/uploads/kensington-riddles.mp3", "Riddles", "Kensington", "Vultures"));
        englishPlaylist.addSong(new Song("http://top40.doornbosagrait.tk/uploads/marcoborsato-alsrennengeenzinmeerheeft.mp3", "Als Rennen Geen Zin Meer Heeft", "Marco Borsato", "Dromen Durven Delen"));

    }

    public static DataModel getInstance() {
        return sharedInstance;
    }

    public Playlist getDutchPlaylist() {
        return dutchPlaylist;
    }

    public Playlist getEnglishPlaylist() {
        return englishPlaylist;
    }

}
