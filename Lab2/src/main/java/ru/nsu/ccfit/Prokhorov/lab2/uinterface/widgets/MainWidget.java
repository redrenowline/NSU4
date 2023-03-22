package ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets;

import ru.nsu.ccfit.Prokhorov.lab2.core.field.MasksForOutput;

import javax.swing.*;
import java.awt.*;

public class MainWidget extends JPanel
{
    TexturePaint pEarth;
    TexturePaint pWall;

    int[][] mask;

    public MainWidget(int[][] mask){
        pEarth = new TexturePaint(TexturesLoader.loadImage(TextureLoaderConfig.earth_texture_path), new Rectangle(0,0,32,32));
        pWall = new TexturePaint(TexturesLoader.loadImage(TextureLoaderConfig.wall_texture_path), new Rectangle(0,0,32,32));
        this.mask = mask;
    }

    public void drawComponents(Graphics2D g2d){
        for(int i = 0; i < mask.length; i++){
            for(int j = 0; j < mask[i].length; j++){
                switch(mask[i][j]){
                    case MasksForOutput.SPACE:
                        g2d.setPaint(pEarth);
                        g2d.fillRect((i)*32,(j)*32,(i+1)*32,(j+1)*32);
                        break;
                    case MasksForOutput.EARTH:
                        g2d.setPaint(pWall);
                        g2d.fillRect((i)*32,(j)*32,(i+1)*32,(j+1)*32);
                        break;
                    default:
                        g2d.setPaint(pEarth);
                        g2d.fillRect((i)*32,(j)*32,(i+1)*32,(j+1)*32);
                        break;
                }
            }
        }
        System.out.print("Tututuutu");
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        System.out.print("We start drawing\n");
        Graphics2D g2d = (Graphics2D) g;
        drawComponents(g2d);
    }
}
