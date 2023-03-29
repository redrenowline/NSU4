package ru.nsu.ccfit.Prokhorov.lab2.library.races;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.equipmodel.HumanEquipModel;

public class Ork extends Creature {

    public Ork(String id) {
        super(id);
        equipModel = new HumanEquipModel();
    }
}
