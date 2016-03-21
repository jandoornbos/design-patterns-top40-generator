package gui;

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

    public void setupButtons() {

        englishListButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                PlaylistScreen playlistScreen = new PlaylistScreen();
                playlistScreen.setLocationRelativeTo(rootPanel);
                playlistScreen.setVisible(true);
            }

        });

    }
}
