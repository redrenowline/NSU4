package ru.nsu.ccfit.Prokhorov.lab2.core;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.factories.FieldFactory;
import ru.nsu.ccfit.Prokhorov.lab2.core.logic.CreatureHandler;
import ru.nsu.ccfit.Prokhorov.lab2.library.races.Human;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.Field;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Effect;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Timeline;

import java.util.List;
import java.util.Vector;

public class Core {

    public Player player;
    public Creature hero;
    public Field currField;
    private Timeline timeline;
    private List<CreatureHandler> npcs;


    public Core(){
        hero = new Human("0001");
        player = new Player(hero, currField,0,0);
        currField = FieldFactory.generateStartField(player);
        timeline = new Timeline();
        npcs = new Vector<CreatureHandler>();
    }

    public Timeline getTimeline(){
        return timeline;
    }

    public Field getCurrField(){
        return currField;
    }

    public void addEffectToTimeLine(Effect effect){
        timeline.subsEffects.add(effect);
    }

}
