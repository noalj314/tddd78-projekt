package se.liu.noalj314.objects.towers;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.Bullet;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.DIMENSION_X;
import static se.liu.noalj314.constants.Constants.DIMENSION_Y;
import static se.liu.noalj314.constants.Constants.Towers.FREEZE_MULTIPLIER;
import static se.liu.noalj314.constants.Constants.Towers.MAGE_DAMAGE;
import static se.liu.noalj314.constants.Constants.Towers.MAGE_FIRERATE;
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
	setStartingValues();
    }

    @Override public void renderImage(final Graphics g, final Point position) {
	g.drawImage(LoadImage.MAGE, position.x, position.y, null);
    }

    @Override public void renderString(final Graphics g, final Point position) {
	g.drawString("Mage Cost: " + Constants.Towers.getTowerCost(TowerType.MAGE), (int) (DIMENSION_X * 0.75), (int) (DIMENSION_Y * 0.1));

    }
    @Override public Bullet.BulletType getBulletType() {
	return Bullet.BulletType.ICE;
    }

    @Override public Tower createTower() {
	return new Mage(position, id);

    }

    @Override public TowerType getTowerType() {
	return TowerType.MAGE;
    }

    @Override public void setStartingValues() {
	this.damage = MAGE_DAMAGE;
	this.firerate = MAGE_FIRERATE;
	this.range = MAGE_RANGE;
	this.freezeSpeed = FREEZE_MULTIPLIER;
    }
}
