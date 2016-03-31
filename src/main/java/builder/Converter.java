package builder;

import model.Playlist;
import model.Song;

public class Converter {

    PlaylistConverter builder;

    /**
     * Constructor.
     *
     * @param builder The builder to use.
     */
    public Converter(PlaylistConverter builder) {
        this.builder = builder;
    }

    /**
     * Parse the playlist.
     *
     * @param playlist The playlist to parse.
     */
    public void parsePlaylist(Playlist playlist) {

        // Loop through the songs
        for (Song song : playlist.getSongs()) {
            builder.convertSong(song);
        }

    }
}
