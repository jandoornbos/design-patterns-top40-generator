package factory;

import comparator.ItunesBuyCountComparator;
import comparator.SongChainedComparator;
import comparator.StreamCountComparator;
import model.Playlist;
import model.Song;

import java.util.Collections;
import java.util.List;

public class DutchPlaylistAlgoritme implements Algoritme
{
    public List<Song> calculate(Playlist playlist)
    {
        List<Song> songsInList = playlist.getSongs();

        Collections.sort(songsInList, new SongChainedComparator(
                new StreamCountComparator(),
                new ItunesBuyCountComparator()
        ));

        Collections.reverse(songsInList);

        return songsInList;
    }
}