package se.liu.noalj314.objects.enemies;

public class Humanoid extends Enemy
{
    public Humanoid( float x,  float y,  int id) {
	super(x, y, EnemyType.HUMANOID, id);
	setStartingHealth();
    }
}
