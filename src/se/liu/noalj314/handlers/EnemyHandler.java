package se.liu.noalj314.handlers;

import se.liu.noalj314.screens.PlayingScreen;
import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;

import se.liu.noalj314.objects.enemies.*;
import se.liu.noalj314.objects.TileType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static se.liu.noalj314.constants.Constants.AMOUNT_OF_TILES;
import static se.liu.noalj314.constants.Constants.Enemies.getSpeed;
import static se.liu.noalj314.constants.Constants.Enemies.getStartHealth;
import static se.liu.noalj314.constants.Constants.PIXEL_SIZE;
import static se.liu.noalj314.objects.enemies.Direction.UP;
import static se.liu.noalj314.projekt.MapMaker.END_X;
import static se.liu.noalj314.projekt.MapMaker.END_Y;
import static se.liu.noalj314.projekt.MapMaker.START_X;
import static se.liu.noalj314.projekt.MapMaker.START_Y;

/**
 * The EnemyHandler class manages the enemies in the game.
 * It contains methods for updating the state of enemies, rendering enemies and their health bars,
 * creating new enemies, and handling enemy movements and interactions.
 */
public class EnemyHandler
{
    private final PlayingScreen playingScreen;
    private List<Enemy> enemies = new ArrayList<>();

    public EnemyHandler(PlayingScreen playingScreen) {
	this.playingScreen = playingScreen;
    }

    public void update() {
	if (isTimeForSpawn()){
	    spawnEnemy();
	}
	for (Enemy enemy : enemies) {
	    moveEnemy(enemy);
	}
    }

    private void spawnEnemy() {
	addEnemy(playingScreen.getWaveHandler().getNextEnemy());
    }

    public boolean isTimeForSpawn(){
	if (playingScreen.getWaveHandler().isTimeToSpawn() && playingScreen.getWaveHandler().hasEnemiesToSpawn()){
		return true;
	}
	return false;
    }

    private void moveEnemy(Enemy enemy) {
	if (enemy.getLastDirection() == Direction.FIRST)
	    changeDirection(enemy);
	int newX = (int) (enemy.getX() + getSpeedX(enemy.getLastDirection(), enemy));
	int newY = (int) (enemy.getY() + getSpeedY(enemy.getLastDirection(), enemy));
	if (playingScreen.getGame().getTileTypeAt(newX, newY).equals(TileType.ROAD)) {
	    enemy.move(getSpeed(enemy.getEnemyType()), enemy.getLastDirection());
	} else {
	    changeDirection(enemy);
	}
    }

    private boolean noMoreMap(Enemy enemy) {
	final float epsilon = 0.2f;
	float enemyTotalPosX = enemy.getX() / PIXEL_SIZE;
	float enemyTotalPosY = enemy.getY() / PIXEL_SIZE;
	if(Math.abs(enemyTotalPosX - END_X) < epsilon && Math.abs(enemyTotalPosY - END_Y) < epsilon)
	    return true;
	return false;
    }


    private void changeDirection(Enemy enemy) {
	Direction direction = enemy.getLastDirection();

	int xTile = (int) (enemy.getX() / PIXEL_SIZE);
	int yTile = (int) (enemy.getY() / PIXEL_SIZE);

	fixEnemyDimension(enemy, direction, xTile, yTile);
	tryToRemoveEnemy(enemy);

	if (direction.equals(Direction.LEFT) || direction.equals(Direction.RIGHT)) {
	    float newY = (enemy.getY() + getSpeedY(Direction.DOWN, enemy));
	    float enemySpeed = enemy.getSpeed();

	    if (playingScreen.getGame().getTileTypeAt(enemy.getX(), newY).equals(TileType.ROAD))
		enemy.move(enemySpeed, Direction.DOWN);
	    else
		enemy.move(enemySpeed, Direction.UP);
	} else {
	    float newX = (enemy.getX() + getSpeedX(Direction.LEFT, enemy));
	    if (playingScreen.getGame().getTileTypeAt(newX, enemy.getY()).equals(TileType.ROAD))
		enemy.move(getSpeed(enemy.getEnemyType()), Direction.LEFT);
	    else
		enemy.move(getSpeed(enemy.getEnemyType()), Direction.RIGHT);
	}
    }
    private void tryToRemoveEnemy(Enemy enemy){
	if (noMoreMap(enemy) && enemy.isAlive()) {
	    enemy.kill();
	    playingScreen.getGameState().decreaseHp();
	}
    }
    private void fixEnemyDimension(Enemy enemy, Direction direction, int xTile, int yTile) {
	switch (direction) {
	    case RIGHT -> {
		if (xTile < AMOUNT_OF_TILES - 1)
		    xTile++;
	    }
	    case DOWN -> {
		if (yTile < AMOUNT_OF_TILES - 1)
		    yTile++;
	    }
	}
	enemy.setPosition(xTile * PIXEL_SIZE, yTile * PIXEL_SIZE);
    }

    public float getSpeedY(Direction dir, Enemy enemy) {
	if (dir.equals(UP))
	    return -getSpeed(enemy.getEnemyType());
	else if (dir.equals(Direction.DOWN))
	    return getSpeed(enemy.getEnemyType()) + PIXEL_SIZE;
	return 0;
    }

    public float getSpeedX(Direction dir, Enemy enemy) {
	if (dir.equals(Direction.LEFT))
	    return -getSpeed(enemy.getEnemyType());
	else if (dir.equals(Direction.RIGHT))
	    return getSpeed(enemy.getEnemyType()) + PIXEL_SIZE;
	return 0;
    }

    public void render(Graphics g) {
	for (Enemy enemy : enemies) {
	    if (enemy.isAlive()) {
		renderHealthBar(g, enemy);
		renderEnemy(enemy, g);
		renderFreeze(enemy, g);
	    }
	}
    }

    private void renderFreeze( Enemy enemy,  Graphics g) {
	if (enemy.isFreezed()){
		g.drawImage(LoadImage.FREEZE, (int) enemy.getX(), (int)enemy.getY(), null);
	}
    }

    private void renderHealthBar(Graphics g, Enemy enemy) {
	g.setColor(Color.RED);
	g.fillRect((int)enemy.getX() , (int)enemy.getY() - PIXEL_SIZE / 6, calculateWidthHPBar(enemy), PIXEL_SIZE / 10);
    }
    private int calculateWidthHPBar(Enemy enemy){
	return (int) (PIXEL_SIZE * enemy.getHealth() / getStartHealth(enemy.getEnemyType()));
    }

    private void renderEnemy(Enemy enemy, Graphics g) {
	g.drawImage(getEnemyImage(enemy.getEnemyType()), (int) enemy.getX(), (int) enemy.getY(), null);
    }

    private BufferedImage getEnemyImage(EnemyType enemyType) {
	switch (enemyType) {
	    case BAT -> {
		return LoadImage.BAT;
	    }
	    case RAT -> {
		return LoadImage.RAT;
	    }
	    case BEAR -> {
		return LoadImage.BEAR;
	    }
	    case HUMANOID -> {
		return LoadImage.HUMANOID;
	    }
	}
	return null;
    }

    private void addEnemy(EnemyType enemyType) {
	float xTile = START_X; //no idea why it needs to be multipled by 2 but it works
	float yTile = START_Y; //no idea why it needs to be multipled by 2 but it works

	switch (enemyType) {
	    case BAT -> enemies.add(new Bat(xTile, yTile, this));
	    case RAT -> enemies.add(new Rat(xTile, yTile, this));
	    case BEAR -> enemies.add(new Bear(xTile, yTile, this));
	    case HUMANOID -> enemies.add(new Humanoid(xTile, yTile, this));
	}
    }
    public List<Enemy> getEnemies(){
	return enemies;
    }

    public void payPlayer(EnemyType enemyType) {
	playingScreen.getGameState().setCoins(playingScreen.getGameState().getCoins() + Constants.Enemies.getReward(enemyType));
    }
}