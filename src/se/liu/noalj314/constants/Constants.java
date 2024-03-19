package se.liu.noalj314.constants;

import se.liu.noalj314.objects.enemies.EnemyType;
import se.liu.noalj314.objects.towers.Tower;
import se.liu.noalj314.objects.towers.TowerType;

public class Constants
{

    public static final int PIXELSIZE = 48;
    public static final int DIMENSIONX = 720;
    public static final int DIMENSIONY = 720;
    public static final int AMOUNTOFTILES = 15;



    public static class Enemies
    {
        public static int getReward(EnemyType enemyType) {
            switch (enemyType) {
                case BAT:
                    return 5;
                case HUMANOID:
                    return 15;
                case BEAR:
                    return 10;
            }
            return 0;
        }

        public static float getSpeed(EnemyType enemyType) {
            switch (enemyType) {
                case BAT:
                    return 0.4f;
                case HUMANOID:
                    return 0.2f;
                case BEAR:
                    return 0.30f;
                case RAT:
                    return 0.65f;
            }
            return 0;
        }
        public static int getStartHealth(EnemyType enemyType) {
            switch (enemyType) {
                case BAT:
                    return 75;
                case BEAR:
                    return 125;
                case HUMANOID:
                    return 200;
                case RAT:
                    return 50;
            }
            return 0;
        }
    }
    public static class Towers {
        public static float getDamage(TowerType towerType) {
            switch(towerType) {
                case MAGE -> {return 20;}
                case HUNTER -> {return 10;}
                case ARTILLERY -> {return 5;}
            }
            return 0;
        }
        public static float getFirerate(TowerType towerType) {
            switch(towerType) {
                case MAGE -> {return 20;}
                case HUNTER -> {return 10;}
                case ARTILLERY -> {return 5;}
            }
            return 0;
        }
    }
}
