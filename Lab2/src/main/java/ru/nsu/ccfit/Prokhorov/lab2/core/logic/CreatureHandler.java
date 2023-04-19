package ru.nsu.ccfit.Prokhorov.lab2.core.logic;

import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.factories.EnemyFactory;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.Field;
import ru.nsu.ccfit.Prokhorov.lab2.core.utility.AccuracyCalculator;
import ru.nsu.ccfit.Prokhorov.lab2.core.utility.DamageCalculator;

public class CreatureHandler {

    private int x,y;
    private Creature body;
    private Field field;

    public CreatureHandler(Creature body,Field field, int x, int y){

    }

    CreatureHandler(String id,Field fd, int x, int y){
        EnemyFactory factory = new EnemyFactory();
        try {
            this.body = factory.GenerateEnemy(id);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void nextStep(){

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void moveCharacter(int dx,int dy){
        if(field.getCurrRoom().getTile(x,y).getCharacter() != null){
            if(AccuracyCalculator.calcHit(body,field.getCurrRoom().getTile(x + dx,y + dy).getCharacter())){
                DamageCalculator.dealDamage(field.getCurrRoom().getTile(x + dx,y + dy).getCharacter(), body, DamageCalculator.damagetype.PHYS, Creature.characteristicsTypes.STRENGTH);
                if(field.getCurrRoom().getTile(x + dx,y + dy).getCharacter().getCharacteristic(Creature.characteristicsTypes.LIFE) < 0 ){
                    field.getCurrRoom().getTile(x + dx,y + dy).setCharacter(null);
                    field.getCurrRoom().getTile(x + dx,y + dy).setCharacter(body);
                }
            }
        }else{
            field.getCurrRoom().getTile(x,y).setCharacter(null);
            field.getCurrRoom().getTile(x + dx,y + dy).setCharacter(body);
        }
    }
}
