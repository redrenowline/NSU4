package ru.nsu.ccfit.Prokhorov.lab2.ui;

import ru.nsu.ccfit.Prokhorov.lab2.exceptions.WrongEnterDataException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class GUIHandler {

    private MenuGUI menuGUI;
    private SettingsGUI settingsGUI;
    private GameGUI gameGUI;
    private StatisticsGUI statisticsGUI;
    private GUIHandlerListener listener;
    private Locale locale;
    private ResourceBundle resourceBundle;

    public GUIHandler(GUIHandlerListener listener){
        locale = new Locale("ru");
        menuGUI = new MenuGUI(locale);
        settingsGUI = new SettingsGUI(locale);
        statisticsGUI = new StatisticsGUI(locale);
        resourceBundle = ResourceBundle.getBundle(UIResourcesNames.BUNDLE_NAME, locale);
        this.listener = listener;
    }

    public void showMenu(){
        menuGUI.st();
        menuGUI.getExitButton().addActionListener(e -> listener.exitButtonPressed());
        menuGUI.getStartGameButton().addActionListener(e -> listener.startButtonPressed());
        menuGUI.getStatisticsButton().addActionListener(e -> listener.statisticsButtonPressed());
    }

    public void showStatistics(Map<String, Long> list){
        statisticsGUI.st(list);
    }

    public void showSettings(){
        settingsGUI.st();
        settingsGUI.getStartGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int height = settingsGUI.getFieldsHeight();
                    int width = settingsGUI.getFieldWidth();
                    int mineCount = settingsGUI.getMineCount();
                    String nickname = settingsGUI.getNickname();
                    listener.startGame(height, width, mineCount, nickname);
                }catch(WrongEnterDataException exception){
                    JOptionPane.showMessageDialog(null, resourceBundle.getString(UIResourcesNames.OPTIONS_WRONG_DATA));
                }
            }
        });
    }

    public void hideMenu(){
        menuGUI.hd();
    }
    public void hideGame(){
        gameGUI.fn();
    }

    public void updateField(byte[][] matrix, int flagsCount){
        gameGUI.updateField(matrix, flagsCount);
        gameGUI.enableField();
    }
    public void showWinningMessage(long time){
        JOptionPane.showMessageDialog(null, String.format(resourceBundle.getString(UIResourcesNames.GAME_WINNING_MESSAGE),String.valueOf(time / 60000), String.valueOf((time / 1000)%60)));
    }

    public void showLosingMessage(){
        JOptionPane.showMessageDialog(null, resourceBundle.getString(UIResourcesNames.GAME_LOSING_MESSAGE));
    }

    public void showGameGUI(byte[][] matrix, int mineCount){
        gameGUI = new GameGUI(locale, matrix, mineCount);
        settingsGUI.fn();
        gameGUI.st();
        gameGUI.getField().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x0 = e.getX() / gameGUI.getField().getCompHeight();
                int y0 = e.getY() / gameGUI.getField().getCompWidth();
                gameGUI.disableField();
                if(e.getButton() == MouseEvent.BUTTON1){
                    listener.checkPoint(x0, y0);
                }
                if(e.getButton() == MouseEvent.BUTTON3){
                    listener.setFlag(x0, y0);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
