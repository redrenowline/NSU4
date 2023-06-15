package ru.nsu.ccfit.Prokhorov.lab2.model;

public class Pair {
    private int first;
    private int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    public void setValues(int first, int second){
        this.first = first;
        this.second = second;
    }

    public int getFirst(){
        return first;
    }

    public int getSecond(){
        return second;
    }

}
