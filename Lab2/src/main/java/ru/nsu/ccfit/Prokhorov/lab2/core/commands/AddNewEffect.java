package ru.nsu.ccfit.Prokhorov.lab2.core.commands;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Effect;

public class AddNewEffect extends Command{

    private Core core;
    private Character caster;
    private Character aim;
    private String effectID;
    private int time;

    public AddNewEffect(Core core, Character caster, Character aim, String effectID){
        super(null);
        this.core = core;
        this.caster = caster;
        this.aim = aim;
        this.effectID = effectID;
        this.time = time;
    }


    @Override
    public void exec() {
        this.core.addEffectToTimeLine(null);
    }
}
