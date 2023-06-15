package ru.nsu.ccfit.Prokhorov.server.core;

import ru.nsu.ccfit.Prokhorov.shared.Chunk;

public interface MessageThreadsListener {

    public void sendMessageToEveryone(Chunk msg);
    public String getUsersInfo();
    public void SomeoneDisconnected();
}
