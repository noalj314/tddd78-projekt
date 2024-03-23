package se.liu.noalj314.objects.towers;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.Bullet;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.DIMENSION_X;
import static se.liu.noalj314.constants.Constants.DIMENSION_Y;
import static se.liu.noalj314.constants.Constants.Towers.ARTILLERY_DAMAGE;
import static se.liu.noalj314.constants.Constants.Towers.ARTILLERY_FIRERATE;
import static se.liu.noalj314.constants.Constants.Towers.ARTILLERY_RANGE;

/**
 * The Artillery class represents an artillery tower in the game.
 * It extends the Tower abstract class and inherits its properties and methods.
 * This tower uses SHELL type bullets for attacking enemies.
 */
public class Artillery extends Tower
{
    public Artillery(final Point position, int id) {
	super(position, id);
    }

    @Override public void renderImage(final Graphics g, final Point position) {
	g.drawImage(LoadImage.ARTILLERY, position.x, position.y, null);
    }

    @Override public void renderString(final Graphics g) {
	g.drawString("Artillery Cost: " + Constants.Towers.getTowerCost(TowerType.ARTILLERY), (int) (DIMENSION_X * 0.75), (int) (
		DIMENSION_Y * 0.1));
    }

    @Override public Bullet.BulletType getBulletType() {
	return Bullet.BulletType.SHELL;
    }

    @Override public Tower createTower(Point position, int id) {
	return new Artillery(position, id);
    }

    @Override public TowerType getTowerType() {
	return TowerType.ARTILLERY;
    }

    @Override public void setStartingValues() {
	this.fireRate = ARTILLERY_FIRERATE;
	this.damage = ARTILLERY_DAMAGE;
	this.range = ARTILLERY_RANGE;
    }

}
