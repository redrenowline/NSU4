package ru.nsu.ccfit.Prokhorov.lab2.core.utility;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;

public class DamageCalculator {
    public enum damagetype{
        PHYS, FIRE, LIGHT, FROST
    };
    public static void dealDamage(Creature aim, Creature source, damagetype t, Creature.characteristicsTypes s){
        Double tmpHealth = aim.getCharacteristic(Creature.characteristicsTypes.LIFE);
        Double tmpResistance;
        Double tmpTrueDamage;
        Double tmpPenetration;
        switch(t){
            case FIRE:
                tmpResistance = aim.getCharacteristic(Creature.characteristicsTypes.FIRERESISTANCE);
                tmpPenetration = aim.getCharacteristic(Creature.characteristicsTypes.FIREPENETRATION);
                tmpTrueDamage = source.getCharacteristic(s) / 2;
            break;
            case FROST:
                tmpResistance = aim.getCharacteristic(Creature.characteristicsTypes.FROSTRESISTANCE);
                tmpPenetration = aim.getCharacteristic(Creature.characteristicsTypes.FROSTPENETRATION);
                tmpTrueDamage = source.getCharacteristic(s) / 2;
                break;
            case LIGHT:
                tmpResistance = aim.getCharacteristic(Creature.characteristicsTypes.LIGHTINGRESISTANCE);
                tmpPenetration = aim.getCharacteristic(Creature.characteristicsTypes.LIGHTINGPENETRATION);
                tmpTrueDamage = source.getCharacteristic(s) / 2;
                break;
            default:
                tmpResistance = (double) 0;
                tmpPenetration = (double) 0;
                tmpTrueDamage = source.getCharacteristic(s);
                break;
        }
        tmpHealth -= (1 - (tmpResistance - tmpPenetration)/100) * tmpTrueDamage;
        aim.setCharacteristic(Creature.characteristicsTypes.LIFE, tmpHealth);
    }
}
