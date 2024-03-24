package se.liu.noalj314.objects.enemies;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.handlers.EnemyHandler;
/**
 * The Enemy  class represents an enemy in the game.
 * It maintains the health, speed, position, type, and other properties of an enemy.
 * It provides methods to move the enemy, decrease its health and speed, check if it's alive or frozen, and get its properties.
 */
public class Enemy
{
    protected int health, speed;
    protected float x;
    protected float y;
    protected boolean alive = true;
    protected EnemyType enemyType;
    private Direction lastDirection;
    protected EnemyHandler enemyHandler;
    protected int freezeTickLimit = Constants.FREEZE_TICK_LIMIT;
    protected int freezeTick = freezeTickLimit;
    private float freezeSpeed;

    public Enemy(float x, float y, EnemyType enemyType, EnemyHandler enemyHandler) {
        this.x = x;
        this.y = y;
        this.enemyType = enemyType;
        lastDirection = Direction.FIRST;
        health = Constants.Enemies.getStartHealth(enemyType);
        this.enemyHandler = enemyHandler;
    }
    public void move(float speed, Direction direction){
        lastDirection = direction;
        if (freezeTick < freezeTickLimit) {
            freezeTick++;
            speed  *= freezeSpeed;
        }
        switch (direction) {
            case UP -> this.y -= speed ;
            case DOWN -> this.y += speed;
            case LEFT -> this.x -= speed;
            case RIGHT -> this.x += speed;
        }
    }

    public void decreaseHealth(int damage){
        health -= damage;
        tryToKill(); // kill enemy if health is less than zero
    }
    public void decreaseSpeed(float freezeSpeed) {
        this.freezeSpeed = freezeSpeed;
        freezeTick = 0;
    }
    public void tryToKill(){
        if (health <= 0 && alive) {
            alive = false;
            enemyHandler.payPlayer(enemyType);
        }
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
    public Direction getLastDirection(){
        return lastDirection;
    }

    public void setPosition(int x, int y) {
        this.x = (float) x;
        this.y = (float) y;
    }
    public EnemyType getEnemyType(){
        return enemyType;
    }
    public float getHealth(){
        return health;
    }

    public void kill() {
        this.health = 0;
        this.alive = false;
    }
    public boolean isFreezed(){
        return freezeTick < freezeTickLimit;
    }
}
