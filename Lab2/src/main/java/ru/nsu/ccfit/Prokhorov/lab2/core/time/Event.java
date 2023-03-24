package ru.nsu.ccfit.Prokhorov.lab2.core.time;

public abstract class Event {

    private long time;
    private boolean infinite;
    private boolean active;
    private boolean finished;
    public Event(long time){
        this.time = time;
        this.finished = false;
        this.active = true;
        this.infinite = false;
    }

    public Event(){
        this.time = time;
        this.finished = false;
        this.active = true;
        this.infinite = true;
    }

    public void stop(){
        this.active = false;
    }

    public void cont(){
        this.active = true;
    }

    public boolean isFinished(){
        return this.finished;
    }
    public boolean isActive(){
        return this.active;
    }
    public boolean isInfinite(){
        return this.active;
    }

    public void update(){
        if(!infinite) this.time--;
        if(this.time == 0){
            this.finished = true;
            this.active = false;
        }
    }
}
