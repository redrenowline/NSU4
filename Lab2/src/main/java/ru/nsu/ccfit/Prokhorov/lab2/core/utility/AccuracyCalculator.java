package ru.nsu.ccfit.Prokhorov.lab2.core.utility;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;

public class AccuracyCalculator {
    public static boolean calcHit(Creature caster, Creature host){
        int randCaster = (int) (Math.random() % 20);
        int randHost = (int) (Math.random() % 20);
        int evasion = 10 + (int) (host.getCharacteristic(Creature.characteristicsTypes.AGILITY) + host.getCharacteristic(Creature.characteristicsTypes.ARMOR));
        int acc = (int) (caster.getCharacteristic(Creature.characteristicsTypes.STRENGTH) + caster.getCharacteristic(Creature.characteristicsTypes.ACCURACY));
        if(evasion + randHost >= acc + randCaster){
            return true;
        }
        return false;
    }

}
