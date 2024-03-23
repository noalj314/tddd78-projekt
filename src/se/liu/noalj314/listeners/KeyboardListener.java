package se.liu.noalj314.listeners;

import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.GameStatus;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * The KeyboardListener class is responsible for handling keyboard events.
 * It extends KeyAdapter to override the keyPressed method for custom behavior.
 */
public class KeyboardListener extends KeyAdapter
{
    private Game game;
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
