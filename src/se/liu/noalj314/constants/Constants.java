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
    public static final int DIMENSION_X = 720;

    /**
     * The DIMENSIONY constant represents the height of the game window.
     */
    public static final int DIMENSION_Y = 720;

    /**
     * The AMOUNTOFTILES constant represents the number of tiles in the game.
     */
    public static final int AMOUNT_OF_TILES = 15;

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
        /**
         * The speed of a bat in the game.
         */
        public static final float BAT_SPEED = 0.65f;
        /**
         * The speed of a humanoid in the game.
         */
        public static final float HUMANOID_SPEED = 0.35f;
        /**
         * The speed of a bear in the game.
         */
        public static final float BEAR_SPEED = 0.45f;
        /**
         * The speed of a rat in the game.
         */
        public static final float RAT_SPEED = 0.75f;
        /**
         * The health of a bat in the game.
         */
        public static final int BAT_HEALTH = 100;
        /**
         * The health of a humanoid in the game.
         */
        public static final int HUMANOID_HEALTH = 425;
        /**
         * The health of a bear in the game.
         */
        public static final int BEAR_HEALTH = 150;
        /**
         * The health of a rat in the game.
         */
        public static final int RAT_HEALTH = 80;

        public static float getSpeed(EnemyType enemyType) {
            return switch (enemyType) {
                case BAT -> BAT_SPEED;
                case HUMANOID -> HUMANOID_SPEED;
                case BEAR -> BEAR_SPEED;
                case RAT -> RAT_SPEED;
            };
        }

        public static int getStartHealth(EnemyType enemyType) {
            return switch (enemyType) {
                case BAT -> BAT_HEALTH;
                case BEAR -> BEAR_HEALTH;
                case HUMANOID -> HUMANOID_HEALTH;
                case RAT -> RAT_HEALTH;
            };
        }
    }

    public static class Bullets {
        /**
         * The speed of a arrow in the game.
         */
        public static final float ARROW_SPEED = 4.0f;
        /**
         * The speed of a artillery shell in the game.
         */
        public static final float SHELL_SPEED = 1.0f;
        /**
         * The speed of a ice bolt in the game.
         */
        public static final float ICE_SPEED = 2.0f;
        public static float getVelocity(Bullet.BulletType bulletType){
            switch(bulletType) {
                case ARROW -> {return ARROW_SPEED;}
                case SHELL -> {return SHELL_SPEED;}
                case ICE -> {return ICE_SPEED;}
            }
            return 0;
        }
    }
    public static class Towers {
        /**
         * The freeze slow multiplier.
         */
        public static final float FREEZE_MULTIPLIER = 0.6f;
        /**
         * The damage of the mage in the game.
         */
        public static final int MAGE_DAMAGE = 5;
        /**
         * The damage of the hunter in the game.
         */
        public static final int HUNTER_DAMAGE = 7;
        /**
         * The damage of the artillery in the game.
         */
        public static final int ARTILLERY_DAMAGE = 6;
        /**
         * The firerate of the mage in the game.
         */
        public static final int MAGE_FIRERATE = 60;
        /**
         * The firerate of the hunter in the game.
         */
        public static final int HUNTER_FIRERATE = 40;
        /**
         * The firerate of the artillery in the game.
         */
        public static final int ARTILLERY_FIRERATE = 120;
        /**
         * The range of the hunter in the game.
         */
        public static final int HUNTER_RANGE = 135;
        /**
         * The range of the mage in the game.
         */
        public static final int MAGE_RANGE = 105;
        /**
         * The range of the artillery in the game.
         */
        public static final int ARTILLERY_RANGE = 120;
        /**
         * The cost of the hunter in the game.
         */
        public static final int HUNTER_COST = 25;
        /**
         * The cost of the mage in the game.
         */
        public static final int MAGE_COST = 50;
        /**
         * The cost of the artillery in the game.
         */
        public static final int ARTILLERY_COST = 100;
        public static int getTowerCost(TowerType towerType) {
            switch(towerType) {
                case MAGE -> {return MAGE_COST;}
                case HUNTER -> {return HUNTER_COST;}
                case ARTILLERY -> {return ARTILLERY_COST;}
            }
            return 0;
        }
    }
}
