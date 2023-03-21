package ru.nsu.ccfit.Prokhorov.lab2.core.characters.equipmodel;

import ru.nsu.ccfit.Prokhorov.lab2.core.items.Equipment;
import ru.nsu.ccfit.Prokhorov.lab2.core.items.Holder;

public class HumanEquipModel extends EquipModel{

    public HumanEquipModel(){
        super();
        equips[Equipment.type.MAINHAND.ordinal()] = new Holder();
        equips[Equipment.type.OFFHAND.ordinal()] = new Holder();
        equips[Equipment.type.ARMOR.ordinal()] = new Holder();
        equips[Equipment.type.LEGS.ordinal()] = new Holder();
        equips[Equipment.type.HELMET.ordinal()] = new Holder();
    }
}
