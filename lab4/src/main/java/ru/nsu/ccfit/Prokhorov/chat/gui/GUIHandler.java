package ru.nsu.ccfit.Prokhorov.chat.gui;

import ru.nsu.ccfit.Prokhorov.chat.core.UIListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.BiConsumer;

public class GUIHandler {

    private ArrayList<UIListener> listeners;
    private IdentificationWindow idetWindow;
    private MainWindow mainWindow;
    public GUIHandler(){
        listeners = new ArrayList<>();

        idetWindow = new IdentificationWindow();
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
        JOptionPane.showMessageDialog(null, "Your data is wrong");
    }
    public void showMessageAboutUnpath(){
        JOptionPane.showMessageDialog(null, "This server is unreachable");
    }

    public void connectionIsCompleted(){
        idetWindow.setVisible(false);
        mainWindow = new MainWindow();
    }

    public void notifyThatUserLogin(){
        String hostname;
        int port;
        String path;
        try {
            hostname = idetWindow.getHostname();
            port = idetWindow.getPort();
            path = idetWindow.getFilePath();
        }catch(RuntimeException e){
            showMessageAboutWrongData();
            return;
        }
        for(final UIListener listener:listeners){
            listener.onEnter(hostname,port,path);
        }
    }
}