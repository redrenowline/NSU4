package ru.nsu.ccfit.Prokhorov.server.core;

import ru.nsu.ccfit.Prokhorov.server.net.SocketListener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Core implements SocketToServer{

    ServerSocket server;
    MessagePool pool;

    public Core(){
        pool = new MessagePool();


    }

    public void start(){
        try {
            server = new ServerSocket(406);
            while(true) {
                Socket clientSocket = server.accept();
                pool.addSocket(clientSocket);
                (new SocketListener(this,clientSocket, pool)).run();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void disconnect(Socket socket) {
        pool.getSockets().remove(socket);
    }
}
