package gui;

import model.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaylistScreen extends JFrame implements AddSongInterface {

    private JPanel rootPanel;
    private JList songList;
    private JButton addSongButton;

    private DefaultListModel listModel;

    public PlaylistScreen() {

        setContentPane(rootPanel);
        setTitle("Playlist");

        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

        addButtonActions();

        listModel = new DefaultListModel();
        songList.setModel(listModel);
    }

    public void addButtonActions() {

        final PlaylistScreen me = this;
        addSongButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                AddSongScreen addSongScreen = new AddSongScreen(me);
            }

        });

    }

    public void songAdded(Song song) {
        String songString = song.getTitle() + " - " + song.getArtist();
        listModel.addElement(songString);
    }
}
