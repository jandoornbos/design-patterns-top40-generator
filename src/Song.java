import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioSystem.*;

/**
 * Created by Ferdi on 15-3-2016.
 */
public class Song {
    private File file;
    private String title;
    private String artist;
    private String album;


    /**
     * Constructor for adding a song
     * @param file File of the song
     * @param title Title of the song
     * @param artist Artist of the song
     * @param album Album of the song
     */
    public Song(File file, String title, String artist, String album)
    {
        this.file = file;
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public int getDurationInSeconds()
    {
        File durationSong = new File(file);
        AudioFileFormat baseFileFormat = new AudioSystem.getAudioFileFormat(file);
    }
}
