package builder;

import model.Song;

public class JSONConverter extends PlaylistConverter {

    private ConverterProduct product;

    /**
     * Constructor.
     */
    public JSONConverter()
    {
        this.product = new ConverterProduct();
    }

    /**
     * Convert the song into JSON.
     *
     * @param song The song to convert.
     */
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

    /**
     * Get the result.
     *
     * @return The JSON result.
     */
    public ConverterProduct getResult() {
        return this.product;
    }

}
