package ru.nsu.ccfit.Prokhorov.lab2.core.commands;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;

public class ChangeViewCommand extends Command{

    private int xAxis,yAxis;
    public ChangeViewCommand(Core core, int xAxis, int yAxis){
        super(core);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
    @Override
    public void exec() {

    }
}
