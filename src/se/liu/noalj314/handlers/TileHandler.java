package se.liu.noalj314.handlers;

import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.Tile;
import se.liu.noalj314.objects.TileType;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TileHandler
{
    public List<Tile> tiles = new ArrayList<Tile>();
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
