package ru.nsu.ccfit.Prokhorov.lab2.core.time;

import java.util.List;
import java.util.Vector;

public class Timeline {

    public List<Event> subscribes;
    public List<Effect> subsEffects;

    public Timeline(){
        subscribes = new Vector<Event>();
        subsEffects = new Vector<Effect>();
    }

    public void updateAll(){
        for (Event ev: subsEffects) {
            ev.update();
        }
        List<Effect> del = new Vector<Effect>();
        for (Effect ev: subsEffects) {
            if(ev.isFinished()){
                del.add(ev);
            }
        }
        subsEffects.removeAll(del);
    }
}
