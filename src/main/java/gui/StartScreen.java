package gui;

import musicplayer.MusicPlayer;

import javax.swing.*;

public class StartScreen extends JFrame {

    private JPanel rootPanel;

    public StartScreen() {
        super("StartScreen");

        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        MusicPlayer.getInstance().playSong();

    }
}
