package ru.nsu.ccfit.Prokhorov.lab2;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;
import ru.nsu.ccfit.Prokhorov.lab2.core.commands.AddNewEffectCommand;
import ru.nsu.ccfit.Prokhorov.lab2.core.commands.MoveCreatureCommand;
import ru.nsu.ccfit.Prokhorov.lab2.core.commands.TickCommand;
import ru.nsu.ccfit.Prokhorov.lab2.library.races.Human;
import ru.nsu.ccfit.Prokhorov.lab2.library.races.Ork;
import ru.nsu.ccfit.Prokhorov.lab2.uinterface.GUI;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        System.out.println("Hello world!");
    }
}