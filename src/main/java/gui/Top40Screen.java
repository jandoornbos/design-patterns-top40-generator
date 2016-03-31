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

    private void addButtonActions()
    {
        this.closeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                dispose();
            }

        });
    }

    private void setupTable()
    {
        String[] columns = new String[] {
            "Number", "Artist", "Title", "Stream Count", "CD Count", "iTunes Count"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (int i = 1; i <= this.top40List.size(); i++)
        {
            Song song = this.top40List.get(i-1);
            Object[] data = { i, song.getArtist(), song.getTitle(), song.getStreamCount(), song.getCdBuyCount(),
            song.getItunesBuyCount() };

            tableModel.addRow(data);
        }

        table.setModel(tableModel);
    }

}
