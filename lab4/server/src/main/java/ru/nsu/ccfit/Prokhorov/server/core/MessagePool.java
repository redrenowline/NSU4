package ru.nsu.ccfit.Prokhorov.server.core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class MessagePool {

    List<String> ls;
    List<Socket> sockets;
    public MessagePool(){
        ls = new Vector<>();
        sockets = new Vector<>();
    }
    public synchronized void add(String strl){
        ls.add(strl);
        System.out.print(strl);
        sendMessageToEverybody(strl);
    }
    public void addSocket(Socket socket){
        System.out.print(" : " + socket.getInetAddress().getHostAddress() + "\n");
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            for (String strl: ls) {
                writer.write(strl + "\n");
            }
            writer.flush();
            sockets.add(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendMessageToEverybody(String strl){
        try{
            for(Socket socket: sockets){
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.write(strl + "\n");
                writer.flush();
            }
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
    public List<Socket> getSockets(){
        return sockets;
    }
}
