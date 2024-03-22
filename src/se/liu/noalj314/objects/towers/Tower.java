package se.liu.noalj314.objects.towers;

import se.liu.noalj314.constants.Constants;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.Towers.*;

public class Tower
{
    Point position;
    TowerType type;
    int id, firerateCounter, damage;

    private float firerate, range, freezeSpeed;
    public Tower(Point position, TowerType type, int id) {
        this.position = position;
        this.type = type;
        this.id = id;
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
}
