package ru.nsu.ccfit.Prokhorov.lab2.core.field;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.library.races.Human;

public class Field {

    private Room[][] rooms;
    private Room currRoom;

    public Field(int h, int w, Room start){
        rooms = new Room[h][w];
        currRoom = start;
    }

    public Room getCurrRoom(){
        return currRoom;
    }
}
