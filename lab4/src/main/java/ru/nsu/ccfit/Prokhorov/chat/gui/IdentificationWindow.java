package ru.nsu.ccfit.Prokhorov.chat.gui;

import ru.nsu.ccfit.Prokhorov.chat.UIResourcesConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.Key;
import java.util.Locale;
import java.util.ResourceBundle;

public class IdentificationWindow extends JFrame {

    private final JPanel panel;
    private final JLabel lblHostname;
    private final JTextField hostnameField;
    private final JLabel lblPort;
    private final JTextField portField;
    private final JLabel nicknameLabel;
    private final JTextField nicknameField;
    private final JButton btnLogin;

    private Locale locale;
    private ResourceBundle resourceBundle;


    private final Rectangle frameSize = new Rectangle(100,100,200,250);
    public IdentificationWindow(Locale locale){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);
        this.setBounds(frameSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblHostname = new JLabel(resourceBundle.getString(UIResourcesConstants.IP_LABEL));
        lblHostname.setHorizontalTextPosition(SwingConstants.CENTER);
        hostnameField = new JTextField();
        lblPort = new JLabel(resourceBundle.getString(UIResourcesConstants.PORT_NAME));
        lblPort.setHorizontalTextPosition(SwingConstants.CENTER);
        portField = new JTextField();
        btnLogin = new JButton( resourceBundle.getString(UIResourcesConstants.LOGIN_BTN));
        nicknameLabel = new JLabel(resourceBundle.getString(UIResourcesConstants.NICKNAME_LABEL));
        nicknameField = new JTextField();

        panel = new JPanel();
        panel.setLayout(new GridLayout(7,1,10,5));
        panel.add(lblHostname);
        panel.add(hostnameField);
        panel.add(lblPort);
        panel.add(portField);
        panel.add(nicknameLabel);
        panel.add(nicknameField);
        panel.add(btnLogin);

        getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public JButton getBtnLogin(){
        return btnLogin;
    }
    public String getHostname(){
        return hostnameField.getText();
    }
    public String getNickname(){
        return nicknameField.getText();
    }
    public int getPort(){
        return Integer.parseInt(portField.getText());
    }


}



