package builder;

import model.Song;

public class JSONConverter extends PlaylistConverter {

    private ConverterProduct product;

    @Override
    void convertSong(Song song) {

        this.product.appendString("Hihi liedje" + song.getTitle());

    }

    public ConverterProduct getResult() {
        return this.product;
    }

}
