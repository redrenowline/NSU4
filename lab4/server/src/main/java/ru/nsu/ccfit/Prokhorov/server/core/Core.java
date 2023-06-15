package ru.nsu.ccfit.Prokhorov.server.core;

import ru.nsu.ccfit.Prokhorov.server.gui.GUIHandler;
import ru.nsu.ccfit.Prokhorov.server.net.ServerHandler;

public class Core implements GUIListener {

    private MessagePool pool;
    private ServerHandler serverHandler;

    private GUIHandler gui;

    public Core(){
        pool = new MessagePool();
        gui = new GUIHandler(this, pool);
    }

    public void start(){
        gui.showInitWindow();
    }

    @Override
    public void startServerWork(int port, int THREAD_COUNT) {
        serverHandler = new ServerHandler(gui, pool, port, THREAD_COUNT);
        serverHandler.start();
    }
}
