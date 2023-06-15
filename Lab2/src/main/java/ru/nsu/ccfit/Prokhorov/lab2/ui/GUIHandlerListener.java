package ru.nsu.ccfit.Prokhorov.lab2.ui;

public interface GUIHandlerListener {
    public void startButtonPressed();
    public void exitButtonPressed();
    public void statisticsButtonPressed();

    public void startGame(int height, int width, int mineCount, String nickname);

    public void checkPoint(int x0, int y0);
    public void setFlag(int x0, int y0);
}
