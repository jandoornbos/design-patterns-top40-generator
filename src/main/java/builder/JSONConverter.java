package builder;

import model.Playlist;
import model.Song;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

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

    public void convertToJSON(ArrayList<Song> songs)
    {
        Gson gson = new Gson();

        String json = gson.toJson(songs);

        try
        {
            FileWriter writer = new FileWriter("C://Users/ferdi/Documents/file.json");
            writer.write(json);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
