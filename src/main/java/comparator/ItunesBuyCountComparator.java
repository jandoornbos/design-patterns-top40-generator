package comparator;

import model.Song;

import java.util.Comparator;

/**
 * Created by ferdi on 31-3-2016.
 */
public class ItunesBuyCountComparator implements Comparator<Song>
{
    public int compare(Song song1, Song song2)
    {
        return song1.getItunesBuyCount() < song2.getItunesBuyCount() ? -1 : song1.getItunesBuyCount() == song2.getItunesBuyCount() ? 0 : 1;
    }
}
