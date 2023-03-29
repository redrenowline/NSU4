package ru.nsu.ccfit.Prokhorov.lab2.uinterface;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.MasksForOutput;
import ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets.GameUI;
import ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets.MainWidget;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class GUI {
    private GameUI game;

    public GUI(){
        game = new GameUI();
    }

}
