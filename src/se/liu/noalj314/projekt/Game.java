package se.liu.noalj314.projekt;

import se.liu.noalj314.Screens.Menu;
import se.liu.noalj314.Screens.PlayingScreen;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.TileType;

import javax.swing.*;
import java.util.ArrayList;

import static se.liu.noalj314.constants.Constants.AMOUNTOFTILES;
import static se.liu.noalj314.constants.Constants.FPS;
import static se.liu.noalj314.constants.Constants.PIXELSIZE;
import static se.liu.noalj314.constants.Constants.UPS;

public class Game extends JFrame implements Runnable
{
    private ArrayList<Enemy> enemyList = new ArrayList();
    private Thread thread;

    // all classes
    private GamePanel gamePanel;
    private Menu menu;
    private TileType[][] map;
    private Render render;
    private PlayingScreen playingScreen;

    public Game(){

	LoadImage.loadImages();
	initClasses();
	this.map = MapMaker.getMap();
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
	thread = new Thread(this);
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

    // inits
    public void initClasses(){
	render = new Render(this);
	menu = new Menu(this);
	gamePanel = new GamePanel(this);
	playingScreen = new PlayingScreen(this);
	menu = new Menu(this);
    }

    // Getters and Setters
    public TileType getTileTypeAt(float x, float y){
	float xTile = x / PIXELSIZE;
	float yTile = y / PIXELSIZE;
	if(xTile < 0 || AMOUNTOFTILES <= xTile )
	    return TileType.WATER;
	if(yTile< 0 || AMOUNTOFTILES <= yTile )
	    return TileType.WATER;
	return map[(int) (y / PIXELSIZE)][(int)x / PIXELSIZE];
    }
    public TileType[][] getTiles() {
	return map;
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
    public void setTiles(TileType tileType, int x, int y) {
	map[y][x] = tileType;
    }

    public static void main(String[] args) {
	Game game = new Game();
	game.gamePanel.initKeyAndMouse();
	game.startGame();
    }
}
