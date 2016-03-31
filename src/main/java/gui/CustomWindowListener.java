package gui;

import musicplayer.MusicPlayer;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CustomWindowListener implements WindowListener
{

    public void windowOpened(WindowEvent e)
    {
    }

    public void windowClosing(WindowEvent e)
    {
        // Stop music player when closing window
        MusicPlayer.getInstance().stopPlaying();
    }

    public void windowClosed(WindowEvent e)
    {
    }

    public void windowIconified(WindowEvent e)
    {
    }

    public void windowDeiconified(WindowEvent e)
    {
    }

    public void windowActivated(WindowEvent e)
    {
    }

    public void windowDeactivated(WindowEvent e)
    {
    }
}
