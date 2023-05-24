package ru.nsu.ccfit.Prokhorov.server.core;

import ru.nsu.ccfit.Prokhorov.shared.Chunk;
import ru.nsu.ccfit.Prokhorov.shared.Parser;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.*;

public class MessageThread extends Thread{

    java.util.logging.Logger log = java.util.logging.Logger.getLogger(MessageThread.class.getName());

    private final Selector selector;
    private final List<SocketChannel> channelList;
    private final MessagePool pool;
    private Parser parser;
    private MessageThreadsListener listener;

    private Map<SocketAddress, String> names;
    private final String sendMsgString = "Thread send the package # %d from Message Pool \n";
    public MessageThread(MessageThreadsListener listener, MessagePool pool, Parser parser){
        channelList = new Vector<>();
        names = new HashMap<>();
        try {
            selector = Selector.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.pool = pool;
        this.parser = parser;
        this.listener = listener;
    }

    public void addNewSocket(SocketChannel channel){
        try {
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);
            sendAllToSocket(channel);
        } catch (ClosedChannelException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        channelList.add(channel);
    }

    public void sendAllToSocket(SocketChannel socket){
        for(int i = 0; i < pool.getMessages().size(); i++){
            if(socket.isConnected()){
                try {
                    ByteBuffer buffer = ByteBuffer.wrap(parser.convertChunk(pool.getMessages().get(i)));
                    ByteBuffer byteNums = ByteBuffer.allocate(4);
                    byteNums.putInt(buffer.array().length);
                    byteNums.flip();
                    socket.write(byteNums);
                    socket.write(ByteBuffer.wrap(parser.convertChunk(pool.getMessages().get(i))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                log.info(String.format(sendMsgString, i));
            }
        }
    }

    public void sendToEverybody(Chunk chunk){
        for(int i = 0;i < channelList.size(); i++){
            if(channelList.get(i).isConnected()){
                try {
                    ByteBuffer buffer = ByteBuffer.wrap(parser.convertChunk(chunk));
                    ByteBuffer byteNums = ByteBuffer.allocate(4);
                    byteNums.putInt(buffer.array().length);
                    byteNums.flip();
                    channelList.get(i).write(byteNums);
                    channelList.get(i).write(buffer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public int getStat(){
        return channelList.size();
    }

    @Override
    public void run() {
        while(true){
            int count;
            try {
                count = selector.selectNow();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator itr = keys.iterator();
            while(itr.hasNext()){
                SelectionKey key = (SelectionKey) itr.next();
                if(key.isReadable()){
                    SocketChannel socketChanel  = (SocketChannel) key.channel();
                    ByteBuffer byteNums = ByteBuffer.allocate(4);
                    ByteBuffer buffer;
                    try{
                        socketChanel.read(byteNums);
                        byteNums.flip();
                        int cb = byteNums.getInt();
                        buffer = ByteBuffer.allocate(cb );
                        socketChanel.read(buffer);
                    } catch (IOException e) {
                        disconnectSocket(socketChanel);
                        continue;
                    }
                    byte[] mass = buffer.array();
                    Chunk myChunk = parser.deconvertChunk(mass);
                    analyzeMessage(socketChanel,myChunk);
                }
            }
            keys.clear();
        }
    }

    public void analyzeMessage(SocketChannel socket,Chunk msg) {
        Chunk answer;
        switch(msg.getTag()){
            case MESSAGE:
                pool.add(msg);
                listener.sendMessageToEveryone(msg);
                break;
            case LOGIN:
                answer = new Chunk(null, null, Chunk.TAG.SUCCESS);
                try {
                    ByteBuffer buffer = ByteBuffer.wrap(parser.convertChunk(answer));
                    ByteBuffer byteNums = ByteBuffer.allocate(4);
                    byteNums.putInt(buffer.array().length);
                    byteNums.flip();
                    socket.write(byteNums);
                    socket.write(buffer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pool.add(msg);
                listener.sendMessageToEveryone(msg);
                break;
            case LIST:
                answer = new Chunk(null, getUserInfo(), Chunk.TAG.LIST_ANSWER);
                try {
                    socket.write(ByteBuffer.wrap(parser.convertChunk(answer)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    public String getUserInfo(){
        return listener.getUsersInfo();
    }
    public String getUserInfoInThread(){
        String res = "";
        Iterator<Map.Entry<SocketAddress, String>> itr = names.entrySet().iterator();
        for(Map.Entry<SocketAddress, String> entry: names.entrySet()){
            res += entry.getValue() + " ";
        }
        return res;
    }

    public void disconnectSocket(SocketChannel socket) {
        channelList.remove(socket);
        try {
            listener.sendMessageToEveryone(new Chunk(null, names.get(socket.getLocalAddress()), Chunk.TAG.LOGOUT));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
