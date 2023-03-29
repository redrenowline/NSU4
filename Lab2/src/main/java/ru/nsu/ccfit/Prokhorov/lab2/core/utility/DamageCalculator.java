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
        Double tmprandDamage;
        switch(t){
            case FIRE:
                tmprandDamage = (int)(Math.random() % (aim.getCharacteristic(Creature.characteristicsTypes.MAXFIREDAMAGE)) - aim.getCharacteristic(Creature.characteristicsTypes.MINFIREDAMAGE)) + aim.getCharacteristic(Creature.characteristicsTypes.MINFIREDAMAGE);
                tmpResistance = aim.getCharacteristic(Creature.characteristicsTypes.FIRERESISTANCE);
                tmpPenetration = aim.getCharacteristic(Creature.characteristicsTypes.FIREPENETRATION);
                tmpTrueDamage = source.getCharacteristic(s) / 2 + tmprandDamage;
            break;
            case FROST:
                tmprandDamage = (int)(Math.random() % (aim.getCharacteristic(Creature.characteristicsTypes.MAXFROSTDAMAGE)) - aim.getCharacteristic(Creature.characteristicsTypes.MINFROSTDAMAGE)) + aim.getCharacteristic(Creature.characteristicsTypes.MINFROSTDAMAGE);
                tmpResistance = aim.getCharacteristic(Creature.characteristicsTypes.FROSTRESISTANCE);
                tmpPenetration = aim.getCharacteristic(Creature.characteristicsTypes.FROSTPENETRATION);
                tmpTrueDamage = source.getCharacteristic(s) / 2 + tmprandDamage;
                break;
            case LIGHT:
                tmprandDamage = (int)(Math.random() % (aim.getCharacteristic(Creature.characteristicsTypes.MAXLIGHTINGDAMAGE)) - aim.getCharacteristic(Creature.characteristicsTypes.MINLIGHTINGDAMAGE)) + aim.getCharacteristic(Creature.characteristicsTypes.MINLIGHTINGDAMAGE);
                tmpResistance = aim.getCharacteristic(Creature.characteristicsTypes.LIGHTINGRESISTANCE);
                tmpPenetration = aim.getCharacteristic(Creature.characteristicsTypes.LIGHTINGPENETRATION);
                tmpTrueDamage = source.getCharacteristic(s) / 2 + tmprandDamage;
                break;
            default:
                tmprandDamage = (int)(Math.random() % (aim.getCharacteristic(Creature.characteristicsTypes.MAXDAMAGE)) - aim.getCharacteristic(Creature.characteristicsTypes.MINDAMAGE)) + aim.getCharacteristic(Creature.characteristicsTypes.MINDAMAGE);
                tmpResistance = (double) 0;
                tmpPenetration = (double) 0;
                tmpTrueDamage = source.getCharacteristic(s) + tmprandDamage;
                break;
        }
        tmpHealth -= (1 - (tmpResistance - tmpPenetration)/100) * tmpTrueDamage;
        aim.setCharacteristic(Creature.characteristicsTypes.LIFE, tmpHealth);
    }
}
