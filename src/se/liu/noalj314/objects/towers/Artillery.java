package se.liu.noalj314.objects.towers;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.DIMENSIONX;
import static se.liu.noalj314.constants.Constants.DIMENSIONY;

public class Artillery extends Tower
{
    public Artillery(final Point position, final TowerType type, int id) {
	super(position, type, id);
    }

    @Override public void renderImage(final Graphics g, final Point position) {
	g.drawImage(LoadImage.artillery, position.x, position.y, null);
    }

    @Override public void renderString(final Graphics g, final Point position) {
	g.drawString("Artillery Cost: " + Constants.Towers.getTowerCost(TowerType.ARTILLERY), (int) (DIMENSIONX * 0.75), (int) (DIMENSIONY * 0.1));
    }
}
