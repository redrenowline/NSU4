package ru.nsu.ccfit.Prokhorov.lab2.core.factories;

import ru.nsu.ccfit.Prokhorov.lab2.core.Player;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.Room;

public class RoomGenerator {

    public static Room generateRandomRoom(){
        Room res = new Room(10, 15);
// code
        return res;
    }

    public static Room generateStartRoom(Player player){
        Room res = new Room(10,10);
        res.setPlayer(player.getPlayerCreature(), 5, 5);
        for(int i = 1; i < 9; i++){
            for(int j = 1; j < 9;j++){
                res.digIn(i,j);
            }
        }
        return res;
    }
}
