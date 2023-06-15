package ru.nsu.ccfit.Prokhorov.chat.gui;

import ru.nsu.ccfit.Prokhorov.chat.UIResourcesConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindow extends JFrame {

    private final JPanel panel;
    private final JTextArea area;
    private final JTextField enterField;
    private final JButton sendButton;
    private final JLabel nameLabel;
    private Locale locale;
    private ResourceBundle resourceBundle;

    private final Rectangle frameSize = new Rectangle(100,100,500,650);
    private final Rectangle textAreaSize = new Rectangle(0,0,480, 545);
    private final Rectangle enterFieldSize = new Rectangle(5,550,425, 25);
    private final Rectangle sendButtonSize = new Rectangle(435,550,40,25);
    private final Rectangle nameLabelSize = new Rectangle(5, 575,200, 20);

    public MainWindow(Locale locale, String name){
        this.setBounds(frameSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.locale = locale;
        this.resourceBundle = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);

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

        nameLabel = new JLabel();
        nameLabel.setBounds(nameLabelSize);
        nameLabel.setText(String.format(resourceBundle.getString(UIResourcesConstants.CLIENT_NAME_LABEL), name));

        panel.add(textPanel);
        panel.add(enterField);
        panel.add(sendButton);
        panel.add(nameLabel);

        this.setContentPane(panel);
        this.setVisible(true);
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
