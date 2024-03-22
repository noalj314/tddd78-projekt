package se.liu.noalj314.misc;

import se.liu.noalj314.objects.enemies.EnemyType;

import java.util.ArrayList;

public class Wave
{
    private ArrayList<EnemyType>  enemies;
    public Wave(ArrayList<EnemyType> enemies) {
	this.enemies = enemies;
    }

    public ArrayList<EnemyType> getEnemies() {
	return enemies;
    }
}
