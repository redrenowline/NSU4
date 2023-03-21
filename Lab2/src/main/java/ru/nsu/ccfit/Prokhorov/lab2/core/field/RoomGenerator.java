package ru.nsu.ccfit.Prokhorov.lab2.core.field;

public class RoomGenerator {

    public static Room generateRandomRoom(){
        Room res = new Room(10, 10);
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                res.digIn(5+i, 5+j);
            }
        }
        return res;
    }
}
