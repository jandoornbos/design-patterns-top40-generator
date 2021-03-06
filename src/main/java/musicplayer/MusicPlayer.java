package musicplayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import model.Song;

import java.net.URL;
import java.net.URLConnection;

public class MusicPlayer
{

    private static MusicPlayer sharedInstance = new MusicPlayer();

    private Player player = null;
    private Thread playerThread = null;
    private Song currentSong = null;

    public static MusicPlayer getInstance()
    {
        return sharedInstance;
    }

    /**
     * Constructor
     */
    private MusicPlayer()
    {
    }

    /**
     * Play a song.
     *
     * @param song The song to play.
     */
    public void playSong(final Song song)
    {
        // If the player is already playing, stop it
        if (playerThread != null)
        {
            playerThread.interrupt();
            playerThread = null;
            player.close();
            player = null;
        }

        this.currentSong = song;

        // Make a new thread, so the UI doesn't block
        Runnable r = new Runnable()
        {
            public void run()
            {
                startPlayer(song);
            }
        };

        playerThread = new Thread(r);
        playerThread.start();

    }

    /**
     * Play the actual song in our audio player.
     *
     * @param song The song to play.
     */
    private void startPlayer(Song song)
    {
        Boolean playSong = false;
        try
        {
            // Try opening our song from the internet
            URLConnection urlConnection = new URL(song.getFile()).openConnection();
            urlConnection.connect();

            // Start playing
            player = new Player(urlConnection.getInputStream());
            playSong = true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            playSong = false;
        }

        // Only continue if the URL is playable
        if (playSong)
        {
            try
            {
                player.play();
            }
            catch (JavaLayerException e)
            {
                System.out.println(e.getMessage());
            }

        }
    }

    /**
     * Stop playing music.
     */
    public void stopPlaying()
    {
        if (player != null)
        {
            player.close();
        }
    }

    /**
     * Get the current song.
     *
     * @return song The song that is currently playing.
     */
    public Song getCurrentSong()
    {
        return this.currentSong;
    }

}
