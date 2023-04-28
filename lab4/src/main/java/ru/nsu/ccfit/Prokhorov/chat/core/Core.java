package ru.nsu.ccfit.Prokhorov.chat.core;

import ru.nsu.ccfit.Prokhorov.chat.gui.GUIHandler;
import ru.nsu.ccfit.Prokhorov.chat.net.SocketHandler;
import ru.nsu.ccfit.Prokhorov.chat.parsers.XmlParser;

public class Core implements UIListener, SocketListener {


    private SocketHandler<XmlParser> socketHandler;
    private Thread socketThread;
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
    //    logger.info("The user try to connect to server\n");
        try {
            socketHandler = new SocketHandler<>(this, new XmlParser(), hostname, port);
        }catch(RuntimeException e){
            guiHandler.showMessageAboutUnpath();
        //    logger.severe("Error");
            return;
        }
        guiHandler.connectionIsCompleted();
        //logger.info("The attempt to connect is okay!");
        socketThread = (new Thread(socketHandler));
        socketThread.start();
    }

    @Override
    public void sendMessage(String msg) {
        try {
            socketHandler.sendMessage(msg);
        }catch(Exception e){
            //logger.severe("Something goes wrong\n");
        }
    }

    @Override
    public synchronized void weGetMessage(String msg) {
        guiHandler.addNewMessage(msg);
    }
}
