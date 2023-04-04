package ru.nsu.ccfit.Prokhorov.lab2.core.field;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.library.races.Human;

public class Field {

    private Room[][] rooms;
    private Room currRoom;

    public Field(int h, int w){
        rooms = new Room[h][w];
        for(int i = 0 ; i < h; i++){
            for(int j = 0; j < w; j++){
                rooms[i][j] = RoomGenerator.generateRandomRoom();
            }
        }
        currRoom = rooms[0][0];
    }

    public Room getCurrRoom(){
        return currRoom;
    }
}
