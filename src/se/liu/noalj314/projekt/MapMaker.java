package se.liu.noalj314.projekt;

import se.liu.noalj314.objects.TileType;

/**
 * The MapMaker class is responsible for creating the game map.
 * It defines the start and end points of the map, and the layout of the map.
 */
public class MapMaker
{
    /**
     * The starting x-coordinate of the map.
     */
    public static final int START_X = 0;

    /**
     * The starting y-coordinate of the map.
     */
    public static final int START_Y = 0;

    /**
     * The ending y-coordinate of the map.
     */
    public static final int  END_Y = 14;

    /**
     * The ending x-coordinate of the map.
     */
    public static final int END_X = 5;

    /**
     * The layout of the map, represented as a 2D array of TileType.
     */
    public final static TileType[][] MAP = {
                // 1                                2                               3                   4                               5                               6                       7                       8                           9                               10                              11                  12                                  13                      14                          15
                {TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.ROAD, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
                {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
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

