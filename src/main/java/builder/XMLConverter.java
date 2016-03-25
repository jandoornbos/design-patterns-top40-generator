package builder;

import model.Song;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.io.*;

public class XMLConverter implements Converter
{
    public static final String FILE_NAME = "songs.xml";

    public XMLConverter()
    {

    }

    public String getOutput()
    {
        return null;
    }

    public void convertToXML(Song songs)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Song.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(songs, new File(FILE_NAME));
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
