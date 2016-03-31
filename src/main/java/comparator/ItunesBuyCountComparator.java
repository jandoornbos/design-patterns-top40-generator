package comparator;

import model.Song;

import java.util.Comparator;


public class ItunesBuyCountComparator implements Comparator<Song>
{
    /**
     * Compare the songs depending on the iTunes buy count.
     *
     * @param song1 The first song.
     * @param song2 The second song.
     * @return The compare value.
     */
    public int compare(Song song1, Song song2)
    {
        return song1.getItunesBuyCount() < song2.getItunesBuyCount() ? -1 : song1.getItunesBuyCount() == song2.getItunesBuyCount() ? 0 : 1;
    }
}
