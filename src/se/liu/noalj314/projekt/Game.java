package se.liu.noalj314.projekt;

import se.liu.noalj314.screens.Menu;
import se.liu.noalj314.screens.PlayingScreen;
import se.liu.noalj314.constants.LoadImage;

import se.liu.noalj314.objects.TileType;

import javax.swing.*;


import static se.liu.noalj314.constants.Constants.AMOUNTOFTILES;
import static se.liu.noalj314.constants.Constants.FPS;
import static se.liu.noalj314.constants.Constants.PIXEL_SIZE;
import static se.liu.noalj314.constants.Constants.UPS;

/**
 * The Game class is the main class of the game. It initializes all the necessary classes,
 * sets up the game window, and contains the main game loop. It also handles the game state
 * and switches between the MENU and PLAYING states.
 */
public class Game extends JFrame implements Runnable
{
    private GamePanel gamePanel = null;
    private Menu menu = null;
    private TileType[][] map;
    private Render render = null;
    private PlayingScreen playingScreen = null;
    public void initClasses(){
	render = new Render(this);
	menu = new Menu(this);
	gamePanel = new GamePanel(this);
	playingScreen = new PlayingScreen(this);
    }
    public Game(){
	initClasses();
	this.map = MapMaker.MAP;
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(gamePanel);
	this.setLocationRelativeTo(null);
	this.pack();
	this.setVisible(true);
    }
    private void updateGame() {
	switch (GameStatus.gameStatus) {
	    case PLAYING:
		playingScreen.update();
		break;
	    default:
		break;
	}
    }
    private void startGame(){
	Thread thread = new Thread(this);
	thread.start();
    }

    @Override public void run() {

	double timeForEachUpdate = 1000000000 / UPS; //handles updates
	double timeForEachFrame = 1000000000 / FPS;
	long latestUpdate = System.nanoTime();
	long latestFrame = System.nanoTime();
	//handles rendering

	while (true) {

	    long currentTime = System.nanoTime();
	    //update
	    if (currentTime - latestUpdate >= timeForEachUpdate) {
		latestUpdate = currentTime;
		updateGame();
	    }
	    //painting
	    if (currentTime - latestFrame >= timeForEachFrame) {
		latestFrame = currentTime;
		repaint();
	    }
	}
    }
    /** Getters and setters */
    public TileType getTileTypeAt(float x, float y){
	float xTile = x / PIXEL_SIZE;
	float yTile = y / PIXEL_SIZE;
	if(xTile < 0 || AMOUNTOFTILES <= xTile || yTile< 0 || AMOUNTOFTILES <= yTile )
	    return TileType.WATER;
	return map[(int) (y / PIXEL_SIZE)][(int)x / PIXEL_SIZE];
    }
    public PlayingScreen getPlayingScreen() {
	return playingScreen;
    }
    public Render getRender(){
	return render;
    }
    public Menu getMenu(){
	return menu;
    }

    public static void main(String[] args) {
	Game game = new Game();
	game.gamePanel.initKeyAndMouse();
	game.startGame();
    }
}
