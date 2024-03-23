package se.liu.noalj314.objects.enemies;

import se.liu.noalj314.handlers.EnemyHandler;
/**
 * The Bat class represents a bat enemy in the game.
 * It extends the Enemy abstract class and inherits its properties and methods.
 */
public class Bat extends Enemy
{
    public Bat(float x, float y, EnemyHandler enemyHandler) {
	super(x, y, EnemyType.BAT, enemyHandler);
    }
}
