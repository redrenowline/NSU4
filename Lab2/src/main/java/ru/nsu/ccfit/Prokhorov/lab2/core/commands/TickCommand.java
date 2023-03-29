package ru.nsu.ccfit.Prokhorov.lab2.core.commands;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;

public class TickCommand extends Command{
    public TickCommand(Core core) {
        super(core);
    }

    @Override
    public void exec() {
        core.getTimeline().updateAll();
    }
}
