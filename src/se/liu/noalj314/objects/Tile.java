package se.liu.noalj314.objects;

import java.awt.image.BufferedImage;

public class Tile
{
    private TileType tileType;
    private BufferedImage image;
    public Tile(TileType tileType, BufferedImage image) {
        this.tileType = tileType;
        this.image = image;
    }

    public TileType getTileType() {
        return tileType;
    }
}
