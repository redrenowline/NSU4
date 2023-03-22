package ru.nsu.ccfit.Prokhorov.lab2.core.field;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.races.Human;

public class Field {

    private Room[][] rooms;
    private Room currRoom;

    public Field(){
        currRoom = RoomGenerator.generateRandomRoom();
        currRoom.setPlayer((new Human("0001")), 5,5);
    }

    public Room getCurrRoom(){
        return currRoom;
    }
}
