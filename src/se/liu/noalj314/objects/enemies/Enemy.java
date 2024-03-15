package se.liu.noalj314.objects.enemies;

public abstract class Enemy
{
    protected int health, speed;
    public Float x;
    public Float y;
    protected boolean alive = true;
    protected EnemyType enemyType;
    private int id;
    private Direction lastDirection;

    public Enemy(float x, float y, EnemyType enemyType, int id) {
        this.x = x;
        this.y = y;
        this.enemyType = enemyType;
        this.id = id;
        lastDirection = Direction.FIRST;
    }
    public void move(float speed, Direction direction){
        lastDirection = direction;
        switch (direction) {
            case UP -> this.y -= speed ;
            case DOWN -> this.y += speed;
            case LEFT -> this.x -= speed;
            case RIGHT -> this.x += speed;
        }
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
}
