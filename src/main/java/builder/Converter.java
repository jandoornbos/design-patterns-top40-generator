package builder;

import model.Song;
import java.util.ArrayList;

public interface Converter
{
    public void buildConverter(ArrayList<Song> songs);
}