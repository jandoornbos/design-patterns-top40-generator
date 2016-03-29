package builder;

import com.google.gson.Gson;
import model.Song;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONConverter implements Converter
{
    public JSONConverter()
    {

    }

    public void buildConverter(ArrayList<Song> songs)
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