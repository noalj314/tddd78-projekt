package se.liu.noalj314.objects.towers;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.Bullet;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.DIMENSION_X;
import static se.liu.noalj314.constants.Constants.DIMENSION_Y;
import static se.liu.noalj314.constants.Constants.Towers.FREEZE_MULTIPLIER;
import static se.liu.noalj314.constants.Constants.Towers.MAGE_DAMAGE;
import static se.liu.noalj314.constants.Constants.Towers.MAGE_FIRE_RATE;
import static se.liu.noalj314.constants.Constants.Towers.MAGE_RANGE;

/**
 * The Mage class represents a ice mage tower in the game.
 * It extends the Tower abstract class and inherits its properties and methods.
 * This tower uses ICEBOLT type bullets for attacking enemies.
 */
public class Mage extends Tower
{
    public Mage(final Point position, int id) {
	super(position, id);
    }

    @Override public void renderImage(final Graphics g, final Point position) {
	g.drawImage(LoadImage.MAGE, position.x, position.y, null);
    }

    @Override public void renderString(final Graphics g) {
	g.drawString("Mage Cost: " + Constants.Towers.getTowerCost(TowerType.MAGE), (int) (DIMENSION_X * 0.75), (int) (DIMENSION_Y * 0.1));

    }
    @Override public Bullet.BulletType getBulletType() {
	return Bullet.BulletType.ICE;
    }

    @Override public Tower createTower(Point position, int id) {
	return new Mage(position, id);
    }

    @Override public TowerType getTowerType() {
	return TowerType.MAGE;
    }

    @Override public void setStartingValues() {
	this.damage = MAGE_DAMAGE;
	this.fireRate = MAGE_FIRE_RATE;
	this.range = MAGE_RANGE;
	this.freezeSpeed = FREEZE_MULTIPLIER;
    }
}
