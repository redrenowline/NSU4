package ru.nsu.ccfit.Prokhorov.chat.gui;

import ru.nsu.ccfit.Prokhorov.chat.UIResourcesConstants;
import ru.nsu.ccfit.Prokhorov.chat.core.UIListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;

public class GUIHandler {

    private ArrayList<UIListener> listeners;
    private IdentificationWindow idetWindow;
    private MainWindow mainWindow;

    private Locale locale;
    private ResourceBundle resourceBundle;
    public GUIHandler(Locale locale){
        this.locale = locale;
        listeners = new ArrayList<>();
        resourceBundle = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);

        idetWindow = new IdentificationWindow(locale);
        idetWindow.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyThatUserLogin();
            }
        });
    }

    public void addListener(UIListener listener){
        this.listeners.add(listener);
    }

    public void showMessageAboutWrongData(){
        JOptionPane.showMessageDialog(null,  resourceBundle.getString(UIResourcesConstants.DATA_WR));
    }
    public void showMessageAboutUnpath(){
        JOptionPane.showMessageDialog(null, resourceBundle.getString(UIResourcesConstants.UNRE_PTH));
    }

    public void addNewMessage(String strl){
        mainWindow.addNewMessage(strl);
    }

    public void connectionIsCompleted(){
        idetWindow.setVisible(false);
        mainWindow = new MainWindow();
        mainWindow.getSendButton().addActionListener(e -> notifyThatMessageSending());
        mainWindow.getEnterField().addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.print(e.getKeyCode() + "\n");
                switch (e.getKeyCode()) {
                    case 10:
                        notifyThatMessageSending();
                    break;
                }
            }
        });
    }

    public void notifyThatUserLogin(){
        String hostname;
        int port;
        String path, nickname;
        try {
            hostname = idetWindow.getHostname();
            port = idetWindow.getPort();
            nickname = idetWindow.getNickname();
        }catch(RuntimeException e){
            showMessageAboutWrongData();
            return;
        }
        for(final UIListener listener:listeners){
            listener.onEnter(hostname,port,nickname);
        }
    }
    public void notifyThatMessageSending(){
        String strl;
        try{
            strl = mainWindow.getText();
            if(strl == "") return;
            mainWindow.getEnterField().setText("");
        }catch(Exception e){
            throw new RuntimeException();
        }
        for(final UIListener listener:listeners){
            listener.sendMessage(strl);
        }
    }
}