package se.liu.noalj314.projekt;

import se.liu.noalj314.constants.Constants;

public class GameState {
    private int coins = Constants.COINS;
    private int hp = Constants.HP;
    private boolean gameOver;

    public int getCoins() {
	return coins;
    }

    public void setCoins(int coins) {
	this.coins = coins;
    }

    public int getHp() {
	return hp;
    }

    public void decreaseHp() {
	hp--;
	if (hp <= 0) {
	    gameOver = true;
	}
    }

    public boolean isGameOver() {
	return gameOver;
    }
}