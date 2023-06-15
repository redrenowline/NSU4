package ru.nsu.ccfit.Prokhorov.chat.net;

import ru.nsu.ccfit.Prokhorov.chat.core.SocketListener;
import ru.nsu.ccfit.Prokhorov.shared.Chunk;
import ru.nsu.ccfit.Prokhorov.shared.Parser;
import ru.nsu.ccfit.Prokhorov.shared.UserHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketHandler<T extends Parser> implements Runnable{

    private SocketListener listener;
    private Parser parser;

    private SocketChannel socket;
    private UserHandler user;


    public SocketHandler(SocketListener listener, Parser parser, String hostname, int port, String nickname){
        this.parser = parser;
        this.listener = listener;
        user = new UserHandler(nickname, null);
        try {
            socket = SocketChannel.open(new InetSocketAddress(hostname, port));
            sendLoginMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void sendLoginMessage(){
        sendMessage(this.user.getNickname(), Chunk.TAG.LOGIN);
    }

    public void sendListRequest(){
        sendMessage("", Chunk.TAG.LIST);
    }

    public synchronized void sendMessage(String message, Chunk.TAG tag){
        try {
            byte[] mass = parser.convertChunk(new Chunk(user, message, tag));
            ByteBuffer bufferSize = ByteBuffer.allocate(4);
            bufferSize.putInt(mass.length);
            bufferSize.flip();
            socket.write(bufferSize);
            ByteBuffer buffer = ByteBuffer.wrap(mass);
            socket.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listen(){
        while(socket.isConnected()){
            try {
                int length;
                ByteBuffer bufferSize = ByteBuffer.allocate(4);
                socket.read(bufferSize);
                bufferSize.flip();
                length = bufferSize.getInt();
                ByteBuffer buffer = ByteBuffer.allocate(length);
                socket.read(buffer);
                byte[] mass = buffer.array();
                analyzeMessage(parser.deconvertChunk(mass));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void analyzeMessage(Chunk chunk){
        switch(chunk.getTag()){
            case MESSAGE, LOGIN:
                listener.weGetMessage(chunk);
                break;
        }
    }

    @Override
    public void run() {
        this.listen();
    }
}
