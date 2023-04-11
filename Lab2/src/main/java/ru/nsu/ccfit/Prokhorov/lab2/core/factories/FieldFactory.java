package ru.nsu.ccfit.Prokhorov.lab2.core.factories;

import ru.nsu.ccfit.Prokhorov.lab2.core.Player;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.Field;

public class FieldFactory {

    public static Field generateStartField(Player player){
        Field res = new Field(1,1,RoomGenerator.generateStartRoom(player));
        return res;
    }
}
