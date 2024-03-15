package se.liu.noalj314.Screens;

import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.gui.Button;
import se.liu.noalj314.projekt.GameStatus;

import java.awt.*;

import static se.liu.noalj314.constants.Constants.PIXELSIZE;

public class Menu extends GameScreen implements Methods
{
    private Button start, options, quit;

    public Menu(final Game game) {
	super(game);
	createButtons();
    }

    private void createButtons() {
	int w = 640 / 4;
	int h = w / 4;
	int x = 640 / 2 - w / 2;
	int y = 640 / 6;
	int yMargin = 640 / 8;

	start = new Button(x, y, w, h, "Start");
	options = new Button(x, y + yMargin, w, h, "Options");
	quit = new Button(x, y + 2* yMargin, w, h, "Quit");
    }
    private void renderButtons(Graphics g){
	start.render(g);
	options.render(g);
	quit.render(g);
    }

    @Override public void mouseClick(Point point) {
	if(start.getBorder().contains(point)) {
	    GameStatus.gameStatus = GameStatus.PLAYING;
	} else if(options.getBorder().contains(point)) {
	    GameStatus.gameStatus = GameStatus.OPTIONS;
	}  else if(quit.getBorder().contains(point)) {
	    System.exit(0);
	}
    }

    @Override public void mouseMove(final Point point) {

    }

    @Override public void render(final Graphics g) {
	renderButtons(g);
    }
}
