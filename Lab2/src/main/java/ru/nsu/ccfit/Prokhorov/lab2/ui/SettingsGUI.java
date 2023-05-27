package ru.nsu.ccfit.Prokhorov.lab2.ui;

import ru.nsu.ccfit.Prokhorov.lab2.exceptions.WrongEnterDataException;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class SettingsGUI extends JFrame {

    private Locale locale;
    private ResourceBundle resourceBundle;

    private JLabel fieldSizeLabel;
    private JTextField heightField, widthField;
    private JLabel mineCountLabel;
    private JTextField mineCountField;
    private JButton startGameButton;
    private final JPanel panel;
    private final Rectangle frameSize = new Rectangle(100,100,210,150);
    private final Rectangle fieldSizeLabelSize = new Rectangle(5,5,205,20);
    private final Rectangle heightFieldSize = new Rectangle(5,25, 100,20);
    private final Rectangle widthFieldSize = new Rectangle(105,25,100,20);
    private final Rectangle mineCountLabelSize = new Rectangle(5,45, 200,20);
    private final Rectangle mineCountFieldSize = new Rectangle(5,65,200,20);
    private Rectangle startGameButtonSize = new Rectangle(5,85,200,20);

    public SettingsGUI(Locale locale){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(UIResourcesNames.BUNDLE_NAME, locale);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        this.setBounds(frameSize);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        identFieldSizeLabel();
        identHeightField();
        identWidthField();
        identMineCountLabel();
        identMineCountField();
        identStartGameButton();
    }

    public void st(){
        this.setVisible(true);
        this.setEnabled(true);
    }

    public void fn(){
        this.setVisible(false);
        this.setEnabled(false);
    }

    public void identFieldSizeLabel(){
        fieldSizeLabel = new JLabel();
        fieldSizeLabel.setText(resourceBundle.getString(UIResourcesNames.SETTINGS_SIZE_LABEL));
        fieldSizeLabel.setBounds(fieldSizeLabelSize);
        panel.add(fieldSizeLabel);
    }

    public void identHeightField(){
        heightField = new JTextField();
        heightField.setBounds(heightFieldSize);
        heightField.setToolTipText(resourceBundle.getString(UIResourcesNames.SETTINGS_HEIGHT_SIZE_TEXTEDIT));
        panel.add(heightField);
    }
    public void identWidthField(){
        widthField = new JTextField();
        widthField.setBounds(widthFieldSize);
        widthField.setToolTipText(resourceBundle.getString(UIResourcesNames.SETTINGS_WIDTH_SIZE_TEXTEDIT));
        panel.add(widthField);
    }

    public void identMineCountLabel(){
        mineCountLabel = new JLabel();
        mineCountLabel.setBounds(mineCountLabelSize);
        mineCountLabel.setText(resourceBundle.getString(UIResourcesNames.SETTINGS_MINE_COUNT_LABEL));
        panel.add(mineCountLabel);
    }
    public void identMineCountField(){
        mineCountField = new JTextField();
        mineCountField.setBounds(mineCountFieldSize);
        panel.add(mineCountField);
    }

    public void identStartGameButton(){
        startGameButton = new JButton();
        startGameButton.setBounds(startGameButtonSize);
        startGameButton.setText(resourceBundle.getString(UIResourcesNames.MENU_START_BUTTON_TEXT));
        panel.add(startGameButton);
    }

    public JButton getStartGameButton(){
        return startGameButton;
    }

    public int getFieldsHeight(){
        try {
            int res = Integer.parseInt(heightField.getText());
            if(res <= 0) throw new Exception();
            return res;
        }catch(Exception e){
            throw new WrongEnterDataException();
        }
    }
    public int getFieldWidth(){
        try {
            int res = Integer.parseInt(widthField.getText());
            if(res <= 0) throw new Exception();
            return res;
        }catch(Exception e){
            throw new WrongEnterDataException();
        }
    }
    public int getMineCount(){
        try {
            int res = Integer.parseInt(mineCountField.getText());
            if(res <= 1) throw new Exception();
            return res;
        }catch(Exception e){
            throw new WrongEnterDataException();
        }
    }
}
