package se.liu.noalj314.handlers;

import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.Tile;
import se.liu.noalj314.objects.TileType;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileHandler
{
    public ArrayList<Tile> tiles = new ArrayList<Tile>();
    public BufferedImage getImage(TileType tileType) {
	switch (tileType) {
	    case GRASS:
		return LoadImage.grass;
	    case ROAD:
		return LoadImage.road;
	    case WATER:
		return LoadImage.water;
	    default:
		return null;
	}
    }
}
