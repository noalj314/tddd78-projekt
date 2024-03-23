package se.liu.noalj314.misc;

import se.liu.noalj314.objects.enemies.EnemyType;
import java.util.List;
/**
 * The Wave class represents a wave of enemies in the game.
 * It maintains a list of enemies that are part of the wave.
 * It provides methods to get the list of enemies in the wave.
 */
public class Wave
{
    private List<EnemyType>  enemies;
    public Wave(List<EnemyType> enemies) {
	this.enemies = enemies;
    }

    public List<EnemyType> getEnemies() {
	return enemies;
    }
}
