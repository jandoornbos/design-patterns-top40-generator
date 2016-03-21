package gui;

import javax.swing.*;

public class StartScreen extends JFrame {

    private JPanel rootPanel;
    private JButton dutchButton;
    private JButton englishButton;

    public StartScreen() {
        super("StartScreen");

        setContentPane(rootPanel);
        setTitle("Top 40 Generator");

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
