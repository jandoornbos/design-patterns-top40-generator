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

    public AddSongScreen(AddSongInterface notifier) {

        addSongInterface = notifier;

        setContentPane(rootPanel);
        setTitle("Add Song");

        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

        addButtonActions();

    }

    public void addButtonActions() {

        saveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String songTitle = titleTextField.getText();
                String songArtist = artistTextField.getText();
                String songAlbum = albumTextField.getText();
                String songFileUrl = fileUrlTextField.getText();

                Song song = new Song(songFileUrl, songTitle, songArtist, songAlbum);
                addSongInterface.songAdded(song);
                setVisible(false);
                dispose();
            }

        });

    }

}
