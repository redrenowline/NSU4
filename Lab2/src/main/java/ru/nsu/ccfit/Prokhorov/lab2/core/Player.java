package ru.nsu.ccfit.Prokhorov.lab2.core;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;

import java.util.List;
import java.util.Vector;

public class Player {

    private Creature ch;

    public Player(Creature ch){
        this.ch = ch;
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
