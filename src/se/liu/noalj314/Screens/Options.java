package se.liu.noalj314.Screens;

import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.projekt.Game;

import java.awt.*;

public class Options extends GameScreen implements Methods
{
    public Options(final Game game) {
	super(game);
    }

    @Override public void mouseClick(Point point) {

    }

    @Override public void mouseMove(final Point point) {

    }

    @Override public void render(final Graphics g) {
	for (int y = 0; y < 20; y++)  {
	    for (int x = 0; x < 20; x++) {
		g.drawImage(LoadImage.water, x * 32, y * 32, null);
	    }
	}
    }
}
