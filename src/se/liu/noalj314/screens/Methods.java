package se.liu.noalj314.screens;

import java.awt.*;
/**
 * The Methods interface defines the methods that must be implemented by any class that represents a screen in the game.
 * It includes methods for handling mouse clicks and rendering the screen.
 */
public interface Methods
{
    public void handleMouseClick(Point point);
    public void render(Graphics g);
}
