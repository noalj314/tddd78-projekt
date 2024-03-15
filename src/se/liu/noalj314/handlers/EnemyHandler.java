package se.liu.noalj314.handlers;

import se.liu.noalj314.Screens.PlayingScreen;
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

import static se.liu.noalj314.constants.Constants.PIXELSIZE;
import static se.liu.noalj314.objects.enemies.Direction.UP;

public class EnemyHandler
{
    private final PlayingScreen playingScreen;
    private BufferedImage[] images;
    private Enemy test;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private float speed = 3f;
    private Game game;

    public EnemyHandler(PlayingScreen playingScreen, Game game) {
	this.playingScreen = playingScreen;
	this.images = new BufferedImage[3];
	this.game = game;
	//addEnemy(EnemyType.RAT);
	addEnemy(EnemyType.BAT);


	//enemies.add(new Enemy(PIXELSIZE * 3, PIXELSIZE*7, EnemyType.BAT, 0));
    }

    public void update() {
	for (Enemy enemy : enemies) {
	    moveEnemy(enemy);
	}
    }

    private void moveEnemy(Enemy enemy) {
	System.out.println(noMoreMap(enemy));
	if (enemy.getLastDirection() == Direction.FIRST)
	    changeDirection(enemy);
	int newX = (int) (enemy.getX() + getSpeedX(enemy.getLastDirection()));
	int newY = (int) (enemy.getY() + getSpeedY(enemy.getLastDirection()));
	if (game.getTileTypeAt(newX, newY).equals(TileType.ROAD)) {
	    enemy.move(speed, enemy.getLastDirection());
	} else {
	    changeDirection(enemy);
	}
    }

    private boolean noMoreMap( Enemy enemy) {
	Point enemysTotalPos = new Point((int)enemy.getX() / PIXELSIZE, (int)enemy.getY() / PIXELSIZE);
	if(enemysTotalPos.equals(MapMaker.end))
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
	    float newY = (enemy.getY() + getSpeedY(Direction.DOWN));
	    if (game.getTileTypeAt(enemy.getX(), newY).equals(TileType.ROAD))
		enemy.move(speed, Direction.DOWN);
	    else
		enemy.move(speed, Direction.UP);
	} else {
	    float newX = (enemy.getX() + getSpeedX(Direction.LEFT));
	    if (game.getTileTypeAt(newX, enemy.getY()).equals(TileType.ROAD))
		enemy.move(speed, Direction.LEFT);
	    else
		enemy.move(speed, Direction.RIGHT);
	}
    }

    private void enemyDimensionFix(Enemy enemy, Direction direction, int xTile, int yTile) {
	switch (direction) {
	    case RIGHT -> {
		if (xTile < 19)
		    xTile++;
	    }
	    case DOWN -> {
		if (yTile < 19)
		    yTile++;
	    }
	}
	enemy.setPosition(xTile * PIXELSIZE, yTile * PIXELSIZE);
    }

    public float getSpeedY(Direction dir) {
	if (dir.equals(UP))
	    return -speed;
	else if (dir.equals(Direction.DOWN))
	    return speed + PIXELSIZE;
	return 0;
    }

    public float getSpeedX(Direction dir) {
	if (dir.equals(Direction.LEFT))
	    return -speed;
	else if (dir.equals(Direction.RIGHT))
	    return speed + PIXELSIZE;
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
	int xTile = MapMaker.start.x * PIXELSIZE * 2; //no idea why it needs to be multipled by 2 but it works
	int yTile = MapMaker.start.y * PIXELSIZE * 2; //no idea why it needs to be multipled by 2 but it works

	switch (enemyType) {
	    case BAT -> enemies.add(new Bat(xTile, yTile, 0));
	    case RAT -> enemies.add(new Rat(xTile, yTile, 0));
	    case BEAR -> enemies.add(new Bear(xTile, yTile, 0));
	    case HUMANOID -> enemies.add(new Humanoid(xTile, yTile, 0));
	}
    }
}