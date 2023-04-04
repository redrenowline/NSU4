package ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class PlayerShowcase extends JPanel {

    private JLabel name;
    private JList<String> list;
    private Font font;
    public PlayerShowcase(){

        setBackground(Color.black);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        font = new Font("TimesRoman", Font.CENTER_BASELINE, 16);

        list = new JList<>();
        list.setFont(font);
        list.setBackground(Color.black);
        list.setForeground(Color.white);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        this.add(list);
        list.repaint();

        this.setVisible(true);
    }

    public void update(List<String> ls){
        DefaultListModel<String> listModel = new DefaultListModel();
        for(int i = 0;i < ls.size(); i++){
            listModel.addElement(ls.get(i));
        }
        list.setModel(listModel);
    }
}
