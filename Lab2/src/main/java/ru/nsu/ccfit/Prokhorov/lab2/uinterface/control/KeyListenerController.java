package ru.nsu.ccfit.Prokhorov.lab2.uinterface.control;

import ru.nsu.ccfit.Prokhorov.lab2.core.Core;
import ru.nsu.ccfit.Prokhorov.lab2.core.commands.MoveCreatureCommand;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerController implements KeyListener {

    public Core core;

    public KeyListenerController(Core core){
        this.core = core;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'w'){
            core.player.moveCharacter(0, -1);
        }
        if(e.getKeyChar() == 'd'){
            core.player.moveCharacter(1,0);
        }
    }
}
