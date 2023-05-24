package ru.nsu.ccfit.Prokhorov.chat.core;

import ru.nsu.ccfit.Prokhorov.chat.UIResourcesConstants;
import ru.nsu.ccfit.Prokhorov.chat.gui.GUIHandler;
import ru.nsu.ccfit.Prokhorov.chat.local.UIResources;
import ru.nsu.ccfit.Prokhorov.chat.net.SocketHandler;
import ru.nsu.ccfit.Prokhorov.shared.Chunk;
import ru.nsu.ccfit.Prokhorov.shared.LoggerDataConstants;
import ru.nsu.ccfit.Prokhorov.shared.SerializeParser;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Core implements UIListener, SocketListener {

    private Logger logger = Logger.getLogger(Core.class.getName());
    private SocketHandler<SerializeParser> socketHandler;
    private Thread socketThread;
    private GUIHandler guiHandler;

    private Locale locale = new Locale("ru");
    private ResourceBundle resourceBundle1;
    private ResourceBundle resourceBundle2;

    public Core(){
        this.identification();
    }
    private void identification(){
        guiHandler = new GUIHandler(locale);
        guiHandler.addListener(this);
        resourceBundle1 = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);
        resourceBundle2 = ResourceBundle.getBundle(UIResourcesConstants.BUNDLE_NAME, locale);
    }

    @Override
    public void onEnter(String hostname, int port, String nickname) {
        try {
            socketHandler = new SocketHandler<>(this, new SerializeParser(), hostname, port, nickname);
        }catch(RuntimeException e){
            guiHandler.showMessageAboutUnpath();
            logger.severe(resourceBundle2.getString(LoggerDataConstants.LOGGER_ERROR));
            return;
        }
        guiHandler.connectionIsCompleted();
        socketThread = (new Thread(socketHandler));
        socketThread.start();
    }

    @Override
    public void sendMessage(String msg) {
        try {
            socketHandler.sendMessage(msg, Chunk.TAG.MESSAGE);
        }catch(Exception e){
            logger.severe(resourceBundle2.getString(LoggerDataConstants.LOGGER_ERROR));
        }
    }

    @Override
    public synchronized void weGetMessage(Chunk msg) {
        logger.severe(resourceBundle2.getString(LoggerDataConstants.LOGGER_USER_GET_USERS_LIST));
        if(msg.getTag() == Chunk.TAG.MESSAGE)
            guiHandler.addNewMessage(String.format(UIResources.msg_format,msg.getUserInfo().getNickname(),msg.getMsg()));
        else if(msg.getTag() == Chunk.TAG.LOGIN)
            guiHandler.addNewMessage(String.format(resourceBundle1.getString(UIResourcesConstants.NEW_LOGIN), msg.getMsg()));
        else if(msg.getTag() == Chunk.TAG.LOGOUT)
            guiHandler.addNewMessage(String.format(resourceBundle1.getString(UIResourcesConstants.OLD_LOGOUT), msg.getMsg()));
    }
}
