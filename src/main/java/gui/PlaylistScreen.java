package gui;

import javax.swing.*;

public class PlaylistScreen extends JFrame {

    private JPanel rootPanel;
    private JList songList;
    private JButton addSongButton;

    public PlaylistScreen() {

        setContentPane(rootPanel);
        setTitle("Playlist");

        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

        addDummySongs();
    }

    public void addDummySongs() {

        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Song 1");
        listModel.addElement("Song 2");
        songList.setModel(listModel);

    }

}
