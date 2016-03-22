package gui;

import datamodel.DataModel;
import javafx.scene.chart.PieChart;
import model.Playlist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame {

    private JPanel rootPanel;
    private JButton englishListButton;
    private JButton dutchListButton;

    public StartScreen() {
        super("StartScreen");

        setContentPane(rootPanel);
        setTitle("Top 40 Generator");

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setupButtons();
    }

    private void setupButtons() {

        englishListButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                openPlaylistScreen(DataModel.getInstance().getEnglishPlaylist());
            }

        });

        dutchListButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                openPlaylistScreen(DataModel.getInstance().getDutchPlaylist());
            }

        });

    }

    private void openPlaylistScreen(Playlist playlist) {
        PlaylistScreen playlistScreen = new PlaylistScreen();
        playlistScreen.setCurrentPlaylist(playlist);
        playlistScreen.setLocationRelativeTo(rootPanel);
    }

}
