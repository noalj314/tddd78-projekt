package se.liu.noalj314.projekt;
import java.awt.Graphics;
import java.awt.Dimension;
import se.liu.noalj314.listeners.KeyboardListener;
import se.liu.noalj314.listeners.GameMouseListener;
import javax.swing.JPanel;
import static se.liu.noalj314.constants.Constants.DIMENSION_X;
import static se.liu.noalj314.constants.Constants.DIMENSION_Y;

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
	GameMouseListener mouseListener = new GameMouseListener(game);
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
        return new Dimension(DIMENSION_X, DIMENSION_Y);
    }
}
