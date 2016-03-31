package gui;


import builder.ConverterProduct;
import builder.JSONConverter;

import factory.Algoritme;
import factory.AlgoritmeFactory;
import factory.EnglishPlaylistAlgoritme;
import builder.XMLConverter;
import model.Playlist;
import model.Song;
import musicplayer.MusicPlayer;
import builder.Converter;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PlaylistScreen extends JFrame implements AddSongInterface {

    private JPanel rootPanel;
    private JList songList;
    private JButton addSongButton;
    private JButton jsonExportButton;
    private JButton xmlExportButton;
    private JLabel titleLabel;
    private JButton notifyUsersButton;
    private JButton generateTop40Button;

    private DefaultListModel listModel;
    private Playlist currentPlaylist;

    public PlaylistScreen() {

        setContentPane(rootPanel);
        setTitle("Playlist");

        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

        addButtonActions();
        addListActions();

        listModel = new DefaultListModel();
        songList.setModel(listModel);

        addWindowListener(new CustomWindowListener());
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
                convertJSON();
            }
        });

        xmlExportButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                convertXML();
            }
        });

        // When user clicks the Notify button
        notifyUsersButton.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                // Notify our observers
                if (currentPlaylist != null) {
                    currentPlaylist.notifyObservers();
                }
            }

        });

        generateTop40Button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                generateTop40();
            }

        });

    }

    /**
     * Add list actions.
     */
    private void addListActions()
    {

        // When user clicks a item in the list
        songList.addMouseListener(new MouseAdapter()
        {

            public void mouseClicked(MouseEvent e)
            {
                JList list = (JList) e.getSource();
                // If item is doubled clicked
                if (e.getClickCount() == 2)
                {
                    int index = list.locationToIndex(e.getPoint());
                    Song song = currentPlaylist.getSongs().get(index);
                    // Play the song
                    MusicPlayer.getInstance().playSong(song);
                }
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
        this.currentPlaylist.addSong(song);
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

    public Playlist getCurrentPlaylist()
    {
        return this.currentPlaylist;
    }

    private void convertJSON() {
        JSONConverter converterBuilder = new JSONConverter();
        Converter jsonReader = new Converter(converterBuilder);
        jsonReader.parsePlaylist(currentPlaylist);
        ConverterProduct converterProduct = converterBuilder.getResult();
        saveFileWithExtension("application/json", "json", converterProduct.getOutput());
    }

    private void convertXML() {
        XMLConverter converterBuilder = new XMLConverter();
        Converter xmlReader = new Converter(converterBuilder);
        xmlReader.parsePlaylist(currentPlaylist);
        ConverterProduct converterProduct = converterBuilder.getResult();
        saveFileWithExtension("application/xml", "xml", converterProduct.getOutput());
    }

    private void saveFileWithExtension(String extensionDescription, String extension, String content) {

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(extensionDescription, extension);
        fileChooser.setSelectedFile(new File("playlist." + extension));
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {

            String path = fileChooser.getSelectedFile().getPath();
            try
            {
                PrintWriter printWriter = new PrintWriter(path, "UTF-8");
                printWriter.write(content);
                printWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void generateTop40() {

        String algorithmToChoose;
        if (this.currentPlaylist.getTitle() == "Dutch")
        {
            algorithmToChoose = "DutchPlaylistAlgoritme";
        }
        else
        {
            algorithmToChoose = "EnglishPlaylistAlgoritme";
        }

        AlgoritmeFactory factory = new AlgoritmeFactory();
        Algoritme algorithm = factory.getAlgoritme(algorithmToChoose);

        List<Song> top40 = algorithm.calculate(this.currentPlaylist);
        Top40Screen screen = new Top40Screen(top40);

    }

}
