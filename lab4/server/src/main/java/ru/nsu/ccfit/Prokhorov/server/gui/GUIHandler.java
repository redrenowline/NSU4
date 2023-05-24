package ru.nsu.ccfit.Prokhorov.server.gui;

import ru.nsu.ccfit.Prokhorov.server.core.GUIListener;
import ru.nsu.ccfit.Prokhorov.server.core.MessagePool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GUIHandler {

    private InitializationGUI initializationGUI;
    private RunningGUI runningGUI;
    private GUIListener listener;
    private MessagePool msgPool;
    private Locale locale = new Locale("ru");

    public GUIHandler(GUIListener listener, MessagePool pool){
        this.listener = listener;
        this.msgPool = pool;
    }

    public void showInitWindow(){
        initializationGUI = new InitializationGUI(locale);
        initializationGUI.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializationGUI.setEnabled(false);
                initializationGUI.dispose();
                showRuningGUI();
                listener.startServerWork(initializationGUI.getPort(), 4);

            }
        });
    }

    private void showRuningGUI(){
        runningGUI = new RunningGUI(locale, msgPool, initializationGUI.getPort());
    }
}
