package se.liu.noalj314.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener
{
    @Override public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("dic");
        }
    }

    @Override public void mousePressed(final MouseEvent e) {

    }

    @Override public void mouseReleased(final MouseEvent e) {

    }

    @Override public void mouseEntered(final MouseEvent e) {

    }

    @Override public void mouseExited(final MouseEvent e) {

    }

    @Override public void mouseDragged(final MouseEvent e) {

    }

    @Override public void mouseMoved(final MouseEvent e) {

    }
}
