package ru.nsu.ccfit.Prokhorov.chat.core;

import ru.nsu.ccfit.Prokhorov.chat.UIResourcesConstants;
import ru.nsu.ccfit.Prokhorov.chat.gui.GUIHandler;
import ru.nsu.ccfit.Prokhorov.chat.local.UIResources;
import ru.nsu.ccfit.Prokhorov.chat.net.SocketHandler;
import ru.nsu.ccfit.Prokhorov.shared.Chunk;
import ru.nsu.ccfit.Prokhorov.shared.SerializeParser;

import java.util.Locale;
import java.util.ResourceBundle;

public class Core implements UIListener, SocketListener {


    private SocketHandler<SerializeParser> socketHandler;
    private Thread socketThread;
    private GUIHandler guiHandler;

    private Locale locale = new Locale("ru");
    private ResourceBundle resourceBundle;

    public Core(){
        this.identification();
    }
    private void identification(){
        guiHandler = new GUIHandler(locale);
        guiHandler.addListener(this);
        resourceBundle = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);
    }

    @Override
    public void onEnter(String hostname, int port, String nickname) {
    //    logger.info("The user try to connect to server\n");
        try {
            socketHandler = new SocketHandler<>(this, new SerializeParser(), hostname, port, nickname);
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
            socketHandler.sendMessage(msg, Chunk.TAG.MESSAGE);
        }catch(Exception e){
            //logger.severe("Something goes wrong\n");
        }
    }

    @Override
    public synchronized void weGetMessage(Chunk msg) {
        if(msg.getTag() == Chunk.TAG.MESSAGE)
            guiHandler.addNewMessage(String.format(UIResources.msg_format,msg.getUserInfo().getNickname(),msg.getMsg()));
        else if(msg.getTag() == Chunk.TAG.LOGIN)
            guiHandler.addNewMessage(String.format(resourceBundle.getString(UIResourcesConstants.NEW_LOGIN), msg.getMsg()));
        else if(msg.getTag() == Chunk.TAG.LOGOUT)
            guiHandler.addNewMessage(String.format(resourceBundle.getString(UIResourcesConstants.OLD_LOGOUT), msg.getMsg()));
    }
}
