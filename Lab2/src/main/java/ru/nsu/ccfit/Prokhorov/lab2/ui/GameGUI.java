package ru.nsu.ccfit.Prokhorov.lab2.ui;

import ru.nsu.ccfit.Prokhorov.lab2.ui.widgets.FieldWidget;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameGUI extends JFrame {

    private Locale locale;
    private ResourceBundle resourceBundle;

    private FieldWidget fieldWidget;
    private JLabel countMinesLabel;
    private JLabel flagsCountLabel;
    private int mineCount = 0;

    private final Rectangle frameSize = new Rectangle(100,100,600,500);
    private final Rectangle fieldWidgetSize =  new Rectangle(5,25,595,430);
    private final Rectangle  countMineLabelSize = new Rectangle(5,5,150,20);
    private final Rectangle flagsCountLabelSize = new Rectangle(155,5,100,20);

    public GameGUI(Locale locale, byte[][] matrix, int mineCount){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(UIResourcesNames.BUNDLE_NAME, this.locale);
        this.mineCount = mineCount;
        setBounds(frameSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        identFieldWidget(matrix);
        identCountMinesLabel();
        identFlagsCountLabel();
    }

    public void st(){
        this.setVisible(true);
        this.setEnabled(true);
        repaint();
    }
    public void fn(){
        this.setVisible(false);
        this.setEnabled(false);
    }
    public void identFieldWidget(byte[][] matrix){
        fieldWidget = new FieldWidget(matrix);
        fieldWidget.setBounds(fieldWidgetSize);
        fieldWidget.updateField(matrix);
        add(fieldWidget);
        fieldWidget.repaint();
    }

    public void identCountMinesLabel(){
        countMinesLabel = new JLabel();
        countMinesLabel.setBounds(countMineLabelSize);
        countMinesLabel.setText(resourceBundle.getString(UIResourcesNames.GAME_MINE_COUNT_PREFIX) + String.valueOf(mineCount));
        add(countMinesLabel);
    }

    public void identFlagsCountLabel(){
        flagsCountLabel = new JLabel();
        flagsCountLabel.setBounds(flagsCountLabelSize);
        add(flagsCountLabel);
    }
    public FieldWidget getField(){
        return fieldWidget;
    }

    public void updateField(byte[][] matrix, int flagsCount){
        fieldWidget.updateField(matrix);
        flagsCountLabel.setText(resourceBundle.getString(UIResourcesNames.GAME_FLAGS_COUNT_LABEL_PREFIX) + String.valueOf(flagsCount));
    }

    public void enableField(){
        fieldWidget.setEnabled(true);
    }

    public void disableField(){
        fieldWidget.setEnabled(false);
    }


}
