package builder;

import model.Song;

import java.util.ArrayList;

/**
 * Created by Ferdi on 15-3-2016.
 */
public interface Converter
{
    public Song readPlaylist();
    public String getOutput();
}
