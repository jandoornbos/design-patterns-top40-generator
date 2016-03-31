package builder;

import model.Song;

public abstract class PlaylistConverter {

    public abstract void convertSong(Song song);
    public abstract ConverterProduct getResult();

}
