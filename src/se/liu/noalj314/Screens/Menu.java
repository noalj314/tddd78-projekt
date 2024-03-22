package se.liu.noalj314.Screens;

import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.gui.Button;
import se.liu.noalj314.projekt.GameStatus;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.DIMENSIONX;
import static se.liu.noalj314.constants.Constants.DIMENSIONY;
import static se.liu.noalj314.constants.Constants.PIXELSIZE;

public class Menu extends GameScreen implements Methods
{
    private Button start, quit;

    public Menu(final Game game) {
	super(game);
	createButtons();
    }

    private void createButtons() {
	int w = DIMENSIONX / 4;
	int h = w / 4;
	int x = DIMENSIONX / 2 - w / 2;
	int y = DIMENSIONY / 6;
	int yMargin = DIMENSIONY / 8;

	start = new Button(x, y, w, h, "Start");
	quit = new Button(x, y + 2* yMargin, w, h, "Quit");
    }
    private void renderButtons(Graphics g){
	start.render(g);
	quit.render(g);
    }

    @Override public void mouseClick(Point point) {
	if(start.getBorder().contains(point)) {
	    GameStatus.gameStatus = GameStatus.PLAYING;
	}   else if(quit.getBorder().contains(point)) {
	    System.exit(0);
	}
    }

    @Override public void mouseMove(final Point point) {

    }

    @Override public void render(final Graphics g) {
	renderButtons(g);
	renderInfoText(g);
    }

    private void renderInfoText(final Graphics g) {
	g.drawString("Controls are: 1,2,3 for tower selection, escape to deselect tower",(int)(DIMENSIONX*0.2), (int)(DIMENSIONY *0.6));
    }
}
