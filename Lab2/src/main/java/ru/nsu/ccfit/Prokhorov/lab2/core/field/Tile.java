package ru.nsu.ccfit.Prokhorov.lab2.core.field;

import ru.nsu.ccfit.Prokhorov.lab2.core.items.Equipment;

import java.util.List;
import java.util.Vector;

public class Tile {

    private boolean isEarth;
    private List<Equipment> things;
    private Character character;
    public Tile(){
        things = new Vector<Equipment>();
        character = null;
        isEarth = true;
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

    public Character getCharacter(){
        return character;
    }
    public void setCharacter(Character ch){
        this.character = ch;
    }

    public List<Equipment> getThings(){
        return things;
    }
}
