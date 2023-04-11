package ru.nsu.ccfit.Prokhorov.lab2.core.field;

import ru.nsu.ccfit.Prokhorov.lab2.core.Player;
import ru.nsu.ccfit.Prokhorov.lab2.core.characters.Creature;

public class Room {

    private int viewX = 0, viewY = 0;
    private Tile[][] tiles;
    private int height;
    private int width;

    public Room(int height, int width){
        this.height = height;
        this.width = width;
        tiles = new Tile[height][width];
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++)
                tiles[i][j] = new Tile();
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void digIn(int x, int y){
        this.tiles[x][y].dig();
    }

    public void setPlayer(Creature ch, int x, int y){
        tiles[x][y].setCharacter(ch);
        this.viewX = x;
        this.viewY = y;
    }

    public int[][] getTileMask(){
        int[][] res = new int[MasksForOutput.ALIGNRIGHT + MasksForOutput.ALIGNLEFT + 1][MasksForOutput.ALIGHTOP + MasksForOutput.ALIGNBOTTOM + 1];
        for(int i = viewX - MasksForOutput.ALIGNLEFT; i < viewX + MasksForOutput.ALIGNRIGHT + 1; i++){
            for(int j = viewY - MasksForOutput.ALIGHTOP; j < viewY + MasksForOutput.ALIGNBOTTOM + 1; j++){
                int i0 = i - viewX + MasksForOutput.ALIGNLEFT,j0 = j - viewY + MasksForOutput.ALIGHTOP;
                if(i < 0 || j < 0 || i >= this.tiles.length || j >= this.tiles[i].length){
                    res[i0][j0] = MasksForOutput.UNSEEN;
                }else
                if(this.tiles[i][j].getEarthState()){
                    res[i0][j0] = MasksForOutput.EARTH;
                }else
                if(this.tiles[i][j].getCharacter() != null){
                    res[i0][j0] = MasksForOutput.HERO;
                } else
                if(!this.tiles[i][j].getThings().isEmpty()){
                    res[i0][j0] = MasksForOutput.THINGS;
                }else {
                    res[i0][j0] = MasksForOutput.SPACE;
                }
            }
        }
        return res;
    }

    public int getViewX(){
        return viewX;
    }
    public int getViewY(){
        return viewY;
    }
}
