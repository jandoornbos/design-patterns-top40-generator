package comparator;

import model.Song;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SongChainedComparator implements Comparator<Song>
{
    private List<Comparator<Song>> listComparators;

    public SongChainedComparator(Comparator<Song>... comparators)
    {
        this.listComparators = Arrays.asList(comparators);
    }

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