package gui;

import model.Playlist;
import model.Song;
import builder.JSONConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlaylistScreen extends JFrame implements AddSongInterface {

    private JPanel rootPanel;
    private JList songList;
    private JButton addSongButton;
    private JButton jsonExportButton;
    private JButton xmlExportButton;
    private JLabel titleLabel;

    private DefaultListModel listModel;
    private Playlist currentPlaylist;

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

    /**
     * Add actions to the buttons.
     */
    private void addButtonActions()
    {

        final PlaylistScreen me = this;
        addSongButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                AddSongScreen addSongScreen = new AddSongScreen(me);
            }

        });

        jsonExportButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<Song> getCurrentSongs = currentPlaylist.getSongs();
                JSONConverter converter = new JSONConverter();
                converter.convertToJSON(getCurrentSongs);
            }
        });

    }

    /**
     * Fill the JList with the songs that are already in the playlist.
     */
    private void fillListWithPlaylist()
    {
        // If current playlist is set
        if (this.currentPlaylist.getSongs().size() > 0)
        {
            // Loop through the songs
            for (Song song : this.currentPlaylist.getSongs())
            {
                String songString = song.getTitle() + " - " + song.getArtist();
                listModel.addElement(songString);
            }
        }
    }

    /**
     * Is called from the AddSongScreen.
     *
     * @param song The song to be added.
     */
    public void songAdded(Song song)
    {
        String songString = song.getTitle() + " - " + song.getArtist();
        listModel.addElement(songString);
    }

    /**
     * Set the current playlist for this screen.
     * @param currentPlaylist
     */
    public void setCurrentPlaylist(Playlist currentPlaylist)
    {
        this.currentPlaylist = currentPlaylist;
        titleLabel.setText(this.currentPlaylist.getTitle());
        fillListWithPlaylist();
    }
}
