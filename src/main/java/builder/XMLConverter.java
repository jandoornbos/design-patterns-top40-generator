package builder;

import model.Song;

public class XMLConverter extends PlaylistConverter
{

    private ConverterProduct product;

    public XMLConverter()
    {
        this.product = new ConverterProduct();
        this.product.appendString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><songs>");
    }

    @Override
    public void convertSong(Song song)
    {

        this.product.appendString("<song>" +
                "<title>" + song.getTitle() + "</title>" +
                "<artist>" + song.getArtist() + "</artist>" +
                "<album>" + song.getAlbum() + "</album>" +
                "<url>" + song.getFile() + "</url>" +
                "</song>");

    }

    @Override
    public ConverterProduct getResult()
    {
        this.product.appendString("</songs>");
        return this.product;
    }
}
