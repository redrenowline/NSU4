package ru.nsu.ccfit.Prokhorov.chat.core;

import java.awt.event.ActionEvent;

public interface UIListener {

    public void onEnter(String hostname, int port, String nickname);
    public void sendMessage(String msg);
}
