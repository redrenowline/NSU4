package ru.nsu.ccfit.Prokhorov.lab2.core;

import ru.nsu.ccfit.Prokhorov.lab2.log.LoggerResourcesNames;
import ru.nsu.ccfit.Prokhorov.lab2.model.Field;
import ru.nsu.ccfit.Prokhorov.lab2.ui.GUIHandler;
import ru.nsu.ccfit.Prokhorov.lab2.ui.GUIHandlerListener;
import ru.nsu.ccfit.Prokhorov.lab2.ui.SettingsGUI;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.logging.Logger;

public class Core implements GUIHandlerListener {

    private GUIHandler guiHandler;
    private Logger logger = Logger.getLogger(Core.class.getName());
    private ResourceBundle logBundle;
    private Field field;
    private Timer timer;
    private Date startDate, finishDate;
    public Core(){
        guiHandler = new GUIHandler(this);

        logBundle = ResourceBundle.getBundle(LoggerResourcesNames.BUNDLE_NAME);
        timer = new Timer();
        startDate = new Date();
    }

    public void start(){
        guiHandler.showMenu();
    }


    @Override
    public void startButtonPressed() {
        logger.info(logBundle.getString(LoggerResourcesNames.LOG_START_BUTTON_PRESSED));
        guiHandler.hideMenu();
        guiHandler.showSettings();
    }

    @Override
    public void exitButtonPressed() {
        logger.info(logBundle.getString(LoggerResourcesNames.LOG_EXIT_BUTTON_PRESSED));
        System.exit(0);
    }

    @Override
    public void statisticsButtonPressed() {
        logger.info(logBundle.getString(LoggerResourcesNames.LOG_STATISTICS_BUTTON_PRESSED));
    }

    @Override
    public void startGame(int height, int width, int mineCount) {
        field = new Field(height, width, mineCount);
        guiHandler.showGameGUI(field.getMask(), mineCount);
    }

    @Override
    public void checkPoint(int x0, int y0) {
        if(x0 > field.getMask().length || y0 > field.getMask()[0].length){
            return;
        }
        if(!field.getGenerated())
            field.generateField(x0, y0);
        field.checkCell(x0, y0);
        guiHandler.updateField(field.getMask(), field.getFlagsCount());
        if(field.checkWinned()){
            winGame();
        }else if(field.isFinished()){
            guiHandler.showLosingMessage();
        }
    }

    @Override
    public void setFlag(int x0, int y0) {
        field.setFlag(x0, y0);
        guiHandler.updateField(field.getMask(), field.getFlagsCount());
        if(field.checkWinned()){
            winGame();
        }else if(field.isFinished()){
            guiHandler.showLosingMessage();
        }
    }

    public void winGame(){
        finishDate = new Date();
        guiHandler.showWinningMessage(finishDate.getTime() - startDate.getTime());
    }
}
