package ru.nsu.ccfit.Prokhorov.chat.core;

import ru.nsu.ccfit.Prokhorov.chat.gui.GUIHandler;
import ru.nsu.ccfit.Prokhorov.chat.net.SocketHandler;
import ru.nsu.ccfit.Prokhorov.chat.parsers.XmlParser;

import java.awt.event.ActionEvent;

public class Core implements UIListener {

    private SocketHandler<XmlParser> socketHandler;
    private GUIHandler guiHandler;
    public Core(){
        this.identification();
    }
    private void identification(){
        guiHandler = new GUIHandler();
        guiHandler.addListener(this);
    }

    @Override
    public void onEnter(String hostname, int port,String path) {
        System.out.print("The user use button");
        try {
            socketHandler = new SocketHandler<>(new XmlParser(), hostname, port);
        }catch(RuntimeException e){
            guiHandler.showMessageAboutUnpath();
            return;
        }
        guiHandler.connectionIsCompleted();
    }
}
