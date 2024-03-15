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
    @Override public void keyTyped(final KeyEvent e) {
    }

    @Override public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P) {
            System.out.println("play");
            GameStatus.gameStatus = PLAYING;
            System.out.println(gameStatus);
        } else if (e.getKeyCode() == KeyEvent.VK_M) {
            GameStatus.gameStatus = MENU;
            System.out.println("menu");
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            GameStatus.gameStatus = OPTIONS;
            System.out.println("menu");
        }
    }


    @Override public void keyReleased(final KeyEvent e) {

    }
}
