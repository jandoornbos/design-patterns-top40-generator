package factory;

import model.Playlist;
import model.Song;

import java.util.List;

public interface Algoritme
{
    List<Song> calculate(Playlist playlist);
}