package se.liu.noalj314.handlers;

import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.TileType;

import java.awt.image.BufferedImage;

/**
 * The TileHandler class is responsible for managing the tiles in the game.
 * It provides methods for getting the image associated with a specific tile type.
 */
public class TileHandler
{
    public BufferedImage getImage(TileType tileType) {
	switch (tileType) {
	    case GRASS:
		return LoadImage.GRASS;
	    case ROAD:
		return LoadImage.ROAD;
	    case WATER:
		return LoadImage.WATER;
	    default:
		return null;
	}
    }
}
