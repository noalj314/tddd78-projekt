package se.liu.noalj314.objects;

import java.awt.*;

public class Tower
{
    Point position;
    TowerType type;
    public Tower(Point position, TowerType type) {
        this.position = position;
    }
    public Point getPosition(){
        return position;
    }
}
