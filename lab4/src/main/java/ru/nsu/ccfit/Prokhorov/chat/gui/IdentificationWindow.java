package ru.nsu.ccfit.Prokhorov.chat.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.Key;

public class IdentificationWindow extends JFrame {

    private JPanel panel;
    private JLabel lblHostname;
    private JTextField hostnameField;
    private JLabel lblPort;
    private JTextField portField;
    private JTextField filePath;
    private JButton btnFilePath;
    private JButton btnLogin;
    public IdentificationWindow(){
        this.setLocation(100,100);
        this.setSize(200,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);

        lblHostname = new JLabel("Enter ip address");
        lblHostname.setHorizontalTextPosition(SwingConstants.CENTER);
        hostnameField = new JTextField();
        lblPort = new JLabel("Enter port");
        lblPort.setHorizontalTextPosition(SwingConstants.CENTER);
        portField = new JTextField();
        filePath = new JTextField();
        btnFilePath = new JButton( "Upload user file");
        btnLogin = new JButton( "Login");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5,1,10,5));
        panel.add(lblHostname);
        panel.add(hostnameField);
        panel.add(lblPort);
        panel.add(portField);
//        panel.add(filePath);
//        panel.add(btnFilePath);
        panel.add(btnLogin);

        getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        setThisWindowMoveable();
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public void setThisWindowMoveable(){
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

    public JButton getBtnLogin(){
        return btnLogin;
    }
    public String getHostname(){
        return hostnameField.getText();
    }
    public int getPort(){
        return Integer.parseInt(portField.getText());
    }

    public String getFilePath(){
        return "";
    }
}



