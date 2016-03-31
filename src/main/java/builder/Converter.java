package builder;

import model.Playlist;
import model.Song;

public class Converter {

    PlaylistConverter builder;

    public Converter(PlaylistConverter builder) {
        this.builder = builder;
    }

    public void parsePlaylist(Playlist playlist) {

        for (Song song : playlist.getSongs()) {
            builder.convertSong(song);
        }

    }
}
