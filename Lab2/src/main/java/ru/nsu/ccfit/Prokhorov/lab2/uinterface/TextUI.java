package ru.nsu.ccfit.Prokhorov.lab2.uinterface;

import ru.nsu.ccfit.Prokhorov.lab2.core.field.Field;
import ru.nsu.ccfit.Prokhorov.lab2.core.field.MasksForOutput;

import java.io.IOException;

import static java.lang.System.out;

public class TextUI {

    private Field fd;
    public TextUI(){
        fd = new Field();
    }

    public void start(){
        drawRoom();
    }

    public void drawRoom(){
        int[][] fi = fd.getCurrRoom().getTileMask();
        int h = fd.getCurrRoom().getHeight(), w = fd.getCurrRoom().getWidth();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                switch(fi[i][j]){
                    case MasksForOutput.EARTH:
                        out.print("#");
                        break;
                    case MasksForOutput.SPACE:
                        out.print(" ");
                        break;
                    case MasksForOutput.HERO:
                        out.print("@");
                        break;
                    case MasksForOutput.THINGS:
                        System.out.print(".");
                        break;
                }
            }
            System.out.print("\n");
        }
    }
}
