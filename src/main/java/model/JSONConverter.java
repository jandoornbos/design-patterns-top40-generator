package model;

import java.util.ArrayList;

/**
 * Created by Ferdi on 15-3-2016.
 */
public class JSONConverter implements Converter {


    public JSONConverter()
    {

    }

    public String getOutput()
    {
        return null;
    }

    public Song readPlaylist()
    {
        Playlist list = new Playlist();
        ArrayList<Song> showList = list.getSongs();
        Song items = null;

        for (Song item : showList)
        {
            items = item;
        }

        return items;
    }
}
