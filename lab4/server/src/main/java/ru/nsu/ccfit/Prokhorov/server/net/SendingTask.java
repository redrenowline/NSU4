package ru.nsu.ccfit.Prokhorov.server.net;

import ru.nsu.ccfit.Prokhorov.shared.Chunk;

import java.nio.channels.SocketChannel;

public class SendingTask {

    private String nickname;
    private Chunk chunk;
    public SendingTask(String nickname, Chunk msg){
        this.nickname = nickname;
        this.chunk = msg;
    }
    public Chunk getChunk(){
        return chunk;
    }

}
