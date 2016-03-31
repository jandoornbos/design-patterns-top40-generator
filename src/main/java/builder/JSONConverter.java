package builder;

import model.Song;

public class JSONConverter extends PlaylistConverter {

    private ConverterProduct product;

    public JSONConverter()
    {
        this.product = new ConverterProduct();
    }

    @Override
    public void convertSong(Song song)
    {
        String fileURL = "\"fileURL\"";
        String title = "\"title\"";
        String artist = "\"artist\"";
        String album = "\"album\"";

        this.product.appendString("[{ " + fileURL + ":\"" +
        song.getFile() + "\"," + title + ":\"" +
        song.getTitle() + "\"," + artist + ":\"" +
        song.getArtist() + "\"," + album + ":\"" +
        song.getAlbum() + "\" }]");
    }

    public ConverterProduct getResult() {
        return this.product;
    }

}
