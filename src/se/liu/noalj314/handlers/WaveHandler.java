package se.liu.noalj314.handlers;

import se.liu.noalj314.Screens.PlayingScreen;
import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.misc.Wave;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.enemies.EnemyType;

import java.util.ArrayList;
import java.util.Random;

public class WaveHandler
{
    private PlayingScreen playingScreen;
    private double spawnTickLimit = Constants.UPS;
    private double spawnTick = spawnTickLimit;
    private double waveLimitTick = Constants.UPS * 5;
    private double waveTick = waveLimitTick;
    private int indexEnemy;
    private int amountOfEnemiesInWave = Constants.STARTINGAMTENEMIES;
    private Wave currentWave;
    private int waveCounter;


    public WaveHandler(PlayingScreen playingScreen) {
	this.playingScreen = playingScreen;
	createNewWave();
    }
    public void update(){
	if (spawnTick < spawnTickLimit) {
	    spawnTick++;
	}
	if (waveTick < waveLimitTick && endOfWave()) {
	    waveTick++;
	}
	if (endOfWave() && timeForWave()){
	    increaseEnemiesForNextWave();
	    createNewWave();
	}
    }
    public void increaseEnemiesForNextWave(){
	amountOfEnemiesInWave = (int) Math.ceil(amountOfEnemiesInWave * 1.3);
    }

    public void createNewWave(){
	Random random = new Random();
	EnemyType[] types = EnemyType.values();
	ArrayList<EnemyType> enemyWaveList = new ArrayList<>();

	for (int i=0 ; i < amountOfEnemiesInWave; i++) {
	    EnemyType randomType = types[random.nextInt(types.length)];
	    enemyWaveList.add(randomType);
	}
	currentWave = new Wave(enemyWaveList);
	indexEnemy = 0;
	waveCounter++;
	if (waveCounter % 5 != 0) {
	    spawnTickLimit *= 0.9;
	}
    }
    public boolean endOfWave(){
	if (enemiesLeftToSpawn()) {
	    return false;
	}
	for (Enemy enemy : playingScreen.getEnemyHandler().getEnemies()) {
	    if (enemy.isAlive()) {
		return false;
	    }
	}
	return true;
    }
    public EnemyType getNextEnemy(){
	spawnTick = 0;
	EnemyType enemyType = currentWave.getEnemies().get(indexEnemy);
	indexEnemy++;
	return enemyType;
    }
    public boolean timeForSpawn(){
	return spawnTick  >= spawnTickLimit;
    }
    public boolean timeForWave(){
	return waveTick  >= waveLimitTick;
    }
    public boolean enemiesLeftToSpawn(){
	return (indexEnemy) < currentWave.getEnemies().size();
    }
    public int getWaveCounter(){
	return waveCounter;
    }


}
