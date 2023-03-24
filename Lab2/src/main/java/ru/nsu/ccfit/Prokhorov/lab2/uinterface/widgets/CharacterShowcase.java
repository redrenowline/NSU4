package ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets;

import javax.swing.*;
import java.awt.*;

public class CharacterShowcase extends JFrame {

    private JLabel name;
    private JList<JLabel> chars;
    public CharacterShowcase(){
        super();
        name.setText("Hero");
    }

    @Override
    public void setBounds(Rectangle r) {
        super.setBounds(r);
        name.setBounds(r.x, r.y, r.width, 20);
        chars.setBounds(r.x, r.y + 25, r.width, r.height - 25);
    }
}
