package gui;

import javax.swing.*;

import model.JSONConverter;
import model.Song;

public class StartScreen extends JFrame {

    private JPanel rootPanel;
    private JLabel label1;

    public StartScreen() {
        super("StartScreen");

        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JSONConverter converter = new JSONConverter();
        label1.setText("" + converter.readPlaylist());
    }
}
