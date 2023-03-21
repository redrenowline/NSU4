package ru.nsu.ccfit.Prokhorov.lab2.core.field;

public class Room {
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

    public int[][] getTileMask(){
        int[][] res = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(this.tiles[i][j].getEarthState()){
                    res[i][j] = MasksForOutput.EARTH;
                }else
                if(this.tiles[i][j].getCharacter() != null){
                    res[i][j] = MasksForOutput.HERO;
                } else
                if(!this.tiles[i][j].getThings().isEmpty()){
                    res[i][j] = MasksForOutput.THINGS;
                }else {
                    res[i][j] = MasksForOutput.SPACE;
                }
            }
        }
        return res;
    }
}
