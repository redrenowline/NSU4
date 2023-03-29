package ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets;

import org.w3c.dom.css.Rect;
import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.MasksForOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GameUI extends JFrame {

    GridBagLayout layout;
    private Core core;
    private MainWidget mn;
    private JLabel name;

    private Font font;

    private Rectangle borderMN;
    private Rectangle borderName;
    public GameUI(Core core){
        this.core = core;
        initMyself();
    }
    public GameUI(){
        this.core = new Core();
        initMyself();
    }

    private void initMyself(){
        getContentPane().setBackground( Color.white );
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);

        font = new Font("TimesRoman", Font.CENTER_BASELINE, 16);

        mn = new MainWidget(core.currField.getCurrRoom().getTileMask());
        borderMN = new Rectangle (5,5,(MasksForOutput.ALIGHTOP + MasksForOutput.ALIGNBOTTOM + 1)*32,(MasksForOutput.ALIGNRIGHT+ MasksForOutput.ALIGNLEFT+ 1)*32);
        mn.setBounds(borderMN);
        add(mn);
        mn.repaint();

        name = new JLabel();
        borderName = new Rectangle(borderMN.y + borderMN.height + 50, 10, 100,20);
        name.setBounds(borderName);
        name.setText("Hero name");
        name.setFont(font);

        add(name);
        name.repaint();
        setVisible(true);
    }
}
