package ru.nsu.ccfit.Prokhorov.lab2.uinterface;

import org.w3c.dom.css.Rect;
import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.MasksForOutput;
import ru.nsu.ccfit.Prokhorov.lab2.uinterface.control.KeyListenerController;
import ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets.MainWidget;
import ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets.PlayerShowcase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class GameUI extends JFrame {

    private Core core;
    private MainWidget mn;
    private Rectangle borderMN;
    private Rectangle borderName;
    public GameUI(Core core){
        this.core = core;
        initMyself();
    }
    public GameUI(){
        this.core = new Core();
        initMyself();
        this.addKeyListener(new KeyListenerController(core));
        ActionListener flashOFF = new ActionListener(){
            public void actionPerformed(ActionEvent arg0) { renewInfo(); } };
        Runnable task = new Runnable() {
            public void run() {
                Timer timer = new Timer(100, flashOFF);
                timer.start();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    public void cycle(){

    }

    public void renewInfo(){
        mn.updateField(core.getCurrField().getCurrRoom().getTileMask());
    }

    private void initMyself(){
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        getContentPane().setBackground( Color.black );
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);

        mn = new MainWidget(core.currField.getCurrRoom().getTileMask());
        borderMN = new Rectangle (300,5,(MasksForOutput.ALIGHTOP + MasksForOutput.ALIGNBOTTOM + 1)*32,(MasksForOutput.ALIGNRIGHT+ MasksForOutput.ALIGNLEFT+ 1)*32);
        mn.setBounds(borderMN);
        add(mn);
        mn.repaint();

        PlayerShowcase pl = new PlayerShowcase();
        pl.update(core.player.getCharacteristics());
        borderName = new Rectangle(0, 0,300,675);
        pl.setBounds(borderName);
        add(pl);
        pl.repaint();

        setVisible(true);
        repaint();
    }
}
