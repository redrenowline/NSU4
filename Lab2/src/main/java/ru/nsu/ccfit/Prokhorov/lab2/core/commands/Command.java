package ru.nsu.ccfit.Prokhorov.lab2.core.commands;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;

public abstract class Command {

    protected Core core;
    public Command(Core core){
        this.core = core;
    }

    public abstract void exec();
}
