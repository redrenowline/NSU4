package ru.nsu.ccfit.Prokhorov.chat.net;

import ru.nsu.ccfit.Prokhorov.chat.parsers.Parser;

import java.io.*;
import java.net.Socket;

public class SocketHandler<T extends Parser> {

    private Parser parser;

    private Socket socket;
    private UserHandler user;

    private BufferedReader reader;
    private BufferedWriter writer;

    public SocketHandler(Parser parser, String hostname, int port){
        this.parser = parser;
        try {
            socket = new Socket(hostname, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e); // change it later
        }

    }
    public boolean tryToLogin(String filepath) throws IOException {
        user = new UserHandler(filepath);
        writer.write(parser.parse(user));
        String buff = reader.readLine();
        if(parser.deparse(buff) == Keys.succLogin){
            return true;
        }else{
            return false;
        }
    }

    public void reconnect(String hostname, int port){
        try {
            socket = new Socket(hostname, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e); // change it later
        }
    }
    public void sendMessage(String message){
        try {
            writer.write(message+'\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println("We got error");
            throw new RuntimeException(e);
        }
    }
}
