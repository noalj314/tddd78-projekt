package se.liu.noalj314.objects.towers;

import se.liu.noalj314.objects.Bullet;
import java.awt.*;

/**
 * The Tower abstract class represents a tower in the game.
 * It maintains the properties of a tower such as its position, range, damage, and cost.
 * It provides methods to attack enemies, upgrade the tower, and render its image and string.
 */
public abstract class Tower
{
    protected Point position;
    protected int id;
    private int fireRateCounter;
    protected int damage;
    protected float fireRate;
    protected float range;
    protected float freezeSpeed;
    protected Tower(Point position, int id) {
        this.id = id;
        this.position = position;
        setStartingValues();
    }
    public void update(){
        fireRateCounter++;
    }
    public Point getPosition(){
        return position;
    }

    public float getRange() {
        return range;
    }

    public boolean timeToShoot() {
        return fireRateCounter >= fireRate;
    }
    public void resetFireRateCounter() {
        fireRateCounter = 0;
    }
    public int getDamage() {
        return damage;
    }
    public float getFreezeSpeed() {
        return freezeSpeed;
    }
    public abstract void renderImage(Graphics g, Point position);
    public abstract void renderString(Graphics g);
    public abstract Bullet.BulletType getBulletType();
    public abstract Tower createTower(Point position, int id);
    public abstract TowerType getTowerType();
    public abstract void setStartingValues();
}
