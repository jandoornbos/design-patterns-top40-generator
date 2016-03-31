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

    public List<Song> calculate(Playlist playlist)
    {
        List<Song> songsInList = playlist.getSongs();

        Collections.sort(songsInList, new SongChainedComparator(
                new CDBuyCountComparator(),
                new ItunesBuyCountComparator()
        ));

        Collections.reverse(songsInList);

        return songsInList;

    }

}