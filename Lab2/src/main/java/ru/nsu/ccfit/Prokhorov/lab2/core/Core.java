package ru.nsu.ccfit.Prokhorov.lab2.core;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.library.races.Human;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.Field;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Effect;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Timeline;

public class Core {

    public Player player;
    public Creature hero;
    public Field currField;
    private Timeline timeline;


    public Core(){
        currField = new Field(5,5);
        hero = new Human("0001");
        player = new Player(hero);
        currField.getCurrRoom().setPlayer(player.getPlayerCreature(), 0,0);
        timeline = new Timeline();
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
