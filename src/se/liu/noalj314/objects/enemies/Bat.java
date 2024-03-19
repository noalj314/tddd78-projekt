package se.liu.noalj314.objects.enemies;

public class Bat extends Enemy
{
    public Bat( float x,  float y,  int id) {
	super(x, y, EnemyType.BAT, id);
	setStartingHealth();
    }
}
