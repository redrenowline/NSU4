package ru.nsu.ccfit.Prokhorov.lab2.core.characters;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.equipmodel.EquipModel;

public abstract class Creature {

    public enum characteristicsTypes{
        LIFE, LIFEREGEN, LIFERESTORAGE, STRENGTH, AGILITY, VITALITY, FIRERESISTANCE, FROSTRESISTANCE, LIGHTINGRESISTANCE, DARKRESISTANCE, WISDOM, INTELLIGENCE, CHARISM, FIREPENETRATION, FROSTPENETRATION, LIGHTINGPENETRATION
    }
    protected String id;
    protected EquipModel equipModel;
    protected Double[] characteristics;
    public Creature(String id){
        this.id = id;
        this.characteristics = new Double[characteristicsTypes.values().length];
        for(int i = 0; i < characteristicsTypes.values().length; i++){
            this.characteristics[i] = Double.valueOf(0);
        }
    }
    public EquipModel getEquipmentModel(){
        return equipModel;
    }
    public void setCharacteristic(characteristicsTypes type, Double value){
        characteristics[type.ordinal()] = value;
    }
    public Double getCharacteristic(characteristicsTypes type){
        return characteristics[type.ordinal()];
    }
}
