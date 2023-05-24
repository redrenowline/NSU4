package ru.nsu.ccfit.Prokhorov.server.net;

import ru.nsu.ccfit.Prokhorov.server.core.MessagePool;
import ru.nsu.ccfit.Prokhorov.server.core.MessageThread;
import ru.nsu.ccfit.Prokhorov.server.core.MessageThreadsListener;
import ru.nsu.ccfit.Prokhorov.shared.Chunk;
import ru.nsu.ccfit.Prokhorov.shared.SerializeParser;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerHandler extends Thread implements MessageThreadsListener {
    private int THREAD_COUNT = 1;
    private ServerSocketChannel server;
    private MessagePool pool;
    private MessageThread[] threads;
    private int port = 406;
    private int[] statistics;

    public ServerHandler(MessagePool pool, int port, int threadsC){
        this.pool = pool;
        threads = new MessageThread[threadsC];
        try {
            server = ServerSocketChannel.open();
            server.socket().bind(new InetSocketAddress(port));
        }catch(Exception e){
            e.printStackTrace();
        }
        for(int i = 0; i < THREAD_COUNT; i++){
            threads[i] = new MessageThread(this, this.pool, new SerializeParser());
            threads[i].start();
        }
    }

    @Override
    public void run(){
        while(true) {
            try {
                SocketChannel clientSocket = server.accept();
                int max = 256;int itr = 0;
                for(int i = 0; i < THREAD_COUNT; i++)
                    if(max < threads[i].getStat()){
                        itr = i;
                        max = threads[i].getStat();
                    }
                threads[itr].addNewSocket(clientSocket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void sendMessageToEveryone(Chunk msg) {
        for(int i = 0; i < THREAD_COUNT; i++){
            threads[i].sendToEverybody(msg);
        }
    }

    @Override
    public String getUsersInfo() {
        String res = "";
        for(MessageThread itr : threads){
            res += itr.getUserInfoInThread();
        }
        return null;
    }
}
