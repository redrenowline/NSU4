package ru.nsu.ccfit.Prokhorov.lab2.model;

import java.util.Random;

public class Field {

    private byte[][] mask;
    private byte[][] field;
    private int mineCount;
    private int flagsCount = 0;
    private boolean finished = false;
    private boolean generated = false;
    private boolean winned = false;
    public Field(int height, int width, int mineCount){
        mask = new byte[height][width];
        field = new byte[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                mask[i][j] = CellConstants.FOG_CELL;
                field[i][j] = 0;
            }
        }
        this.mineCount = mineCount;

    }

    public void generateField(int x, int y){
        Random rand = new Random();
        rand.setSeed(x * 31213 + y *121);
        for(int itr = 0; itr < mineCount; itr++){
            int x0 = (int) (Math.abs(rand.nextInt()) % field.length);
            int y0 = (int) (Math.abs(rand.nextInt()) % field[field.length - 1].length);
            if(x != x0 && y!= y0 && field[x0][y0] != CellConstants.MINE_CELL){
                field[x0][y0] = CellConstants.MINE_CELL;
            }else{
                itr--;
            }
        }
        for(int i = 0; i < field.length; i++){
            for(int j = 0;j < field[field.length - 1].length; j++){
                if(field[i][j] != CellConstants.MINE_CELL) field[i][j] = calcBombs(i,j);
            }
        }
        generated = true;
    }
    public int getFlagsCount(){
        return flagsCount;
    }

    private byte calcBombs(int x, int y){
        byte res = 0;
        int startX = -1, startY = -1, finishX = 1, finishY = 1;
        if(x == 0)
            startX = 0;
        if(y == 0)
            startY = 0;
        if(x == field.length - 1)
            finishX = 0;
        if(y == field[field.length - 1].length - 1)
            finishY = 0;
        for(int i = startX; i <= finishX;i++){
            for(int j = startY; j <= finishY; j++){
                if(field[x+i][y+j] == CellConstants.MINE_CELL){
                    res++;
                }
            }
        }
        return res;
    }

    public byte[][] getMask(){
        return mask;
    }

    public void freeAround(int x, int y){
        if(field[x][y] != 0){
            mask[x][y] = field[x][y];
            return;
        }
        mask[x][y] = field[x][y];
        int startX = -1, startY = -1, finishX = 1, finishY = 1;
        if(x == 0)
            startX = 0;
        if(y == 0)
            startY = 0;
        if(x == field.length - 1)
            finishX = 0;
        if(y == field[field.length - 1].length - 1)
            finishY = 0;
        for(int i = startX; i <= finishX;i++){
            for(int j = startY; j <= finishY; j++){
                if(mask[x+i][y+j] == CellConstants.FOG_CELL) {
                    freeAround(x+i, y+j);
                }
            }
        }
    }
    public void checkCell(int x, int y){
        if(mask[x][y] == CellConstants.FLAG_CELL){
            flagsCount--;
        }
        if(field[x][y] == CellConstants.MINE_CELL){
            finished = true;
            return;
        }
        if(field[x][y] == 0){
            freeAround(x, y);
        }else{
            mask[x][y] = field[x][y];
        }
    }

    public boolean getGenerated(){
        return generated;
    }

    public boolean isFinished(){
        return finished;
    }

    public boolean checkWinned(){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                if(mask[i][j] == CellConstants.FOG_CELL){
                    return false;
                }
                if(mask[i][j]== CellConstants.FLAG_CELL && field[i][j] != CellConstants.MINE_CELL){
                    return false;
                }
            }
        }
        return true;
    }

    public void setFlag(int x, int y){
        if(mask[x][y] == CellConstants.FOG_CELL){
            mask[x][y] = CellConstants.FLAG_CELL;
            flagsCount++;
        }
    }

}
