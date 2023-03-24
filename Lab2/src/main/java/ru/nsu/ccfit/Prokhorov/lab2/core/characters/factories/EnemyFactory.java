package ru.nsu.ccfit.Prokhorov.lab2.core.characters.factories;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class EnemyFactory {
    private Properties races;

    public EnemyFactory(){
        InputStream stream = EnemyFactory.class.getResourceAsStream("races.properties");
        races = new Properties();
        try {
            races.load(stream);
            System.out.println("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Creature GenerateEnemy(String key) throws ClassNotFoundException {
        String[] parsed = key.split(" ");
        Class<? extends Creature> cl = (Class<? extends Creature>) Class.forName(races.getProperty(parsed[0]));
        Constructor<? extends Creature> constructor;
        try {
            constructor = cl.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Creature cr = null;
        try {
            cr = (Creature) constructor.newInstance("0");
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return cr;
    }

}
