package se.liu.noalj314.handlers;

import se.liu.noalj314.screens.PlayingScreen;
import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.Bullet;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.towers.Tower;
import se.liu.noalj314.objects.towers.TowerType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static se.liu.noalj314.constants.Constants.BULLET_SIZE;
import static se.liu.noalj314.constants.Constants.DIMENSIONX;
import static se.liu.noalj314.constants.Constants.DIMENSIONY;
import static se.liu.noalj314.constants.Constants.PIXEL_SIZE;


public class BulletHandler
{
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private PlayingScreen playingScreen;
    private boolean renderExplosion = false;
    private int explosionTime;
    public BulletHandler(PlayingScreen playingScreen) {
	this.playingScreen = playingScreen;
    }
    public void update(){
	for (Bullet bullet: bullets) {
	    if(!bullet.isDestroyed()) {
		bullet.shoot();
		if(bulletHit(bullet)){
		    bullet.setDestroyed(true);
		    if(bullet.getBulletType().equals(Bullet.BulletType.SHELL)) {
			bullet.triggerExplosion();
		    }
		} else if (bulletInAbyss(bullet)) {
		    bullet.setDestroyed(true);
		}
	    }
	    bullet.incrementExplosionTime(); // Manage explosion timing per bullet
	}
    }
    private boolean bulletInAbyss(Bullet bullet){
	if (bullet.getX() >= 0 || bullet.getX() <= DIMENSIONX)
	    if (bullet.getY() >= 0 || bullet.getY() <= DIMENSIONY)
		return false;
	return true;
    }
    private boolean bulletHit(Bullet bullet) {
	Rectangle bulletRect = new Rectangle((int)bullet.getX(), (int)bullet.getY(), BULLET_SIZE, BULLET_SIZE);
	for (Enemy enemy : playingScreen.getEnemyHandler().getEnemies()) {
	    Rectangle enemyRect = new Rectangle((int)enemy.getX(), (int)enemy.getY(), PIXEL_SIZE, PIXEL_SIZE);
	    if (enemyRect.intersects(bulletRect)) {
		enemy.decreaseHealth(bullet.getDamage());
		if (bullet.getBulletType().equals(Bullet.BulletType.SHELL))
		   explosionHit(bullet);
		else if (bullet.getBulletType().equals(Bullet.BulletType.ICE)) {
		    enemy.decreaseSpeed(bullet.getFreezeSpeed());
		}
		return true;
	    }
	}
	return false;
    }

    private void explosionHit(Bullet bullet){
	for (Enemy enemy: playingScreen.getEnemyHandler().getEnemies()){
	    float explosionRadius = Constants.Towers.getStartRange(TowerType.ARTILLERY);
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
	g.drawImage(LoadImage.explosion, (int) bullet.getX(), (int) bullet.getY(), null);
    }
    private void renderBullet(Bullet bullet, Graphics g) {
	g.drawImage(getBulletImage(bullet.getBulletType()), (int) bullet.getX(), (int) bullet.getY(), null);
    }


    public void newBullet(Enemy enemy, Tower tower){
	int xRange = (int) (tower.getPosition().x - enemy.getX());
	int yRange = (int) (tower.getPosition().y - enemy.getY());
	float angle = (float) Math.atan2(yRange, xRange);
	float xVelocity = (float) (Constants.Bullets.getVelocity(getBulletType(tower)) * Math.cos(angle));
	float yVelocity = (float) (Constants.Bullets.getVelocity(getBulletType(tower)) * Math.sin(angle));
	bullets.add(new Bullet(tower.getPosition().x, tower.getPosition().y, getBulletType(tower), -xVelocity ,-yVelocity, tower.getDamage(), tower.getFreezeSpeed()));
    }
    private BufferedImage getBulletImage(Bullet.BulletType bulletType) {
	switch (bulletType) {
	    case SHELL -> {
		return LoadImage.shell;
	    }
	    case ICE -> {
		return LoadImage.icebolt;
	    }
	    case ARROW -> {
		return LoadImage.arrow;
	    }
	}
	return null;
    }
    private Bullet.BulletType getBulletType(Tower tower){
	switch(tower.getTowerType()) {
	    case MAGE -> {return Bullet.BulletType.ICE;}
	    case HUNTER -> {return Bullet.BulletType.ARROW;}
	    case ARTILLERY -> {return Bullet.BulletType.SHELL;}
	}
	return null;
    }
}
