package ru.nsu.ccfit.Prokhorov.shared;
import java.io.Serializable;
import java.util.Date;

public class Chunk implements Serializable {

    public enum TAG{
        MESSAGE,
        LOGIN,
        LOGOUT,
        SUCCESS,
        ERROR,
        LIST,
        LIST_ANSWER
    }

    private UserHandler userInfo;
    private String msg;
    private TAG tag;

    public Chunk(UserHandler userInfo, String msg, TAG tag){
        this.userInfo = userInfo;
        this.msg = msg;
        this.tag = tag;
    }

    public UserHandler getUserInfo(){
        return userInfo;
    }

    public String getUser(){
        return userInfo.getNickname();
    }

    public String getMsg(){
        return msg;
    }

    public TAG getTag(){
        return tag;
    }
}
