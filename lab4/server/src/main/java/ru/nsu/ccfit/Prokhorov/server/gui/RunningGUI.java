package ru.nsu.ccfit.Prokhorov.server.gui;

import ru.nsu.ccfit.Prokhorov.server.UIResourcesConstants;
import ru.nsu.ccfit.Prokhorov.server.core.MessagePool;
import ru.nsu.ccfit.Prokhorov.server.net.ThreadInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
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

    private Rectangle frameSize = new Rectangle(100,100,360,100);
    private final Rectangle identIpLabelSize = new Rectangle(10,5,150,20);
    private final Rectangle identIpFieldSize = new Rectangle(155, 5, 180,20);
    private final Rectangle identPortLabelSize = new Rectangle(10,30,150,20);
    private final Rectangle identPortFieldSize = new Rectangle(155, 30, 180,20);
    private final Rectangle threadInfoFrameSize = new Rectangle(0,55,360,60);
    private final Rectangle threadsNameLabelSize = new Rectangle(10,5,160,20);
    private final Rectangle threadsNameFieldSize = new Rectangle(175,5,200,20);
    private final Rectangle threadsConnectionsLabelSize = new Rectangle(10,25,160,20);
    private final Rectangle threadsConnectionsFieldSize = new Rectangle(175,25,200,20);
    private final Rectangle threadsUsersLabelSize = new Rectangle(10,45, 160,20);
    private final Rectangle threadsUsersFieldSize = new Rectangle(175,45, 200,20);

    private JPanel threadsPanel;

    public RunningGUI(Locale locale, MessagePool msgPool, int port){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);
        this.setBounds(frameSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setResizable(false);

        this.msgPool = msgPool;
        this.port = port;

        panel = new JPanel();
        panel.setLayout(null);

        threadsPanel = new JPanel();
        threadsPanel.setLayout(new GridLayout(3,2,10,5));
        panel.add(threadsPanel);

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

    public void updateData(ThreadInfo[] infos){
        threadInfoFrameSize.height += infos.length * (70);
        threadsPanel.setBounds(threadInfoFrameSize);
        threadsPanel.setLayout(new GridLayout(3 * infos.length,2,10,0));
        frameSize.height += (threadsPanel.getHeight());
        this.setBounds(frameSize);
        threadsPanel.removeAll();
        for(int i = 0; i < infos.length; i++){
            JLabel threadsNameLabel = new JLabel();
            threadsNameLabel.setText(resourceBundle.getString(UIResourcesConstants.SERVER_THREADS_NAME_LABEL));
            threadsNameLabel.setBounds(threadsNameLabelSize);
            threadsPanel.add(threadsNameLabel);
            JTextField threadsNameField = new JTextField();
            threadsNameField.setText(infos[i].getThreadName());
            threadsNameField.setBounds(threadsNameFieldSize);
            threadsNameField.setEditable(false);
            threadsPanel.add(threadsNameField);

            JLabel threadsCountLabel = new JLabel();
            threadsCountLabel.setText(resourceBundle.getString(UIResourcesConstants.SERVER_THREADS_CONNECTIONS_COUNT));
            threadsCountLabel.setBounds(threadsConnectionsLabelSize);
            threadsPanel.add(threadsCountLabel);
            JTextField threadsConnectionsField = new JTextField();
            threadsConnectionsField.setText(String.valueOf(infos[i].getConnectionsCount()));
            threadsConnectionsField.setBounds(threadsConnectionsFieldSize);
            threadsConnectionsField.setEditable(false);
            threadsPanel.add(threadsConnectionsField);

            JLabel threadsUsersLabel = new JLabel();
            threadsUsersLabel.setText(resourceBundle.getString(UIResourcesConstants.SERVER_THREADS_USERS_COUNT));
            threadsUsersLabel.setBounds(threadsUsersLabelSize);
            threadsPanel.add(threadsUsersLabel);

            JTextField threadsUsersField = new JTextField();
            threadsUsersField.setText(String.valueOf(infos[i].getConnectionsCount()));
            threadsUsersField.setBounds(threadsUsersFieldSize);
            threadsUsersField.setEditable(false);
            threadsPanel.add(threadsUsersField);
        }
        frameSize.height -= threadsPanel.getHeight();
        threadInfoFrameSize.height -= infos.length * (70);
        this.repaint();
    }

}
