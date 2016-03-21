package gui;

import javax.swing.*;

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

    }
}
