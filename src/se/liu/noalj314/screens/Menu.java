package se.liu.noalj314.screens;

import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.gui.Button;
import se.liu.noalj314.projekt.GameStatus;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.DIMENSION_X;
import static se.liu.noalj314.constants.Constants.DIMENSION_Y;
/**
 * This is the Menu class. It extends the GameScreen class and implements the Methods interface.
 * It represents the menu screen of the game, providing options to start or quit the game.
 * It holds references to Button objects for user interaction.
 * It also handles mouse click events to control the game status.
 */
public class Menu extends GameScreen implements Methods
{
    private Button start, quit;

    public Menu(final Game game) {
	super(game);
	createButtons();
    }

    private void createButtons() {
	int w = DIMENSION_X / 4;
	int h = w / 4;
	int x = DIMENSION_X / 2 - w / 2;
	int y = DIMENSION_Y / 6;
	int yMargin = DIMENSION_Y / 8;

	start = new Button(x, y, w, h, "Start");
	quit = new Button(x, y + 2* yMargin, w, h, "Quit");
    }
    private void renderButtons(Graphics g){
	start.render(g);
	quit.render(g);
    }

    @Override public void handleMouseClick(Point point) {
	if(start.getBorder().contains(point)) {
	    GameStatus.gameStatus = GameStatus.PLAYING;
	}   else if(quit.getBorder().contains(point)) {
	    System.exit(0);
	}
    }



    @Override public void render(final Graphics g) {
	renderButtons(g);
	renderInfoText(g);
    }

    private void renderInfoText(final Graphics g) {
	g.drawString("Controls are: 1,2,3 for tower selection, escape to deselect tower", (int)(DIMENSION_X * 0.2), (int)(DIMENSION_Y * 0.6));
    }
}
