package ru.nsu.ccfit.Prokhorov.chat.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

    private final JPanel panel;
    private final JTextArea area;
    private final JTextField enterField;
    private final JButton sendButton;
    private JScrollBar bar;

    private final Rectangle frameSize = new Rectangle(100,100,500,650);
    private final Rectangle textAreaSize = new Rectangle(5,5,470, 545);
    private final Rectangle enterFieldSize = new Rectangle(5,550,425, 25);
    private final Rectangle sendButtonSize = new Rectangle(435,550,35,25);

    public MainWindow(){
        this.setBounds(frameSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);

        area = new JTextArea();
        area.setEditable(false);
        final JScrollPane textPanel = new JScrollPane(area);
        textPanel.setBounds(textAreaSize);

        enterField = new JTextField();
        enterField.setBounds(enterFieldSize);

        sendButton = new JButton();
        sendButton.setBounds(sendButtonSize);

        panel.add(textPanel);
        panel.add(enterField);
        panel.add(sendButton);

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public JTextField getTextField(){
        return enterField;
    }
    public String getText(){
        return enterField.getText();
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
