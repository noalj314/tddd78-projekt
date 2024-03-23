package se.liu.noalj314.handlers;

import se.liu.noalj314.screens.PlayingScreen;
import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.misc.Wave;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.enemies.EnemyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static se.liu.noalj314.constants.Constants.SPAWN_DECREASE_MULTIPLIER;
import static se.liu.noalj314.constants.Constants.WAVE_INTERVAL;

/**
 * The WaveHandler class is responsible for managing the waves of enemies in the game.
 * It maintains the current wave, handles the spawning of enemies, and manages the progression of waves.
 * It also provides methods to create new waves and to increase the number of enemies for the next wave.
 */
public class WaveHandler
{
    private PlayingScreen playingScreen;
    private static final Random RANDOM = new Random();

    private double spawnTickLimit = Constants.UPS;
    private double spawnTick = spawnTickLimit;
    private double waveLimitTick = Constants.UPS * 5;
    private double waveTick = waveLimitTick;
    private int indexEnemy;
    private int amountOfEnemiesInWave = Constants.AMOUNT_OF_ENEMIES;
    private Wave currentWave = null;
    private int waveCounter;


    public WaveHandler(PlayingScreen playingScreen) {
	this.playingScreen = playingScreen;
	createNewWave();
    }
    public void update(){
	if (spawnTick < spawnTickLimit) {
	    spawnTick++;
	}
	if (waveTick < waveLimitTick && isEndOfWave()) {
	    waveTick++;
	}
	if (isEndOfWave() && isTimeForWave()){
	    increaseEnemiesForNextWave();
	    createNewWave();
	}
    }
    public void increaseEnemiesForNextWave(){
	amountOfEnemiesInWave = (int) Math.ceil(amountOfEnemiesInWave * 1.3);
    }

    public void createNewWave(){
	EnemyType[] types = EnemyType.values();
	List<EnemyType> enemyWave = new ArrayList<>();

	for (int i=0 ; i < amountOfEnemiesInWave; i++) {
	    EnemyType randomType = types[RANDOM.nextInt(types.length)];
	    enemyWave.add(randomType);
	}
	currentWave = new Wave(enemyWave);
	indexEnemy = 0;
	waveCounter++;
	if (waveCounter % WAVE_INTERVAL != 0) {
	    spawnTickLimit *= SPAWN_DECREASE_MULTIPLIER;
	}
    }
    public boolean isEndOfWave(){
	if (hasEnemiesToSpawn()) {
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
    public boolean isTimeToSpawn(){
	return spawnTick  >= spawnTickLimit;
    }
    public boolean isTimeForWave(){
	return waveTick  >= waveLimitTick;
    }
    public boolean hasEnemiesToSpawn(){
	return (indexEnemy) < currentWave.getEnemies().size();
    }
    public int getWaveCounter(){
	return waveCounter;
    }
}
