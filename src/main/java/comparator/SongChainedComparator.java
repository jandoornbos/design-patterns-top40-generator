package comparator;

import model.Song;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SongChainedComparator implements Comparator<Song>
{
    private List<Comparator<Song>> listComparators;

    /**
     * Make a chained comparator for the songs.
     *
     * @param comparators The comparators to use.
     */
    public SongChainedComparator(Comparator<Song>... comparators)
    {
        this.listComparators = Arrays.asList(comparators);
    }

    /**
     * Compare the songs with all the comparators available.
     *
     * @param song1 The first song.
     * @param song2 The second song.
     * @return The compare value.
     */
    public int compare(Song song1, Song song2)
    {
        for (Comparator<Song> comparator : listComparators)
        {
            int result = comparator.compare(song1, song2);
            if (result != 0)
            {
                return result;
            }
        }
        return 0;
    }
}