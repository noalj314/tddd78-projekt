package se.liu.noalj314.projekt;

import se.liu.noalj314.constants.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render
{
    private Game game;
    public Render(Game game){
	this.game = game;
    }

    public void drawGameState(Graphics g) {
    switch (GameStatus.gameStatus) {
	case MENU:
	    game.getMenu().render(g);
	    break;
	case PLAYING:
	    game.getPlayingScreen().render(g);
	    break;
	case OPTIONS:
	    game.getSettings().render(g);
	    break;
    	}
    }
}
