package builder;

import model.Song;

import javax.xml.bind.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by ferdi on 29-3-2016.
 */
public class XMLConverter implements Converter
{
    private static String FILE_NAME = "C://Users/ferdi/Documents/songs.xml";

    public XMLConverter()
    {

    }

    public void buildConverter(ArrayList<Song> songs)
    {
        Song songItems = null;

        for (Song song : songs)
        {
            try
            {
                JAXBContext context = JAXBContext.newInstance(Song.class);

                Marshaller m = context.createMarshaller();

                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                m.marshal(song, new File(FILE_NAME));
            }
            catch (JAXBException e)
            {
                e.printStackTrace();
            }
        }


    }
}
