package gui;

import datamodel.DataModel;
import model.Playlist;
import observer.EmailObserver;
import observer.WebserviceObserver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame {

    private JPanel rootPanel;
    private JButton englishListButton;
    private JButton dutchListButton;

    /**
     * The start screen of the App.
     */
    public StartScreen() {
        super("StartScreen");

        setContentPane(rootPanel);
        setTitle("Top 40 Generator");

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setupButtons();
    }

    /**
     * Add some actions to the buttons.
     */
    private void setupButtons() {

        englishListButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Playlist enPlaylist = DataModel.getInstance().getEnglishPlaylist();

                // Add observers to playlist
                WebserviceObserver wObserver = new WebserviceObserver();
                enPlaylist.registerObserver(wObserver);

                EmailObserver eObserver = new EmailObserver();
                enPlaylist.registerObserver(eObserver);

                openPlaylistScreen(enPlaylist);
            }

        });

        dutchListButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Playlist nlPlaylist = DataModel.getInstance().getDutchPlaylist();

                // Add observers to the playlist
                WebserviceObserver wObserver = new WebserviceObserver();
                nlPlaylist.registerObserver(wObserver);

                EmailObserver eObserver = new EmailObserver();
                nlPlaylist.registerObserver(eObserver);

                openPlaylistScreen(nlPlaylist);
            }

        });

    }

    /**
     * Opens a playlist screen.
     *
     * @param playlist The playlist to open in this new screen.
     */
    private void openPlaylistScreen(Playlist playlist) {
        PlaylistScreen playlistScreen = new PlaylistScreen();
        playlistScreen.setCurrentPlaylist(playlist);
        playlistScreen.setLocationRelativeTo(rootPanel);
    }

}
