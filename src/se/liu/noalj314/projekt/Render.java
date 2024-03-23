package se.liu.noalj314.projekt;
import java.awt.Graphics;

/**
 * The Render class is responsible for rendering the game state.
 * It switches between the MENU and PLAYING states and calls the appropriate render method
 */
public class Render
{
    private Game game;
    public Render(Game game){
	this.game = game;
    }

    public void drawGameState(Graphics g) {
	switch (game.getGameStatus()) {
	    case MENU:
		game.getMenu().render(g);
		break;
	    case PLAYING:
		game.getPlayingScreen().render(g);
		break;
	}
    }
}
