package ru.nsu.ccfit.Prokhorov.lab2.core;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.races.Human;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.Field;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Timeline;

public class Core {

    public Creature hero;
    public Field currField;
    private Timeline timeline;


    public Core(){
        currField = new Field();
        hero = new Human("0001");
        timeline = new Timeline();
    }
}
