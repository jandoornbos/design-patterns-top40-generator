package builder;

import model.Song;

public class XMLConverter extends PlaylistConverter
{

    private ConverterProduct product;

    /**
     * Constructor.
     */
    public XMLConverter()
    {
        this.product = new ConverterProduct();
        // Start the output with XML things
        this.product.appendString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><songs>");
    }

    /**
     * Convert the song into MXL.
     *
     * @param song The song to convert.
     */
    @Override
    public void convertSong(Song song)
    {
        // Make some XML for this song
        this.product.appendString("<song>" +
                "<title>" + song.getTitle() + "</title>" +
                "<artist>" + song.getArtist() + "</artist>" +
                "<album>" + song.getAlbum() + "</album>" +
                "<url>" + song.getFile() + "</url>" +
                "</song>");

    }

    /**
     * Get the actual output.
     *
     * @return The ouput.
     */
    @Override
    public ConverterProduct getResult()
    {
        // Close the XML first
        this.product.appendString("</songs>");
        return this.product;
    }
}
