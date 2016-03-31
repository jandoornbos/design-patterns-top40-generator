package gui;

import model.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Top40Screen extends JFrame {

    private JPanel rootPanel;
    private JButton closeButton;
    private JTable table;

    private List<Song> top40List;

    /**
     * Create a Top 40 screen that shows the top 40 list.
     *
     * @param list The list to display.
     */
    public Top40Screen(List<Song> list)
    {
        super("Top 40 Screen");

        setContentPane(rootPanel);
        setTitle("Top 40 Generator");

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        top40List = list;

        addButtonActions();
        setupTable();
    }

    /**
     * Add some actions to the buttons.
     */
    private void addButtonActions()
    {
        this.closeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                // Hide the window and dispose it
                setVisible(false);
                dispose();
            }

        });
    }

    /**
     * Setup our Top 40 table.
     */
    private void setupTable()
    {
        // Make the columns
        String[] columns = new String[] {
            "Number", "Artist", "Title", "Stream Count", "CD Count", "iTunes Count"
        };

        // Make some table model
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        // Loop through the songs and add them to the table
        for (int i = 1; i <= this.top40List.size(); i++)
        {
            Song song = this.top40List.get(i-1);
            Object[] data = { i, song.getArtist(), song.getTitle(), song.getStreamCount(), song.getCdBuyCount(),
            song.getItunesBuyCount() };

            tableModel.addRow(data);
        }

        // Fill our table with our model
        table.setModel(tableModel);
    }

}
