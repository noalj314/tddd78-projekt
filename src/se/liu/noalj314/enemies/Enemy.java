package se.liu.noalj314.enemies;

import java.awt.*;

public abstract class Enemy
{
    protected int health;
    protected int speed;
    protected Point position;
    protected boolean alive = true;
    protected EnemyType enemyType;
    public Enemy(Point position, EnemyType enemyType) {
        this.position = position;
        this.enemyType = enemyType;
    }
    private void setStartingHealth(){
        health = se.liu.noalj314.constants.Constants.Enemies.getStartHealth(enemyType);

    }

}
