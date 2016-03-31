package comparator;

import model.Song;

import java.util.Comparator;


public class CDBuyCountComparator implements Comparator<Song>
{
    /**
     * Compare the songs depending on CDBuyCount.
     *
     * @param song1 The first song.
     * @param song2 The second song.
     * @return The compare value.
     */
    public int compare(Song song1, Song song2)
    {
        return song1.getCdBuyCount() < song2.getCdBuyCount() ? -1 : song1.getCdBuyCount() == song2.getCdBuyCount() ? 0 : 1;
    }
}
