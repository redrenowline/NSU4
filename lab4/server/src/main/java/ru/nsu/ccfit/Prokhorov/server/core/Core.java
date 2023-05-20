package ru.nsu.ccfit.Prokhorov.server.core;

import ru.nsu.ccfit.Prokhorov.server.gui.GUIHandler;
import ru.nsu.ccfit.Prokhorov.server.net.ServerHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Core implements GUIListener {

    private MessagePool pool;
    private ServerHandler serverHandler;

    private GUIHandler gui;

    public Core(){
        pool = new MessagePool();
        gui = new GUIHandler(this, pool);
        gui.showInitWindow();
    }

    @Override
    public void startServerWork(int port, int THREAD_COUNT) {
        serverHandler = new ServerHandler(pool, port, THREAD_COUNT);
        serverHandler.start();
    }
}
