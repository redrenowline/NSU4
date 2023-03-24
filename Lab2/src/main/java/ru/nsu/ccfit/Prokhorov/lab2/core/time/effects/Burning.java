package ru.nsu.ccfit.Prokhorov.lab2.core.time.effects;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Effect;
import ru.nsu.ccfit.Prokhorov.lab2.core.utility.DamageCalculator;

public class Burning extends Effect {
    public Burning(Creature caster, Creature host, long time) {
        super(caster, host, time);
    }

    public Burning(Creature caster, Creature host) {
        super(caster, host);
    }

    @Override
    public void addEffect() {

    }

    @Override
    public void update() {
        super.update();
        DamageCalculator.dealDamage(host, caster, DamageCalculator.damagetype.FIRE, Creature.characteristicsTypes.INTELLIGENCE);
    }

    @Override
    public void removeEffect() {

    }
}
