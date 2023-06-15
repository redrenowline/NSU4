package ru.nsu.ccfit.Prokhorov.server.net;

public class ThreadInfo {
    private String threadName;
    private int connectionsCount;
    private int userCount;

    public ThreadInfo(String threadName, int connectionsCount, int userCount){
        this.threadName = threadName;
        this.connectionsCount = connectionsCount;
        this.userCount = userCount;
    }

    public String getThreadName(){
        return threadName;
    }

    public int getConnectionsCount(){
        return connectionsCount;
    }
    public int getUserCount(){
        return userCount;
    }
}
