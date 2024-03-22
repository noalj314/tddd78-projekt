package se.liu.noalj314.objects;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.UPS;

public class Bullet
{
    private float x, y, xVelocity, yVelocity;
    private int damage;
    private BulletType bulletType;

    private boolean isDestroyed = false;
    private int explosionTime = 0;
    private boolean shouldRenderExplosion = false;
    private float freezeSpeed;

    public enum BulletType
    {
	ARROW, ICE, SHELL
    }
    public Bullet(float x, float y, BulletType bulletType, float xVelocity, float yVelocity, int damage, float freezeSpeed){
	this.bulletType =bulletType;
	this.damage = damage;
	this.x = x;
	this.y = y;
	this.xVelocity = xVelocity;
	this.yVelocity = yVelocity;
	this.freezeSpeed = freezeSpeed;
    }
    public void shoot() {
	this.x += this.xVelocity;
	this.y += this.yVelocity;
    }
    public boolean isDestroyed() {
	return isDestroyed;
    }

    public float getX() {
	return x;
    }

    public float getY() {
	return y;
    }

    public boolean shouldRenderExplosion() {
	return shouldRenderExplosion && explosionTime < UPS;
    }

    public void triggerExplosion() {
	this.shouldRenderExplosion = true;
	this.explosionTime = 0;
    }

    public void incrementExplosionTime() {
	if (shouldRenderExplosion) {
	    explosionTime++;
	    if (explosionTime >= UPS) {
		shouldRenderExplosion = false;
	    }
	}
    }

    public BulletType getBulletType() {
	return bulletType;
    }
    public int getDamage() {
	return damage;
    }
    public int get() {
	return damage;
    }

    public void setPos(float x, float y) {
	this.x = x;
	this.y = y;
    }
    public void setDestroyed(boolean b) {
	isDestroyed = b;
    }
    public float getFreezeSpeed() {
	return freezeSpeed;
    }

}
