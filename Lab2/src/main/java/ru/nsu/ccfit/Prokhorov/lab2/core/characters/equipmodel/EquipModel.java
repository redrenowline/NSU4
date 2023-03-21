package ru.nsu.ccfit.Prokhorov.lab2.core.characters.equipmodel;

import ru.nsu.ccfit.Prokhorov.lab2.core.items.Equipment;
import ru.nsu.ccfit.Prokhorov.lab2.core.items.Holder;

import java.util.List;
import java.util.Vector;

public abstract class EquipModel {

    protected EquipModel(){
        equips = new Equipment[Equipment.type.values().length];
        for(int i = 0; i < Equipment.type.values().length; i++){
            equips[i] = null;
        }
        inventory = new Vector<Equipment>();
    }

    protected List<Equipment> inventory;
    protected Equipment[] equips;

    public void equip(Equipment eq) {
        if(equips[eq.t.ordinal()] instanceof Holder){
            equips[eq.t.ordinal()] = eq;
            return;
        }
        if(equips[eq.t.ordinal()] != null){
            inventory.add(equips[eq.t.ordinal()]);
            equips[eq.t.ordinal()] = eq;
            return;
        }
    }
    public Equipment[] getEquips(){
        return equips;
    }
}
