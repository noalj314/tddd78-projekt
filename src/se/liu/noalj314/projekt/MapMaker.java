package se.liu.noalj314.projekt;

import java.util.ArrayList;

public class MapMaker
{

    private TileType[][] tiles;
    private int height;
    private int width;

    public MapMaker(int height, int width) {
        this.tiles = new TileType[height][width];
    }

    public TileType[][] newMap(){
        for (int heightIndex = 0; heightIndex < tiles.length; heightIndex++) {
            for (int widthIndex = 0; widthIndex < tiles[heightIndex].length; widthIndex++) {
                 if (widthIndex == 4) {
                    tiles[heightIndex][widthIndex] = TileType.ROAD;
                } else {
                    tiles[heightIndex][widthIndex] = TileType.GRASS;
                }
            }
        }
        return tiles;
    }


}
