package ru.nsu.ccfit.Prokhorov.lab2.uinterface.widgets;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TexturesLoader {

    public static BufferedImage loadImage(String path) {
        BufferedImage res = null;
        try {
            res = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
