package ru.nsu.ccfit.Prokhorov.server.net;

import ru.nsu.ccfit.Prokhorov.server.core.MessagePool;
import ru.nsu.ccfit.Prokhorov.server.net.SocketToServer;

import java.io.*;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class SocketListener extends Thread{


    private SocketToServer conn;
    private Socket socket;
    private BufferedReader reader;
    private MessagePool pool;
    public SocketListener(SocketToServer conn, Socket socket, MessagePool pool){
        this.socket = socket;
        this.pool = pool;
        this.conn = conn;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run(){
        while(socket.isConnected()){
            String strl;
            try {
                strl = reader.readLine();
            } catch (IOException e) {
                conn.disconnect(socket);
                return;
            }
            //pool.add(strl);
        }
    }
}
