package se.liu.noalj314.objects.towers;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.Bullet;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.DIMENSION_X;
import static se.liu.noalj314.constants.Constants.DIMENSION_Y;
import static se.liu.noalj314.constants.Constants.Towers.HUNTER_DAMAGE;
import static se.liu.noalj314.constants.Constants.Towers.HUNTER_FIRERATE;
import static se.liu.noalj314.constants.Constants.Towers.HUNTER_RANGE;

/**
 * The Hunter class represents a hunter tower in the game.
 * It extends the Tower abstract class and inherits its properties and methods.
 * This tower uses ARROW type bullets for attacking enemies.
 */
public class Hunter extends Tower
{

    public Hunter(final Point position, int id) {
	super(position, id);
    }
    @Override public void renderImage(final Graphics g, final Point position) {
	g.drawImage(LoadImage.HUNTER, position.x, position.y, null);
    }
    @Override public void renderString(final Graphics g) {
	g.drawString("Artillery Cost: " + Constants.Towers.getTowerCost(TowerType.ARTILLERY), (int) (DIMENSION_X * 0.75), (int) (
		DIMENSION_Y * 0.1));
    }
    @Override public Bullet.BulletType getBulletType() {
	return Bullet.BulletType.ARROW;
    }

    @Override public Tower createTower(Point position, int id) {
	return new Hunter(position, id);
    }
    @Override public TowerType getTowerType() {
	return TowerType.HUNTER;
    }

    @Override public void setStartingValues() {
	this.fireRate = HUNTER_FIRERATE;
	this.damage = HUNTER_DAMAGE;
	this.range = HUNTER_RANGE;
    }
}
