package se.liu.noalj314.enemies;

import java.awt.*;

public class Enemy
{
    protected int health;
    protected int speed;
    public Float x;
    public Float y;
    protected boolean alive = true;
    protected EnemyType enemyType;
    public Enemy(float x, float y, EnemyType enemyType) {
        this.x = x;
        this.y = y;
        this.enemyType = enemyType;
    }
    private void setStartingHealth(){
        health = se.liu.noalj314.constants.Constants.Enemies.getStartHealth(enemyType);
    }
    public void decreaseHealth(int damage){
        health -= damage;
        kill(); // kill enemy if health is less than zero
    }
    public void kill(){
        if (health <= 0)
            alive = false;
            //lägg till reward player här
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public boolean isAlive(){
        return alive;
    }
    public float getSpeed(){
        return speed;
    }
}
