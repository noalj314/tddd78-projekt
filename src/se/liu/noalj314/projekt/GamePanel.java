package se.liu.noalj314.projekt;
import java.awt.Graphics;
import java.awt.Dimension;
import se.liu.noalj314.listeners.KeyboardListener;
import se.liu.noalj314.listeners.MouseListener;
import javax.swing.JPanel;
import static se.liu.noalj314.constants.Constants.DIMENSIONX;
import static se.liu.noalj314.constants.Constants.DIMENSIONY;

/**
 * The GamePanel class extends JPanel and represents the main game panel in the game.
 * It handles keyboard and mouse inputs and manages the rendering of the game state.
 */
public class GamePanel extends JPanel
{
    private Game game;
    public GamePanel(Game game){
        this.game = game;
    }
    public void initKeyAndMouse(){
	KeyboardListener keyboardListener = new KeyboardListener(game);
	MouseListener mouseListener = new MouseListener(game);
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
