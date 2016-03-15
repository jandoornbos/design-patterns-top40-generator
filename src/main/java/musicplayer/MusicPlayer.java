package musicplayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.net.URL;
import java.net.URLConnection;

public class MusicPlayer {

    private static MusicPlayer sharedInstance = new MusicPlayer();

    private Player player = null;

    public static MusicPlayer getInstance()
    {
        return sharedInstance;
    }

    private MusicPlayer()
    {
    }

    public void playSong()
    {

        try
        {
            URLConnection urlConnection = new URL("http://doornbosagrait.tk/top40-generator/Testje.mp3").openConnection();
            urlConnection.connect();

            player = new Player(urlConnection.getInputStream());

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            player.play();
        }
        catch (JavaLayerException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void pause()
    {
        player.close();
    }

}
