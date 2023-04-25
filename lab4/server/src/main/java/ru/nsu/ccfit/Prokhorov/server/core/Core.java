package ru.nsu.ccfit.Prokhorov.server.core;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Core {

    ServerSocket server;
    Socket clientSocket;

    public Core(){
        try {
            server = new ServerSocket(406);
            clientSocket =  server.accept();
            System.out.println("Somebody connected!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String word = reader.readLine();
            System.out.println(word);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
