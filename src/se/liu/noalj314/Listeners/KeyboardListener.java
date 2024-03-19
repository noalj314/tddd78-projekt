package se.liu.noalj314.Listeners;

import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.GameStatus;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import static se.liu.noalj314.projekt.GameStatus.*;
import se.liu.noalj314.projekt.GameStatus;

public class KeyboardListener implements KeyListener
{
    private Game game;
    public KeyboardListener(Game game){
        this.game =game;
    }
    @Override public void keyTyped(final KeyEvent e) {
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


    @Override public void keyReleased(final KeyEvent e) {

    }
}
