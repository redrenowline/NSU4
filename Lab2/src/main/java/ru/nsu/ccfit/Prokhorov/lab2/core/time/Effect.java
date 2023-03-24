package ru.nsu.ccfit.Prokhorov.lab2.core.time;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;

public abstract class Effect extends Event {

    protected Creature caster;
    protected Creature host;

    public Effect(Creature caster, Creature host, long time) {
        super(time);
        this.host = host;
        this.caster = caster;
    }

    public Effect(Creature caster, Creature host){
        super();
        this.host = host;
        this.caster = caster;
    }

    public abstract void addEffect();
    public abstract void removeEffect();

}
