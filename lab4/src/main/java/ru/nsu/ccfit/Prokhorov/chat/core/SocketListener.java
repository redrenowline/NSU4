package ru.nsu.ccfit.Prokhorov.chat.core;

import ru.nsu.ccfit.Prokhorov.shared.Chunk;

public interface SocketListener {
    public void weGetMessage(Chunk msg);
}
