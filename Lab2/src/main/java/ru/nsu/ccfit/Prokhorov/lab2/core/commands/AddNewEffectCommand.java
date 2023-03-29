package ru.nsu.ccfit.Prokhorov.lab2.core.commands;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.factories.EffectFactory;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Effect;

public class AddNewEffectCommand extends Command{

    private Core core;
    private Creature caster;
    private Creature aim;
    private String effectID;
    private int time;

    public AddNewEffectCommand(Core core, Creature caster, Creature aim, String effectID){
        super(null);
        this.core = core;
        this.caster = caster;
        this.aim = aim;
        this.effectID = effectID;
    }


    @Override
    public void exec() {
        EffectFactory factory = new EffectFactory();
        Effect eff = new EffectFactory().generateEffect(effectID, caster, aim);
        this.core.addEffectToTimeLine(eff);
    }
}
