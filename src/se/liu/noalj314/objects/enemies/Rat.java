package se.liu.noalj314.objects.enemies;

import se.liu.noalj314.handlers.EnemyHandler;
/**
 * The Bear class represents a bat enemy in the game.
 * It extends the Enemy abstract class and inherits its properties and methods.
 */
public class Rat extends Enemy
{
    public Rat(float x, float y, EnemyHandler enemyHandler) {
	super(x, y, EnemyType.RAT, enemyHandler);

    }
}
