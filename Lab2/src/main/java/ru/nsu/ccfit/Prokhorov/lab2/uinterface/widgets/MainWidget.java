package ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets;

import ru.nsu.ccfit.Prokhorov.lab2.core.field.MasksForOutput;

import javax.swing.*;
import java.awt.*;

public class MainWidget extends JPanel
{
    TexturePaint pSpace, pEarth, pUnseen, pHero;

    private int[][] mask;

    public MainWidget(int[][] mask){
        super();
        pSpace = new TexturePaint(TexturesLoader.loadImage(TextureLoaderConfig.space_texture_path), new Rectangle(0,0,32,32));
        pEarth = new TexturePaint(TexturesLoader.loadImage(TextureLoaderConfig.earth_texture_path), new Rectangle(0,0,32,32));
        pUnseen = new TexturePaint(TexturesLoader.loadImage(TextureLoaderConfig.unseen_texture_path), new Rectangle(0,0,32,32));
        pHero = new TexturePaint(TexturesLoader.loadImage(TextureLoaderConfig.hero_texture_path), new Rectangle(0,0,32,32));
        this.mask = mask;
    }

    public void updateField(int[][] mask){
        this.mask = mask;
        this.repaint();
    }

    public void drawComponents(Graphics2D g2d){
        for(int i = 0; i < mask.length; i++){
            for(int j = 0; j < mask[i].length; j++){
                g2d.setPaint(pEarth);
                g2d.fillRect(this.getX() + (i)*32,this.getY() + (j)*32,this.getX() + (i+1)*32,this.getY() + (j+1)*32);
                switch(mask[i][j]){
                    case MasksForOutput.SPACE:
                        g2d.setPaint(pSpace);
                        break;
                    case MasksForOutput.EARTH:
                        g2d.setPaint(pEarth);
                        break;
                        case MasksForOutput.UNSEEN:
                            g2d.setPaint(pUnseen);
                            break;
                    case MasksForOutput.HERO:
                        g2d.setPaint(pHero);
                        break;
                    default:
                        g2d.setPaint(pEarth);
                        break;
                }
                g2d.fillRect((i)*32,(j)*32,(i+1)*32,(j+1)*32);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawComponents(g2d);
    }
}
