package se.liu.noalj314.objects.enemies;

import se.liu.noalj314.handlers.EnemyHandler;

public class Bat extends Enemy
{
    public Bat(float x, float y, EnemyHandler enemyHandler) {
	super(x, y, EnemyType.BAT, enemyHandler);
    }
}
