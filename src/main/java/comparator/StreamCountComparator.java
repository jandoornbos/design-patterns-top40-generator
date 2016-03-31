package comparator;

import model.Song;

import java.util.Comparator;

/**
 * Created by ferdi on 31-3-2016.
 */
public class StreamCountComparator implements Comparator<Song>
{
    /**
     * Compare the songs depending on the stream count.
     *
     * @param song1 The first song.
     * @param song2 The second song.
     * @return The compare value.
     */
    public int compare(Song song1, Song song2)
    {
        return song1.getStreamCount() < song2.getStreamCount() ? -1 : song1.getStreamCount() == song2.getStreamCount() ? 0 : 1;
    }
}
