package ru.nsu.ccfit.Prokhorov.lab2.core.field;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.items.Equipment;

import java.util.List;
import java.util.Vector;

public class Tile {

    private boolean isEarth;
    private boolean isDoor;
    private List<Equipment> things;
    private Creature character;
    public Tile(){
        things = new Vector<Equipment>();
        character = null;
        isEarth = true;
        isDoor = false;
    }

    public void dig(){
        this.isEarth = false;
    }

    public void fill(){
        isEarth = true;
    }

    public boolean getEarthState(){
        return isEarth;
    }

    public Creature getCharacter(){
        return character;
    }
    public void setCharacter(Creature ch){
        this.character = ch;
    }

    public List<Equipment> getThings(){
        return things;
    }
}
