package factory;

import comparator.CDBuyCountComparator;
import comparator.ItunesBuyCountComparator;
import comparator.SongChainedComparator;
import model.Playlist;
import model.Song;
import gui.PlaylistScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnglishPlaylistAlgoritme implements Algoritme
{
    private Playlist playlist;
    private PlaylistScreen playlistScreen;

    public void calculate(Playlist playlist)
    {
        List<Song> songsInList = playlist.getSongs();

        for (Song song : songsInList)
        {
            System.out.println(song.getArtist() + " " +song.getCdBuyCount() + " " + song.getItunesBuyCount());
        }

        Collections.sort(songsInList, new SongChainedComparator(
                new CDBuyCountComparator(),
                new ItunesBuyCountComparator()
        ));

        Collections.reverse(songsInList);

        for (Song song : songsInList)
        {
            System.out.println(song.getArtist() + " " + song.getCdBuyCount() + " " + song.getItunesBuyCount());
        }
    }
}