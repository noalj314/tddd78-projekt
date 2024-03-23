package se.liu.noalj314.objects.enemies;

import se.liu.noalj314.handlers.EnemyHandler;
/**
 * The Bear class represents a bat enemy in the game.
 * It extends the Enemy abstract class and inherits its properties and methods.
 */
public class Bear extends Enemy
{
    public Bear(float x, float y, EnemyHandler enemyHandler) {
	super(x, y, EnemyType.BEAR, enemyHandler);
    }
}
