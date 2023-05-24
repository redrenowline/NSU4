package ru.nsu.ccfit.Prokhorov.server.gui;

import ru.nsu.ccfit.Prokhorov.server.UIResourcesConstants;
import ru.nsu.ccfit.Prokhorov.server.core.MessagePool;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.ResourceBundle;

public class RunningGUI extends JFrame {

    private JPanel panel;
    private JLabel ipLabel;
    private JTextField ipField;
    private JLabel portLabel;
    private JTextField portField;

    private MessagePool msgPool;
    private int port;

    private Locale locale;
    private ResourceBundle resourceBundle;

    private final Rectangle frameSize = new Rectangle(100,100,360,100);
    private final Rectangle identIpLabelSize = new Rectangle(10,5,150,20);
    private final Rectangle identIpFieldSize = new Rectangle(155, 5, 180,20);
    private final Rectangle identPortLabelSize = new Rectangle(10,30,150,20);
    private final Rectangle identPortFieldSize = new Rectangle(155, 30, 180,20);

    public RunningGUI(Locale locale, MessagePool msgPool, int port){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);
        this.setBounds(frameSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.msgPool = msgPool;
        this.port = port;

        panel = new JPanel();
        panel.setLayout(null);

        identIpLabel();
        identIpField();
        identPortLabel();
        identPortField();

        this.setContentPane(panel);
        this.setVisible(true);
    }

    private void identIpLabel(){
        ipLabel = new JLabel();
        ipLabel.setText(resourceBundle.getString(UIResourcesConstants.IP_LABEL));
        ipLabel.setBounds(identIpLabelSize);
        panel.add(ipLabel);
    }
    private void identIpField(){
        ipField = new JTextField();
        try {
            ipField.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            ipField.setText(resourceBundle.getString(UIResourcesConstants.IP_FIELD));
        }
        ipField.setBounds(identIpFieldSize);
        ipField.setEditable(false);
        panel.add(ipField);
    }
    private void identPortLabel(){
        portLabel = new JLabel();
        portLabel.setText(resourceBundle.getString(UIResourcesConstants.PORT_LABEL));
        portLabel.setBounds(identPortLabelSize);
        panel.add(portLabel);
    }

    private void identPortField(){
        portField = new JTextField();
        portField.setBounds(identPortFieldSize);
        portField.setText(Integer.toString(port));
        portField.setEditable(false);
        panel.add(portField);
    }

}
