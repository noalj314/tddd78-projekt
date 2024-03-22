package se.liu.noalj314.constants;

import se.liu.noalj314.objects.Bullet;
import se.liu.noalj314.objects.enemies.EnemyType;
import se.liu.noalj314.objects.towers.Tower;
import se.liu.noalj314.objects.towers.TowerType;

public class Constants
{
    public static final double FPS = 60.0;
    public static final double UPS = 60.0;
    public static final int PIXELSIZE = 48;
    public static final int BULLETSIZE = (int) (PIXELSIZE/ 3.5);
    public static final int DIMENSIONX = 720;
    public static final int DIMENSIONY = 720;
    public static final int AMOUNTOFTILES = 15;
    public static final int STARTINGAMTENEMIES = 3;
    public static final int COINS = 100;
    public static final int HP = 20;
    public static final int FREEZETICKLIMIT = (int) (UPS * 3);
    public static class Enemies {
        public static int getReward(EnemyType enemyType) {
            return switch (enemyType) {
                case BAT -> 5;
                case HUMANOID -> 25;
                case BEAR -> 10;
                case RAT -> 5;
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
                case MAGE -> {return 25;}
                case HUNTER -> {return 25;}
                case ARTILLERY -> {return 25;}
            }
            return 0;
        }
    }
}
