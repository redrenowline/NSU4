package ru.nsu.ccfit.Prokhorov.lab2.core;

import ru.nsu.ccfit.Prokhorov.lab2.files.StatisticsFileReader;
import ru.nsu.ccfit.Prokhorov.lab2.files.StatisticsFileWriter;
import ru.nsu.ccfit.Prokhorov.lab2.log.LoggerResourcesNames;
import ru.nsu.ccfit.Prokhorov.lab2.model.Field;
import ru.nsu.ccfit.Prokhorov.lab2.ui.GUIHandler;
import ru.nsu.ccfit.Prokhorov.lab2.ui.GUIHandlerListener;
import ru.nsu.ccfit.Prokhorov.lab2.ui.SettingsGUI;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
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
    private Map<String, Long> statistics;
    private String nickname;
    public Core(){
        guiHandler = new GUIHandler(this);

        logBundle = ResourceBundle.getBundle(LoggerResourcesNames.BUNDLE_NAME);
        timer = new Timer();
        startDate = new Date();
        try{
            StatisticsFileReader reader = new StatisticsFileReader();
            statistics = reader.getList();
        }catch(Exception e){
            logger.severe(logBundle.getString(LoggerResourcesNames.LOG_FILE_DONT_OPEN));
        }
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
        try {
            StatisticsFileReader reader = new StatisticsFileReader();
            statistics = reader.getList();
            guiHandler.showStatistics(statistics);
        }catch(Exception e){
            logger.severe(logBundle.getString(LoggerResourcesNames.LOG_FILE_DONT_OPEN));
        }
    }

    @Override
    public void startGame(int height, int width, int mineCount, String nickname) {
        field = new Field(height, width, mineCount);
        this.nickname = nickname;
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
        if(x0 > field.getMask().length || y0 > field.getMask()[0].length){
            return;
        }
        field.setFlag(x0, y0);
        guiHandler.updateField(field.getMask(), field.getFlagsCount());
        if(field.checkWinned()){
            winGame();
        }else if(field.isFinished()){
            guiHandler.hideGame();
            guiHandler.showLosingMessage();
        }
    }

    public void winGame(){
        finishDate = new Date();
        statistics.put(nickname, finishDate.getTime() - startDate.getTime());
        StatisticsFileWriter writer = new StatisticsFileWriter();
        try {
            writer.writeList(statistics);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        guiHandler.hideGame();
        guiHandler.showWinningMessage(finishDate.getTime() - startDate.getTime());
    }
}
