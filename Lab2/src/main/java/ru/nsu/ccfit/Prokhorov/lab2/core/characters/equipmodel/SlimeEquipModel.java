package ru.nsu.ccfit.Prokhorov.lab2.core.characters.equipmodel;

import ru.nsu.ccfit.Prokhorov.lab2.core.items.Equipment;
import ru.nsu.ccfit.Prokhorov.lab2.core.items.Holder;

public class SlimeEquipModel extends EquipModel{

    public SlimeEquipModel(){
        super();
        equips[Equipment.type.TRASH.ordinal()] = new Holder();
    }
}
