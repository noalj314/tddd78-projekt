package se.liu.noalj314.constants;

import se.liu.noalj314.enemies.Enemy;
import se.liu.noalj314.enemies.EnemyType;

public class Constants
{
    public static class Enemies
    {
        public static int getReward(EnemyType enemyType) {
            switch (enemyType) {
                case BAT:
                    return 5;
                case ORC:
                    return 15;
                case GOBLIN:
                    return 10;
            }
            return 0;
        }

        public static float getSpeed(EnemyType enemyType) {
            switch (enemyType) {
                case BAT:
                    return 0.8f;
                case ORC:
                    return 0.5f;
                case GOBLIN:
                    return 0.65f;
            }
            return 0;
        }
        public static int getStartHealth(EnemyType enemyType) {
            switch (enemyType) {
                case BAT:
                    return 50;
                case ORC:
                    return 75;
                case GOBLIN:
                    return 100;
            }
            return 0;
        }
    }
}
