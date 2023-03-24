package ru.nsu.ccfit.Prokhorov.lab2.core.field;

public class RoomGenerator {

    public static Room generateRandomRoom(){
        Room res = new Room(10, 15);
        for(int i = -2; i <= 2; i++){
            for(int j = -2; j <= 2; j++){
                res.digIn(5+i, 5+j);
            }
        }
        return res;
    }
}
