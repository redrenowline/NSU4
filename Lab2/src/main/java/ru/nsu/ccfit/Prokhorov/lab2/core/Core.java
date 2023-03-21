package ru.nsu.ccfit.Prokhorov.lab2.core;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.races.Human;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.Field;

public class Core {

    public Creature hero;
    public Field currFloor;

    public Core(){
        currFloor = new Field();
        hero = new Human("0001");
    }
}
