package ru.nsu.ccfit.Prokhorov.server.net;

import java.io.*;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class SocketListener extends Thread{

    private Socket socket;
    private BufferedReader reader;
    public SocketListener(Socket socket){
        this.socket = socket;
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
                throw new RuntimeException(e);
            }

        }
    }
}
