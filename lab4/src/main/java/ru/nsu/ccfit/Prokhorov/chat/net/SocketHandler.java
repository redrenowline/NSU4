package ru.nsu.ccfit.Prokhorov.chat.net;

import ru.nsu.ccfit.Prokhorov.chat.core.SocketListener;
import ru.nsu.ccfit.Prokhorov.shared.Chunk;
import ru.nsu.ccfit.Prokhorov.shared.Parser;
import ru.nsu.ccfit.Prokhorov.shared.UserHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Base64;

public class SocketHandler<T extends Parser> implements Runnable{

    private SocketListener listener;
    private Parser parser;

    private SocketChannel socket;
    private UserHandler user;

    public static Charset charset = Charset.forName("UTF-8");
    public static CharsetEncoder encoder = charset.newEncoder();
    public static CharsetDecoder decoder = charset.newDecoder();

    public SocketHandler(SocketListener listener, Parser parser, String hostname, int port, String nickname){
        this.parser = parser;
        this.listener = listener;
        user = new UserHandler(nickname);
        try {
            socket = SocketChannel.open(new InetSocketAddress(hostname, port));
            sendMessage(user.getNickname(), Chunk.TAG.LOGIN);
        } catch (IOException e) {
            throw new RuntimeException(e); // change it later
        }

    }


    public void reconnect(String hostname, int port){
        try {
            socket = SocketChannel.open(new InetSocketAddress(hostname, port));
        } catch (IOException e) {
            throw new RuntimeException(e); // change it later
        }
    }
    public synchronized void sendMessage(String message, Chunk.TAG tag){
        try {
            byte[] mass = parser.convertChunk(new Chunk(user, message, tag));
            ByteBuffer bufferSize = ByteBuffer.allocate(4);
            int size = mass.length;
            bufferSize.putInt(mass.length);
            bufferSize.flip();
            socket.write(bufferSize);
            ByteBuffer buffer = ByteBuffer.wrap(mass);
            socket.write(buffer);
        } catch (IOException e) {
            System.out.println("We got error");
            throw new RuntimeException(e);
        }
    }

    public void listen(){
        while(socket.isConnected()){
            try {
                ByteBuffer buffer = ByteBuffer.allocate(2048);
                socket.read(buffer);
                byte[] mass = buffer.array();
                listener.weGetMessage(parser.deconvertChunk(mass));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        this.listen();
    }
}
