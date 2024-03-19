package se.liu.noalj314.projekt;

import se.liu.noalj314.objects.Tile;
import se.liu.noalj314.objects.TileType;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.AMOUNTOFTILES;

public class MapMaker
{
    public static float startX, startY;
    public static float endX, endY;
    private static TileType[][] map = new TileType[AMOUNTOFTILES][AMOUNTOFTILES];

    public static TileType[][] getMap() {
        startX = 0.0f;
        endX= 5.0f;
        endY= 14.0f;
        startY= 0.0f;

        TileType[][] map = {

                // 1                                2                               3                   4                               5                               6                       7                       8                           9                               10                              11                  12                                  13                      14                          15
                {TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.WATER, TileType.WATER, TileType.WATER, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.WATER, TileType.WATER, TileType.WATER, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.WATER, TileType.WATER, TileType.WATER, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS, TileType.WATER, TileType.WATER, TileType.WATER, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS, TileType.WATER, TileType.WATER, TileType.WATER, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS, TileType.WATER, TileType.WATER, TileType.WATER, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS, TileType.WATER, TileType.WATER, TileType.WATER, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.GRASS, TileType.WATER, TileType.WATER, TileType.WATER, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS}
        };
    return map;
    }

}

