package se.liu.noalj314.objects.enemies;

import se.liu.noalj314.handlers.EnemyHandler;

public class Bear extends Enemy
{
    public Bear(float x, float y, EnemyHandler enemyHandler) {
	super(x, y, EnemyType.BEAR, enemyHandler);
    }
}
