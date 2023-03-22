package ru.nsu.ccfit.Prokhorov.lab2.uinterface;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.MasksForOutput;
import ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets.MainWidget;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class GUI {

    Core core;

    public GUI(){
        core = new Core();
        JFrame f = new JFrame("example");
        f.getContentPane().setBackground( Color.black );
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);
        f.setVisible(true);
        MainWidget mn = new MainWidget(core.currFloor.getCurrRoom().getTileMask());
        mn.setBounds(10,10, (MasksForOutput.ALIGHTOP + MasksForOutput.ALIGNBOTTOM + 1)*32,(MasksForOutput.ALIGHTOP + MasksForOutput.ALIGNBOTTOM + 1)*32);
        f.add(mn);
        mn.repaint();
    }
}
