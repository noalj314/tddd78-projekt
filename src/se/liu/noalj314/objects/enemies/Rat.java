package se.liu.noalj314.objects.enemies;

import se.liu.noalj314.handlers.EnemyHandler;

public class Rat extends Enemy
{
    public Rat(float x, float y, EnemyHandler enemyHandler) {
	super(x, y, EnemyType.RAT, enemyHandler);

    }
}
