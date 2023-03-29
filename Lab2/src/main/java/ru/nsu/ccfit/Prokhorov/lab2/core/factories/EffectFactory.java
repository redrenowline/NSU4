package ru.nsu.ccfit.Prokhorov.lab2.core.factories;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.factories.EnemyFactory;
import ru.nsu.ccfit.Prokhorov.lab2.core.time.Effect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class EffectFactory {

    private Properties effects;

    public EffectFactory(){
        InputStream stream = EffectFactory.class.getResourceAsStream("/properties/effectsByID.properties");
        effects = new Properties();
        try {
            effects.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Effect generateEffect(String id, Creature caster, Creature host){
        Class<? extends Effect> cl = null;
        try {
            cl = (Class<? extends Effect>) Class.forName(effects.getProperty(id));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Constructor<? extends Effect> constructor;
        try {
            constructor = cl.getConstructor(Creature.class, Creature.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Effect eff = null;
        try {
            eff = (Effect) constructor.newInstance(caster, host);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return eff;
    }
}
