package se.liu.noalj314.projekt;

import java.awt.*;

public class Tower
{
    Point position;
    Tower type;
    int damage;
    int firerate;
    public Tower(final Point position) {
        this.position = position;
    }
    public Point getPosition(){
        return position;
    }
    public int getDamage() {
        return damage;
    }
    public int getFirerate(){
        return firerate;
    }
}
