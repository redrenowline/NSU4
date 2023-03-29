package ru.nsu.ccfit.Prokhorov.lab2.core.commands;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.utility.AccuracyCalculator;
import ru.nsu.ccfit.Prokhorov.lab2.core.utility.DamageCalculator;

public class MoveCreatureCommand extends Command {

    private Creature host;
    private int x,y, x0, y0;

    public MoveCreatureCommand(Core core, Creature creature,int x0, int y0, int x, int y){
        super(core);
        this.host = creature;
        this.x = x;
        this.y = y;
        this.x0 = x0;
        this.y0 = y0;
    }

    @Override
    public void exec() {
        if(core.getCurrField().getCurrRoom().getTile(x,y).getCharacter() != null){
            if(AccuracyCalculator.calcHit(host,core.getCurrField().getCurrRoom().getTile(x,y).getCharacter())){
                DamageCalculator.dealDamage(core.getCurrField().getCurrRoom().getTile(x,y).getCharacter(), host, DamageCalculator.damagetype.PHYS, Creature.characteristicsTypes.STRENGTH);
                if(core.getCurrField().getCurrRoom().getTile(x,y).getCharacter().getCharacteristic(Creature.characteristicsTypes.LIFE) < 0 ){
                    core.getCurrField().getCurrRoom().getTile(x0,y0).setCharacter(null);
                    core.getCurrField().getCurrRoom().getTile(x,y).setCharacter(host);
                }
            }
        }else{
            core.getCurrField().getCurrRoom().getTile(x0,y0).setCharacter(null);
            core.getCurrField().getCurrRoom().getTile(x,y).setCharacter(host);
        }
    }
}
