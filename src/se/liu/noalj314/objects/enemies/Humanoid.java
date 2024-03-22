package se.liu.noalj314.objects.enemies;

import se.liu.noalj314.handlers.EnemyHandler;

public class Humanoid extends Enemy
{
    public Humanoid(float x, float y, EnemyHandler enemyHandler) {
	super(x, y, EnemyType.HUMANOID, enemyHandler);
    }
}
