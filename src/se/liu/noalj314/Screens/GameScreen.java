package se.liu.noalj314.Screens;

import se.liu.noalj314.projekt.Game;

public abstract class GameScreen
{
    private Game game;
    public GameScreen(Game game){
        this.game =game;
    }

    public Game getGame() {
        return game;
    }
}
