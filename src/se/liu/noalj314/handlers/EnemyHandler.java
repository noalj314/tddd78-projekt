package se.liu.noalj314.handlers;

import se.liu.noalj314.Screens.PlayingScreen;
import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.enemies.Direction;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.enemies.EnemyType;
import se.liu.noalj314.objects.enemies.*;
import se.liu.noalj314.objects.TileType;
import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.MapMaker;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static se.liu.noalj314.constants.Constants.AMOUNTOFTILES;
import static se.liu.noalj314.constants.Constants.Enemies.getSpeed;
import static se.liu.noalj314.constants.Constants.PIXELSIZE;
import static se.liu.noalj314.objects.enemies.Direction.UP;
import static se.liu.noalj314.projekt.MapMaker.endX;
import static se.liu.noalj314.projekt.MapMaker.endY;
import static se.liu.noalj314.projekt.MapMaker.startX;
import static se.liu.noalj314.projekt.MapMaker.startY;

public class EnemyHandler
{
    private final PlayingScreen playingScreen;
    private Enemy test;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Game game;

    public EnemyHandler(PlayingScreen playingScreen, Game game) {
	this.playingScreen = playingScreen;
	this.game = game;
	addEnemy(EnemyType.BEAR);
	addEnemy(EnemyType.RAT);
	addEnemy(EnemyType.HUMANOID);
	addEnemy(EnemyType.BAT);
    }

    public void update() {
	for (Enemy enemy : enemies) {
	    moveEnemy(enemy);
	}
    }

    private void moveEnemy(Enemy enemy) {
	if (enemy.getLastDirection() == Direction.FIRST)
	    changeDirection(enemy);
	int newX = (int) (enemy.getX() + getSpeedX(enemy.getLastDirection(), enemy));
	int newY = (int) (enemy.getY() + getSpeedY(enemy.getLastDirection(), enemy));
	if (game.getTileTypeAt(newX, newY).equals(TileType.ROAD)) {
	    enemy.move(getSpeed(enemy.getEnemyType()), enemy.getLastDirection());
	} else {
	    changeDirection(enemy);
	}
    }

    private boolean noMoreMap( Enemy enemy) {
	float enemysTotalPosX = enemy.getX() / PIXELSIZE;
	float enemysTotalPosY = enemy.getY() / PIXELSIZE;
	if(enemysTotalPosX == endX && enemysTotalPosY ==endY)
		return true;
	return false;
    }


    private void changeDirection(Enemy enemy) {
	Direction direction = enemy.getLastDirection();

	int xTile = (int) (enemy.getX() / PIXELSIZE);
	int yTile = (int) (enemy.getY() / PIXELSIZE);

	enemyDimensionFix(enemy, direction, xTile, yTile);
	if (noMoreMap(enemy))
	    return;

	if (direction.equals(Direction.LEFT) || direction.equals(Direction.RIGHT)) {
	    float newY = (enemy.getY() + getSpeedY(Direction.DOWN, enemy));
	    if (game.getTileTypeAt(enemy.getX(), newY).equals(TileType.ROAD))
		enemy.move(getSpeed(enemy.getEnemyType()), Direction.DOWN);
	    else
		enemy.move(getSpeed(enemy.getEnemyType()), Direction.UP);
	} else {
	    float newX = (enemy.getX() + getSpeedX(Direction.LEFT, enemy));
	    if (game.getTileTypeAt(newX, enemy.getY()).equals(TileType.ROAD))
		enemy.move(getSpeed(enemy.getEnemyType()), Direction.LEFT);
	    else
		enemy.move(getSpeed(enemy.getEnemyType()), Direction.RIGHT);
	}
    }

    private void enemyDimensionFix(Enemy enemy, Direction direction, int xTile, int yTile) {
	switch (direction) {
	    case RIGHT -> {
		if (xTile < AMOUNTOFTILES -  1)
		    xTile++;
	    }
	    case DOWN -> {
		if (yTile < AMOUNTOFTILES - 1)
		    yTile++;
	    }
	}
	enemy.setPosition(xTile * PIXELSIZE, yTile * PIXELSIZE);
    }

    public float getSpeedY(Direction dir, Enemy enemy) {
	if (dir.equals(UP))
	    return -getSpeed(enemy.getEnemyType());
	else if (dir.equals(Direction.DOWN))
	    return getSpeed(enemy.getEnemyType()) + PIXELSIZE;
	return 0;
    }

    public float getSpeedX(Direction dir, Enemy enemy) {
	if (dir.equals(Direction.LEFT))
	    return -getSpeed(enemy.getEnemyType());
	else if (dir.equals(Direction.RIGHT))
	    return getSpeed(enemy.getEnemyType()) + PIXELSIZE;
	return 0;
    }

    public void render(Graphics g) {
	for (Enemy enemy : enemies)
	    renderEnemy(enemy, g);
    }

    private void renderEnemy(Enemy enemy, Graphics g) {
	g.drawImage(getEnemyImage(enemy.getEnemyType()), (int) enemy.getX(), (int) enemy.getY(), null);
    }

    private BufferedImage getEnemyImage(EnemyType enemyType) {
	switch (enemyType) {
	    case BAT -> {
		return LoadImage.bat;
	    }
	    case RAT -> {
		return LoadImage.rat;
	    }
	    case BEAR -> {
		return LoadImage.bear;
	    }
	    case HUMANOID -> {
		return LoadImage.humanoid;
	    }
	}
	return null;
    }

    private void addEnemy(EnemyType enemyType) {
	float xTile = startX; //no idea why it needs to be multipled by 2 but it works
	float yTile = startY; //no idea why it needs to be multipled by 2 but it works

	switch (enemyType) {
	    case BAT -> enemies.add(new Bat(xTile, yTile, 0));
	    case RAT -> enemies.add(new Rat(xTile, yTile, 0));
	    case BEAR -> enemies.add(new Bear(xTile, yTile, 0));
	    case HUMANOID -> enemies.add(new Humanoid(xTile, yTile, 0));
	}
    }
}