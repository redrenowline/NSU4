package ru.nsu.ccfit.Prokhorov.lab2.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class MenuGUI extends JFrame {
    private Locale locale;
    private ResourceBundle resourceBundle;

    private JPanel panel;
    private JButton startGameButton;
    private JButton statisticsButton;
    private JButton exitButton;
    private Rectangle frameSize = new Rectangle(100,100,300,150);
    private Rectangle  startGameButtonSize = new Rectangle(5,5,290,30);
    private Rectangle  statisticsButtonSize = new Rectangle(5,40,290,30);
    private Rectangle  exitButtonSize = new Rectangle(5,75,290,30);

    public MenuGUI(Locale locale){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(UIResourcesNames.BUNDLE_NAME, locale);

        panel = new JPanel();
        panel.setLayout(null);
        this.setBounds(frameSize);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        identStartGameButton();
        identStatisticsButton();
        identExitButton();

    }

    public void st(){
        this.setVisible(true);
        this.setEnabled(true);
    }
    public void hd(){
        this.setVisible(false);
        this.setEnabled(false);
    }

    private void identStartGameButton(){
        startGameButton = new JButton();
        startGameButton.setText(resourceBundle.getString(UIResourcesNames.MENU_START_BUTTON_TEXT));
        startGameButton.setBounds(startGameButtonSize);
        panel.add(startGameButton);
    }

    private void identStatisticsButton(){
        statisticsButton = new JButton();
        statisticsButton.setText(resourceBundle.getString(UIResourcesNames.MENU_STATISTICS_BUTTON_TEXT));
        statisticsButton.setBounds(statisticsButtonSize);
        panel.add(statisticsButton);
    }
    private void identExitButton(){
        exitButton = new JButton();
        exitButton.setText(resourceBundle.getString(UIResourcesNames.MENU_EXIT_BUTTON_TEXT));
        exitButton.setBounds(exitButtonSize);
        panel.add(exitButton);
    }

    public JButton getStartGameButton(){
        return startGameButton;
    }

    public JButton getStatisticsButton(){
        return statisticsButton;
    }

    public JButton getExitButton(){
        return exitButton;
    }
}
