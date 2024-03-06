package se.liu.noalj314.projekt;

import javax.swing.*;
import java.awt.*;

public class GameComponent extends JComponent
{
    public static final int SQUARESIZE = 50;
    private Game game;

    public GameComponent(final Game game){
        this.game = game;
    }
    @Override protected void paintComponent( Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        for (int y = 0; y < game.getHeight(); y++) {
            for (int x = 0; x < game.getWidth(); x++) {
                TileType tileType = game.getTileTypeAt(x, y);
                if (tileType == TileType.ROAD) {
                    g2d.setColor(Color.LIGHT_GRAY);
                }
                else {
                    g2d.setColor(Color.GREEN);
                }
                g2d.fillRect(x * SQUARESIZE, y * SQUARESIZE, SQUARESIZE, SQUARESIZE);
                g2d.drawRect(x * SQUARESIZE,y * SQUARESIZE, SQUARESIZE, SQUARESIZE);
            }
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(game.getWidth()*SQUARESIZE,
                             game.getHeight()*SQUARESIZE);
    }
}
