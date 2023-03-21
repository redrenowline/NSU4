package ru.nsu.ccfit.Prokhorov.lab2.core.field;

public class Field {

    private Room[][] rooms;
    private Room currRoom;

    public Field(){
        currRoom = RoomGenerator.generateRandomRoom();
    }

    public Room getCurrRoom(){
        return currRoom;
    }
}
