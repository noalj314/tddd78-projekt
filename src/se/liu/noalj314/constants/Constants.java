package se.liu.noalj314.constants;

import se.liu.noalj314.objects.enemies.EnemyType;

public class Constants
{

    public static final int PIXELSIZE = 32;

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
                    return 0.8f;
                case HUMANOID:
                    return 0.5f;
                case BEAR:
                    return 0.65f;
            }
            return 0;
        }
        public static int getStartHealth(EnemyType enemyType) {
            switch (enemyType) {
                case BAT:
                    return 50;
                case BEAR:
                    return 75;
                case HUMANOID:
                    return 100;
            }
            return 0;
        }
    }
}
