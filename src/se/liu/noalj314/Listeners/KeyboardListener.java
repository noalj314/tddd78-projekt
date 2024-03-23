package se.liu.noalj314.Listeners;

import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.GameStatus;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter
{
Game game;
    public KeyboardListener(Game game){
        this.game =game;
    }

    @Override public void keyPressed(final KeyEvent e) {
        switch (GameStatus.gameStatus) {
            case PLAYING:
                game.getPlayingScreen().keyPressed(e);
                break;
            default:
                break;
        }
    }

}
