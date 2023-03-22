package ru.nsu.ccfit.Prokhorov.lab2.uinterface;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets.MainWidget;

import javax.swing.*;

public class GUI {

    Core core;

    public GUI(){
        core = new Core();
        JFrame f = new JFrame("example");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);
        f.setVisible(true);
        MainWidget mn = new MainWidget();
//        mn.initTextures();
//        mn.redrawWithMask(core.currFloor.getCurrRoom().getTileMask());
        mn.setBounds(0,0,800,800);
        f.getContentPane().add(mn);
    }
}
