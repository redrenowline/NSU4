package ru.nsu.ccfit.Prokhorov.lab2.core.time;

import java.util.List;
import java.util.Vector;

public class Timeline {

    public List<Event> subscribes;

    public Timeline(){
        subscribes = new Vector<Event>();
    }

    public void updateAll(){
        int n = subscribes.size();
        for (Event ev: subscribes) {
            ev.update();
        }
        for (Event ev: subscribes) {
            if(ev.isFinished()){
                subscribes.remove(ev);
            }
        }
    }
}
