package ru.nsu.ccfit.Prokhorov.lab2.core.items;

import ru.nsu.ccfit.Prokhorov.lab2.core.items.property.Property;

import java.util.List;
import java.util.Vector;

public class Equipment extends GameItem{

    public enum type{ TRASH, MAINHAND, OFFHAND, ARMOR, LEGS, RING, NECKLACE, HELMET, WINGS, GALO, FLAG};
    private List<Property> properties;
    public type t;
    public Equipment(String id) {
        super(id);
        properties = new Vector<Property>();
        t = type.TRASH;
    }

    public List<Property> getProperties(){
        return properties;
    }

    public void addProperty(Property prop){
        this.properties.add(prop);
    }

}
