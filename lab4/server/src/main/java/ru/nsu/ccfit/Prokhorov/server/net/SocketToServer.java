package ru.nsu.ccfit.Prokhorov.server.net;

import java.net.Socket;

public interface SocketToServer {
    void disconnect(Socket socket);
}
