package ru.nsu.ccfit.Prokhorov.shared;
import java.io.Serial;
import java.io.Serializable;

public class UserHandler implements Serializable {

    @Serial
    private static final long serialVersionUID = 50;
    private String nickname;
    private String sessionID;

    public UserHandler(){

    }

    public UserHandler(String nickname, String sessionID){
        this.nickname =nickname;
        this.sessionID = sessionID;
    }

    public String getNickname(){
        return nickname;
    }

    public String getSessionID(){
        return sessionID;
    }

    @Override
    public String toString() {
        return "{" + nickname + "}" ;
    }
}
