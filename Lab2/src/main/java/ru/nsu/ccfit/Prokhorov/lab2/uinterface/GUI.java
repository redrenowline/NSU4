package ru.nsu.ccfit.Prokhorov.lab2.uinterface;

import javax.swing.*;

public class GUI {

    public GUI(){
        JFrame f = new JFrame("example");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);
        f.setVisible(true);
    }
}
