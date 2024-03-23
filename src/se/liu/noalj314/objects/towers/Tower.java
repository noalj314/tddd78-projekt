package se.liu.noalj314.objects.towers;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.objects.Bullet;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.Towers.*;
/**
 * The Tower abstract class represents a tower in the game.
 * It maintains the properties of a tower such as its position, range, damage, and cost.
 * It provides methods to attack enemies, upgrade the tower, and render its image and string.
 */
public abstract class Tower
{
    protected Point position;
    protected int id;
    private int firerateCounter;
    protected int damage;
    protected float firerate;
    protected float range;
    protected float freezeSpeed;
    protected Tower(Point position, int id) {
        this.id = id;
        this.position = position;
    }
    public void update(){
        firerateCounter++;
    }
    public Point getPosition(){
        return position;
    }

    public float getRange() {
        return range;
    }

    public boolean timeToShoot() {
        return firerateCounter >= firerate;
    }
    public void resetFirerateCounter() {
        firerateCounter = 0;
    }
    public int getDamage() {
        return damage;
    }
    public float getFreezeSpeed() {
        return freezeSpeed;
    }
    public abstract void renderImage(Graphics g, Point position);
    public abstract void renderString(Graphics g, Point position);
    public abstract Bullet.BulletType getBulletType();
    public abstract Tower createTower();
    public abstract TowerType getTowerType();
    public abstract void setStartingValues();
}
