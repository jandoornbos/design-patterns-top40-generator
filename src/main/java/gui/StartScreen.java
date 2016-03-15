package gui;

import javax.swing.*;

public class StartScreen extends JFrame {

    private JPanel rootPanel;

    public StartScreen() {
        super("StartScreen");

        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
