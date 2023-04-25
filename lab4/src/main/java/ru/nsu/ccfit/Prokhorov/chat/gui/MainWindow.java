package ru.nsu.ccfit.Prokhorov.chat.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

    public JPanel panel;
    public JTextArea area;
    public JTextField enterField;
    public JButton sendButton;
    public MainWindow(){
        this.setLocation(100,100);
        this.setSize(600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2,1,10,5));

        area = new JTextArea();
        area.setEditable(false);
        area.setMinimumSize(new Dimension(100,500));
        area.setMaximumSize(new Dimension(100,500));

        panel.add(area);

        getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        setThisWindowMoveable();
        this.setContentPane(panel);
        this.setVisible(true);
    }

    private void setThisWindowMoveable(){
        MouseAdapter m = new MouseAdapter() {
            int y;
            int x;

            public void mousePressed(MouseEvent e) {
                // запоминаем координаты клика
                x = e.getX();
                y = e.getY();
            }

            public void mouseDragged(MouseEvent e) {
                // двигаем окно
                setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        };
        this.addMouseMotionListener(m);
        this.addMouseListener(m);
    }
    public String getText(){
        return "";
    }
    public void addText(String text){
        area.append(text);
    }
}
