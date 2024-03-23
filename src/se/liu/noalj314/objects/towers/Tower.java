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
    private Point position;
    private TowerType type;
    private int firerateCounter, damage, id;
    private float firerate, range, freezeSpeed;
    protected Tower(Point position, TowerType type, int id) {
        this.id = id;
        this.position = position;
        this.type = type;
        setStartingValues();
    }
    public void update(){
        firerateCounter++;
    }
    public Point getPosition(){
        return position;
    }
    public void setStartingValues() {
        firerate = getStartFirerate(type);
        damage = getStartDamage(type);
        range = getStartRange(type);
        freezeSpeed = Constants.Towers.getFreezeSpeed(type);
    }
    public TowerType getTowerType(){
        return type;
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
}
