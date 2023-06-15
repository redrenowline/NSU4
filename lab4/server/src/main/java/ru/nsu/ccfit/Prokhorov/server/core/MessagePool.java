package ru.nsu.ccfit.Prokhorov.server.core;

import ru.nsu.ccfit.Prokhorov.shared.Chunk;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Vector;

public class MessagePool {

    private List<Chunk> ls;
    public MessagePool(){
        ls = new Vector<>();
    }
    public synchronized void add(Chunk msg){
        ls.add(msg);
    }

    public synchronized List<Chunk> getMessages(){
        return ls;
    }
}
