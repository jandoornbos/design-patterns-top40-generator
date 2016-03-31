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
    /**
     * Calculate the top 40 for the Netherlands.
     *
     * @param playlist The playlist to calculate the top 40 for.
     * @return A list with the top 40.
     */
    public List<Song> calculate(Playlist playlist)
    {
        // Convert our ArrayList to a ordered List
        List<Song> songsInList = playlist.getSongs();

        // Sort the songs
        Collections.sort(songsInList, new SongChainedComparator(
                new StreamCountComparator(),
                new ItunesBuyCountComparator()
        ));

        // Turn it upside down
        Collections.reverse(songsInList);

        return songsInList;
    }
}