package se.liu.noalj314.projekt;

import se.liu.noalj314.objects.TileType;

public class MapMaker
{
    public static final int START_X = 0;
    public static final int START_Y = 0;
    public static final int  END_Y = 14;
    public static final int END_X = 5;

    public final static TileType[][] MAP = {
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
}

