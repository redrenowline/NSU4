package ru.nsu.ccfit.Prokhorov.lab2.ui.widgets;

import ru.nsu.ccfit.Prokhorov.lab2.model.CellConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class FieldWidget extends JPanel {

    private int compHeight = 10;
    private int  compWidth = 10;
    private byte[][] matrix;
    private TexturePaint mineTexturePaint;
    private TexturePaint fogTexturePaint;
    private TexturePaint spaceTexturePaint;
    private TexturePaint flagTexturePoint;
    private TexturePaint[] numbersTexturePaint;
    public final String fogTexturePath = "build/resources/main/textures/fog.png";
    public final String spaceTexturePath="build/resources/main/textures/space.png";
    public final String flagTexturePath = "build/resources/main/textures/flag.png";
    public final String oneTexturePath = "build/resources/main/textures/one.png";
    public final String twoTexturePath = "build/resources/main/textures/two.png";
    public final String threeTexturePath = "build/resources/main/textures/three.png";

    public final String fourTexturePath = "build/resources/main/textures/four.png";

    public final String fiveTexturePath = "build/resources/main/textures/five.png";

    public final String sixTexturePath = "build/resources/main/textures/six.png";
    public final String sevenTexturePath = "build/resources/main/textures/six.png";
    public final String eightTexturePath = "build/resources/main/textures/six.png";
    public final String nineTexturePath = "build/resources/main/textures/six.png";

    public FieldWidget(byte[][] matrix){
        super();
        numbersTexturePaint = new TexturePaint[10];
        loadTextures();
        updateField(matrix);
    }

    private void loadTextures(){
        try {
            File fl = new File(fogTexturePath);
            System.out.println(fl.getAbsolutePath());
            BufferedImage tmpImage = ImageIO.read(new File(fogTexturePath));
            fogTexturePaint = new TexturePaint(tmpImage, new Rectangle(0,0, compWidth, compHeight));
            tmpImage = ImageIO.read(new File(spaceTexturePath));
            numbersTexturePaint[0] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(oneTexturePath));
            numbersTexturePaint[1] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(twoTexturePath));
            numbersTexturePaint[2] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(threeTexturePath));
            numbersTexturePaint[3] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(fourTexturePath));
            numbersTexturePaint[4] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(fiveTexturePath));
            numbersTexturePaint[5] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(sixTexturePath));
            numbersTexturePaint[6] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(sevenTexturePath));
            numbersTexturePaint[7] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(eightTexturePath));
            numbersTexturePaint[8] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(nineTexturePath));
            numbersTexturePaint[9] = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
            tmpImage = ImageIO.read(new File(flagTexturePath));
            flagTexturePoint = new TexturePaint(tmpImage, new Rectangle(0,0,compWidth, compHeight));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateField(byte[][] matrix){
        this.matrix = matrix;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[matrix.length - 1].length; j++){
                TexturePaint tmpTexturePaint;
                switch(matrix[i][j]){
                    case CellConstants.FOG_CELL:
                        tmpTexturePaint = fogTexturePaint;
                        break;
                    case CellConstants.MINE_CELL:
                        tmpTexturePaint = mineTexturePaint;
                        break;
                    case CellConstants.FLAG_CELL:
                        tmpTexturePaint = flagTexturePoint;
                        break;
                    default:
                        tmpTexturePaint = numbersTexturePaint[matrix[i][j]];
                        break;
                }
                graphics2D.setPaint(tmpTexturePaint);
                graphics2D.fillRect(i * compHeight, j * compWidth, compHeight, compWidth);
            }
        }
    }

    public int getCompHeight(){
        return compHeight;
    }

    public int getCompWidth(){
        return compWidth;
    }
}
