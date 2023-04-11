package ru.nsu.ccfit.Prokhorov.lab2.core;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.Field;
import ru.nsu.ccfit.Prokhorov.lab2.core.logic.CreatureHandler;

import java.util.List;
import java.util.Vector;

public class Player extends CreatureHandler {

    private Creature ch;
    private int x, y = 0;

    public Player(Creature ch, Field fd, int x, int y){
        super(ch, fd, x, y);
    }

    public Creature getPlayerCreature(){
        return ch;
    }

    public List<String> getCharacteristics(){
        List<String> res = new Vector<String>();
        for(int i = 0; i < Creature.characteristicsTypes.values().length; i++){
            res.add(new String(""));
        }
        return res;
    }
}
