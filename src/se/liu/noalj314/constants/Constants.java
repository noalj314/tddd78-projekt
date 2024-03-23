package se.liu.noalj314.constants;

import se.liu.noalj314.objects.Bullet;
import se.liu.noalj314.objects.enemies.EnemyType;
import se.liu.noalj314.objects.towers.TowerType;
/**
 * The Constants class provides a central location for defining and accessing constant values used throughout the game.
 * It includes constants for game settings such as frames per second, updates per second, pixel size, and dimensions.
 * It also includes nested classes for defining and accessing constants related to enemies, bullets, and towers.
 */
public class Constants
{
    /**
     * The FPS constant represents the frames per second at which the game runs.
     * It is used to control the speed of the game's rendering loop.
     */
    public static final double FPS = 60.0;

    /**
     * The UPS constant represents the updates per second at which the game runs.
     * It is used to control the speed of the game's update loop.
     */
    public static final double UPS = 60.0;

    /**
     * The PIXELSIZE constant represents the size of a pixel in the game.
     */
    public static final int PIXEL_SIZE = 48;

    /**
     * The BULLETSIZE constant represents the size of a bullet in the game.
     */
    public static final int BULLET_SIZE = (int) (PIXEL_SIZE / 3.5);

    /**
     * The DIMENSIONX constant represents the width of the game window.
     */
    public static final int DIMENSIONX = 720;

    /**
     * The DIMENSIONY constant represents the height of the game window.
     */
    public static final int DIMENSIONY = 720;

    /**
     * The AMOUNTOFTILES constant represents the number of tiles in the game.
     */
    public static final int AMOUNTOFTILES = 15;

    /**
     * The STARTINGAMTENEMIES constant represents the number of enemies at the start of the game.
     */
    public static final int AMOUNT_OF_ENEMIES = 3;

    /**
     * The COINS constant represents the number of coins at the start of the game.
     */
    public static final int COINS = 100;

    /**
     * The HP constant represents the initial health points of the player.
     */
    public static final int HP = 20;

    /**
     * The FREEZETICKLIMIT constant represents the limit of freeze ticks in the game.
     */
    public static final int FREEZE_TICK_LIMIT = (int) (UPS * 3);

    /**
     * The WAVE_INTERVAL constant represents when the difficulty of the game should be increased
     */
    public static final int WAVE_INTERVAL = 5;
    /**
     * The WAVE_INTERVAL constant represents when the difficulty of the game should be increased
     */
    public static final float SPAWN_DECREASE_MULTIPLIER = 0.9f;
    public static class Enemies {
        public static int getReward(EnemyType enemyType) {
            return switch (enemyType) {
                case BAT -> 5;
                case HUMANOID -> 25;
                case BEAR -> 15;
                case RAT -> 10;
            };
        }

        public static float getSpeed(EnemyType enemyType) {
            return switch (enemyType) {
                case BAT -> 0.65f;
                case HUMANOID -> 0.35f;
                case BEAR -> 0.45f;
                case RAT -> 0.75f;
            };
        }

        public static int getStartHealth(EnemyType enemyType) {
            return switch (enemyType) {
                case BAT -> 100;
                case BEAR -> 150;
                case HUMANOID -> 425;
                case RAT -> 80;
            };
        }
    }

    public static class Bullets {
        public static float getVelocity(Bullet.BulletType bulletType){
            switch(bulletType) {
                case ARROW -> {return 4.0f;}
                case SHELL -> {return 1.0f;}
                case ICE -> {return 2.0f;}
            }
            return 0;
        }
    }
    public static class Towers {
        public static int getStartDamage(TowerType towerType) {
            switch(towerType) {
                case MAGE -> {return 5;}
                case HUNTER -> {return 7;}
                case ARTILLERY -> {return 6;}
            }
            return 0;
        }
        public static float getFreezeSpeed(TowerType towerType) {
            switch(towerType) {
                case MAGE -> {return 0.6f;}
            }
            return 1;
        }
        public static float getStartFirerate(TowerType towerType) {
            switch(towerType) {
                case MAGE -> {return 60;}
                case HUNTER -> {return 40;}
                case ARTILLERY -> {return 120;}
            }
            return 0;
        }
        public static float getStartRange(TowerType towerType) {
            switch(towerType) {
                case MAGE -> {return 105;}
                case HUNTER -> {return 135;}
                case ARTILLERY -> {return 80;}
            }
            return 0;
        }
        public static int getTowerCost(TowerType towerType) {
            switch(towerType) {
                case MAGE -> {return 50;}
                case HUNTER -> {return 25;}
                case ARTILLERY -> {return 100;}
            }
            return 0;
        }
    }
}
