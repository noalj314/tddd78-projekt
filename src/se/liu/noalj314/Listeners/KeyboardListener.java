package se.liu.noalj314.Listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyboardListener implements KeyListener
{
    @Override public void keyTyped(final KeyEvent e) {
    }

    @Override public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A)
            System.out.println("Dick");

    }

    @Override public void keyReleased(final KeyEvent e) {

    }
}
