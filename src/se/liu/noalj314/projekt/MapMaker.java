package se.liu.noalj314.projekt;

import se.liu.noalj314.objects.Tile;
import se.liu.noalj314.objects.TileType;

import java.awt.*;

public class MapMaker
{
    public static Point start;
    public static Point end;

    public static TileType[][] getMap() {

        TileType[][] map = new TileType[20][20];

        // Fill the map with grass
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = TileType.GRASS;
            }
        }
        // Create a road
        start = new Point(-1,0);
        for (int i = 0; i < 8; i++) {
            map[i][0] = TileType.ROAD;
        }
        for (int i = 0; i < 20; i++) {
            map[7][i] = TileType.ROAD;
        }
        for (int i = 7; i < 16; i++) {
            map[i][19] = TileType.ROAD;
        }
        for (int i = 19; i > 9; i--) {
            map[15][i] = TileType.ROAD;
        }
        for (int i = 15; i > 2; i--) {
            map[i][9] = TileType.ROAD;
        }

        for (int i = 9; i < 20; i++) {
            map[3][i] = TileType.ROAD;
        }
        end = new Point(19, 3);

        // Create a water body
        for (int i = 10; i < 15; i++) {
            for (int j = 10; j < 15; j++) {
                map[i][j] = TileType.WATER;
            }
        }

        return map;
    }
}

