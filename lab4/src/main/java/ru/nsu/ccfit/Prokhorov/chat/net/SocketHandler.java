package ru.nsu.ccfit.Prokhorov.chat.net;

import ru.nsu.ccfit.Prokhorov.chat.core.SocketListener;
import ru.nsu.ccfit.Prokhorov.chat.net.structures.MsgChunk;
import ru.nsu.ccfit.Prokhorov.chat.parsers.Parser;

import java.io.*;
import java.net.Socket;

public class SocketHandler<T extends Parser> implements Runnable{

    private SocketListener listener;
    private Parser parser;

    private Socket socket;
    //private UserHandler user;

    private BufferedWriter writer;
    private BufferedReader reader;

    public SocketHandler(SocketListener listener,Parser parser, String hostname, int port){
        this.parser = parser;
        this.listener = listener;
        try {
            socket = new Socket(hostname, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e); // change it later
        }

    }
//    public boolean tryToLogin(String filepath) throws IOException {
//        user = new UserHandler(filepath);
//        writer.write(parser.parse(user));
//        //String buff = reader.readLine();
////        if(parser.deparse(buff) == Keys.succLogin){
// //           return true;
// //       }else{
// //           return false;
//  //      }
//        return true;
//    }

    public void reconnect(String hostname, int port){
        try {
            socket = new Socket(hostname, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e); // change it later
        }
    }
    public synchronized void sendMessage(String message){
        try {
            writer.write(parser.convertChunk(new MsgChunk(new UserHandler(),message))+'\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println("We got error");
            throw new RuntimeException(e);
        }
    }
    public void listen(){
        while(socket.isConnected()){
            try {
                String strl = reader.readLine();
                listener.weGetMessage(parser.deconvertChunk(strl).getMsg());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Socket getSocket(){
        return socket;
    }

    @Override
    public void run() {
        this.listen();
    }
}
