package se.liu.noalj314.handlers;

import se.liu.noalj314.screens.PlayingScreen;
import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.Bullet;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.towers.Tower;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import static se.liu.noalj314.constants.Constants.BULLET_SIZE;
import static se.liu.noalj314.constants.Constants.DIMENSION_X;
import static se.liu.noalj314.constants.Constants.DIMENSION_Y;
import static se.liu.noalj314.constants.Constants.PIXEL_SIZE;
import static se.liu.noalj314.constants.Constants.Towers.ARTILLERY_RANGE;
import static se.liu.noalj314.constants.Constants.Towers.FREEZE_MULTIPLIER;

/**
 * The BulletHandler class manages the bullets in the game.
 * It contains methods for updating the state of bullets, checking for collisions,
 * rendering bullets and their explosions, and creating new bullets.
 */
public class BulletHandler
{
    private List<Bullet> bullets = new ArrayList<>();
    private PlayingScreen playingScreen;
    public BulletHandler(PlayingScreen playingScreen) {
	this.playingScreen = playingScreen;
    }
    public void update(){
	for (Bullet bullet: bullets) {
	    if(!bullet.isDestroyed()) {
		bullet.shoot();
		if(hasBulletHit(bullet)){
		    bullet.setDestroyed(true);
		    if(bullet.getBulletType().equals(Bullet.BulletType.SHELL)) {
			bullet.triggerExplosion();
		    }
		} else if (isBulletOutsideMap(bullet)) {
		    bullet.setDestroyed(true);
		}
	    }
	    bullet.incrementExplosionTime(); // Manage explosion timing per bullet
	}
    }
    private boolean isBulletOutsideMap(Bullet bullet){
	if (bullet.getX() >= 0 || bullet.getX() <= DIMENSION_X)
	    if (bullet.getY() >= 0 || bullet.getY() <= DIMENSION_Y)
		return false;
	return true;
    }
    private boolean hasBulletHit(Bullet bullet) {
	Rectangle bulletRect = new Rectangle((int)bullet.getX(), (int)bullet.getY(), BULLET_SIZE, BULLET_SIZE);
	for (Enemy enemy : playingScreen.getEnemyHandler().getEnemies()) {
	    Rectangle enemyRect = new Rectangle((int)enemy.getX(), (int)enemy.getY(), PIXEL_SIZE, PIXEL_SIZE);
	    if (enemyRect.intersects(bulletRect)) {
		enemy.decreaseHealth(bullet.getDamage());
		if (bullet.getBulletType().equals(Bullet.BulletType.SHELL))
		   handleExplosionHit(bullet);
		else if (bullet.getBulletType().equals(Bullet.BulletType.ICE)) {
		    enemy.decreaseSpeed(FREEZE_MULTIPLIER);
		}
		return true;
	    }
	}
	return false;
    }

    private void handleExplosionHit(Bullet bullet){
	for (Enemy enemy: playingScreen.getEnemyHandler().getEnemies()){
	    float explosionRadius = ARTILLERY_RANGE;
	    float xDistance = bullet.getX() - enemy.getX();
	    float yDistance = bullet.getY() - enemy.getY();
	    float distance = (float) Math.hypot(xDistance, yDistance);

	    if (distance <= explosionRadius) {
		enemy.decreaseHealth(bullet.getDamage());
	    }
	}
    }

    public void render(Graphics g) {
	for (Bullet bullet : bullets) {
	    if (!bullet.isDestroyed()) {
		renderBullet(bullet, g);
	    }
	    if (bullet.shouldRenderExplosion()) { // Render explosion per bullet
		renderExplosion(bullet, g);
	    }
	}
	}
    private void renderExplosion(Bullet bullet, Graphics g){
	g.drawImage(LoadImage.EXPLOSION, (int) bullet.getX(), (int) bullet.getY(), null);
    }
    private void renderBullet(Bullet bullet, Graphics g) {
	g.drawImage(getBulletImage(bullet.getBulletType()), (int) bullet.getX(), (int) bullet.getY(), null);
    }


    public void createBullet(Enemy enemy, Tower tower){
	int xRange = (int) (tower.getPosition().x - enemy.getX());
	int yRange = (int) (tower.getPosition().y - enemy.getY());
	float angle = (float) Math.atan2(yRange, xRange);
	Bullet.BulletType bulletType = tower.getBulletType();
	float bulletVelocity = Constants.Bullets.getVelocity(bulletType);
	float xVelocity = (float) (bulletVelocity * Math.cos(angle));
	float yVelocity = (float) (bulletVelocity * Math.sin(angle));
	bullets.add(new Bullet(tower.getPosition().x + PIXEL_SIZE/2, tower.getPosition().y+ PIXEL_SIZE/2, bulletType, -xVelocity ,-yVelocity, tower.getDamage(), tower.getFreezeSpeed()));
    }
    private BufferedImage getBulletImage(Bullet.BulletType bulletType) {
	switch (bulletType) {
	    case SHELL -> {
		return LoadImage.SHELL;
	    }
	    case ICE -> {
		return LoadImage.ICE_BOLT;
	    }
	    case ARROW -> {
		return LoadImage.ARROW;
	    }
	}
	return null;
    }

}
