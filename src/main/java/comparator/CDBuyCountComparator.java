package comparator;

import model.Song;

import java.util.Comparator;

/**
 * Created by ferdi on 31-3-2016.
 */
public class CDBuyCountComparator implements Comparator<Song>
{
    public int compare(Song song1, Song song2)
    {
        return song1.getCdBuyCount() < song2.getCdBuyCount() ? -1 : song1.getCdBuyCount() == song2.getCdBuyCount() ? 0 : 1;
    }
}
