package ru.nsu.ccfit.Prokhorov.server.gui;

import ru.nsu.ccfit.Prokhorov.server.UIResourcesConstants;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.ResourceBundle;

public class InitializationGUI extends JFrame {

    private JPanel panel;
    private JLabel ipLabel;
    private JLabel portLabel;
    private JTextField ipField;
    private JTextField portField;
    private JComboBox comboBox;

    private JLabel threadsLabel;
    private JTextField threadsField;
    private JButton startButton;

    private Locale locale;
    private ResourceBundle resourceBundle;
    private final Rectangle frameSize = new Rectangle(100,100,360,170);
    private final Rectangle identIpLabelSize = new Rectangle(10,5,150,20);
    private final Rectangle identIpFieldSize = new Rectangle(155, 5, 180,20);
    private final Rectangle identPortLabelSize = new Rectangle(10,30,150,20);
    private final Rectangle identPortFieldSize = new Rectangle(155, 30, 180,20);
    private final Rectangle identParsersChooserSize = new Rectangle(10,55,325,20);
    private final Rectangle identStartButtonSize = new Rectangle(10,105,325,20);
    private final Rectangle identThreadsLabelSize = new Rectangle(10,80,150,20);
    private final Rectangle identThreadsFieldSize = new Rectangle(155, 80, 180,20);



    public InitializationGUI(Locale locale){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);
        this.setBounds(frameSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        identIpLabel();
        identIpField();
        identPortLabel();
        identPortField();
        identParsersChooser();
        identStartButton();
        identThreadsLabel();
        identThreadsField();

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
        portField.setText(resourceBundle.getString(UIResourcesConstants.PORT_DEF));
        portField.setBounds(identPortFieldSize);
        panel.add(portField);
    }

    private void identParsersChooser(){
        String[] args = {UIResourcesConstants.SER_PARSER_NAME, UIResourcesConstants.DOM_PAR_NAME};
        comboBox = new JComboBox(args);
        comboBox.setBounds(identParsersChooserSize);
        comboBox.setEditable(false);
        panel.add(comboBox);
    }

    private void identStartButton(){
        startButton = new JButton( resourceBundle.getString(UIResourcesConstants.START_SERVER));
        startButton.setBounds(identStartButtonSize);
        panel.add(startButton);
    }

    public void identThreadsLabel(){
        threadsLabel = new JLabel(resourceBundle.getString(UIResourcesConstants.THREADS_LABEL));
        threadsLabel.setBounds(identThreadsLabelSize);
        panel.add(threadsLabel);
    }

    public void identThreadsField(){
        threadsField = new JTextField(resourceBundle.getString(UIResourcesConstants.THREADS_DEF));
        threadsField.setBounds(identThreadsFieldSize);
        panel.add(threadsField);
    }


    public JButton getStartButton(){
        return startButton;
    }

    public int getPort(){
        return Integer.parseInt(portField.getText());
    }
    public String getParser(){
        return comboBox.getActionCommand();
    }

    public int getThreadsCount(){
        return Integer.parseInt(threadsField.getText());
    }

}
