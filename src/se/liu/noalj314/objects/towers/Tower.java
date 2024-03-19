package se.liu.noalj314.objects.towers;

import java.awt.*;

public class Tower
{
    Point position;
    TowerType type;
    int id;
    public Tower(Point position, TowerType type, int id) {
        this.position = position;
        this.type = type;
        this.id = id;
    }
    public Point getPosition(){
        return position;
    }
    public void start() {

    }
    public void
    public TowerType getTowerType(){
        return type;
    }
}
