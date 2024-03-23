package se.liu.noalj314.screens;

import se.liu.noalj314.projekt.Game;
/**
 * This is the GameScreen class. It is an abstract class that represents a screen in the game.
 * Each specific game screen extends this class and implement its own logic.
 * It holds a reference to the Game object to interact with the overall game state.
 */
public abstract class GameScreen
{
    private Game game;
    protected GameScreen(Game game){
        this.game =game;
    }

    public Game getGame() {
        return game;
    }
}
