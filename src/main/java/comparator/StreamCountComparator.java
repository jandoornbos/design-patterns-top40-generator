package comparator;

import model.Song;

import java.util.Comparator;

/**
 * Created by ferdi on 31-3-2016.
 */
public class StreamCountComparator implements Comparator<Song>
{
    public int compare(Song song1, Song song2)
    {
        return song1.getStreamCount() < song2.getStreamCount() ? -1 : song1.getStreamCount() == song2.getStreamCount() ? 0 : 1;
    }
}
