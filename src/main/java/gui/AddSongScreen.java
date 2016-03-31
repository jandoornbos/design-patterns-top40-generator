package gui;

import model.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSongScreen extends JFrame {

    private JPanel rootPanel;
    private JTextField titleTextField;
    private JTextField artistTextField;
    private JTextField albumTextField;
    private JTextField fileUrlTextField;
    private JButton saveButton;

    private AddSongInterface addSongInterface;

    /**
     * Add a song to the playlist.
     *
     * @param notifier An interface that called this screen.
     */
    public AddSongScreen(AddSongInterface notifier)
    {
        addSongInterface = notifier;

        setContentPane(rootPanel);
        setTitle("Add Song");

        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

        addButtonActions();
    }

    /**
     * Add some action to the buttons.
     */
    public void addButtonActions()
    {
        saveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Generate a new song
                String songTitle = titleTextField.getText();
                String songArtist = artistTextField.getText();
                String songAlbum = albumTextField.getText();
                String songFileUrl = fileUrlTextField.getText();

                Song song = new Song(songFileUrl, songTitle, songArtist, songAlbum);
                // Call the screen who opened this screen, so it knows a new song is created
                addSongInterface.songAdded(song);
                // Dispose this screen
                setVisible(false);
                dispose();
            }
        });
    }

}
