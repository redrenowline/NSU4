package ru.nsu.ccfit.Prokhorov.chat.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

    private Dimension windowDims = new Dimension(500,600);

    private JPanel panel;
    private JTextArea area;
    private JTextField enterField;
    private JButton sendButton;
    private JScrollBar bar;
    public MainWindow(){
        this.setLocation(100,100);
        this.setSize(windowDims);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);

        panel = new JPanel();
        panel.setLayout(null);

        area = new JTextArea();
        area.setEditable(false);
        final JScrollPane textPanel = new JScrollPane(area);
        textPanel.setBounds(5,5,470, 540);

        enterField = new JTextField();
        enterField.setBounds(5,550,455, 25 );

        sendButton = new JButton("Send");
        sendButton.setBounds(455,550,45,25);

        panel.add(textPanel);
        panel.add(enterField);
        panel.add(sendButton);

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
        return enterField.getText();
    }
    public void addText(String text){
        area.append(text);
    }
    public JButton getSendButton(){
        return sendButton;
    }

    public void addNewMessage(String strl){
        area.append(strl + "\n");
    }
    public JTextField getEnterField(){
        return enterField;
    }
}
