package ru.nsu.ccfit.Prokhorov.chat.net;

import java.io.Serial;
import java.io.Serializable;

public class UserHandler implements Serializable {

    @Serial
    private static final long serialVersionUID = 50;
    private String username;
    private String nickname;

    public UserHandler(){

    }

    public UserHandler(String path){

    }

    @Override
    public String toString() {
        return "{" + username + " " + nickname + "}" ;
    }
}
