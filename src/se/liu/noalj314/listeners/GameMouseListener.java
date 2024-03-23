package se.liu.noalj314.listeners;

import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.GameStatus;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The GameMouseListener class is responsible for handling mouse events in the game.
 * It extends java.awt.event.MouseAdapter and java.awt.event.MouseMotionAdapter to override the necessary methods for custom behavior.
 */
public class GameMouseListener extends MouseAdapter
{
    private Game game;
    public GameMouseListener(Game game){
        this.game =game;
    }
    @Override public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            switch (GameStatus.gameStatus) {
                case PLAYING -> game.getPlayingScreen().handleMouseClick(e.getPoint());
                case MENU -> game.getMenu().handleMouseClick(e.getPoint());
            }
        }
    }
    @Override public void mouseMoved(final MouseEvent e) {
        switch (GameStatus.gameStatus) {
            case PLAYING:
                game.getPlayingScreen().handleMouseMove(e.getPoint());
                break;
            default:
                break;
        }
    }
}
