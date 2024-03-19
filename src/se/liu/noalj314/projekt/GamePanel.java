package se.liu.noalj314.projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import se.liu.noalj314.Listeners.KeyboardListener;
import se.liu.noalj314.Listeners.MouseListener;
import se.liu.noalj314.constants.LoadImage;

import static se.liu.noalj314.constants.Constants.DIMENSIONX;
import static se.liu.noalj314.constants.Constants.DIMENSIONY;

public class GamePanel extends JPanel
{
    private KeyboardListener keyboardListener;
    private MouseListener mouseListener;
    private Game game;
    public GamePanel(Game game){
        this.game = game;
    }
    public void initKeyAndMouse(){
        keyboardListener = new KeyboardListener(game);
        mouseListener = new MouseListener(game);
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        addKeyListener(keyboardListener);
        requestFocus();
    }
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.getRender().drawGameState(g);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DIMENSIONX, DIMENSIONY);
    }
}
