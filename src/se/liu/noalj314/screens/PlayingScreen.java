package se.liu.noalj314.screens;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.handlers.BulletHandler;
import se.liu.noalj314.handlers.EnemyHandler;
import se.liu.noalj314.handlers.TileHandler;
import se.liu.noalj314.handlers.TowerHandler;
import se.liu.noalj314.handlers.WaveHandler;
import se.liu.noalj314.objects.TileType;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.towers.Artillery;
import se.liu.noalj314.objects.towers.Hunter;
import se.liu.noalj314.objects.towers.Mage;
import se.liu.noalj314.objects.towers.Tower;
import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.GameState;
import se.liu.noalj314.projekt.GameStatus;
import se.liu.noalj314.projekt.MapMaker;

import java.awt.*;
import java.awt.event.KeyEvent;

import static se.liu.noalj314.constants.Constants.DIMENSION_X;
import static se.liu.noalj314.constants.Constants.DIMENSION_Y;
import static se.liu.noalj314.constants.Constants.PIXEL_SIZE;
/**
 * This is the PlayingScreen class. It extends the GameScreen class and implements the Methods interface.
 * It represents the playing screen of the game, where the actual gameplay takes place.
 * It holds references to various handlers for managing game elements such as enemies, towers, bullets, and waves.
 * It also manages the game state, including the player's coins and health points.
 */
public class PlayingScreen extends GameScreen implements Methods
{
    private TileType[][] map;
    private TileHandler tileHandler;
    private EnemyHandler enemyHandler;
    private TowerHandler towerHandler;
    private BulletHandler bulletHandler;
    private WaveHandler waveHandler;
    private GameState gameState;
    private Tower chosenTower = null;
    private Point mousePos = null;
    private Tower towerClicked = null;

    public PlayingScreen(final Game game) {
        super(game);
        this.map = MapMaker.MAP;
        this.gameState = new GameState();
        this.tileHandler = new TileHandler();
        this.enemyHandler = new EnemyHandler(this);
        this.towerHandler = new TowerHandler(this);
        this.bulletHandler = new BulletHandler(this);
        this.waveHandler = new WaveHandler(this);
    }

    public void update(){
        if(!gameState.isGameOver()) {
            enemyHandler.update();
            towerHandler.update();
            waveHandler.update();
            bulletHandler.update();
        } else {
            getGame().initClasses();
            getGame().setGameStatus(GameStatus.MENU);
        }
    }

    public void keyPressed(final KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_1 -> this.chosenTower = new Mage(new Point(0, 0), 0);
            case KeyEvent.VK_2 -> this.chosenTower = new Hunter(new Point(0, 0), 0);
            case KeyEvent.VK_3 -> this.chosenTower = new Artillery(new Point(0, 0), 0);
            case KeyEvent.VK_ESCAPE -> {
                this.chosenTower = null;
                this.towerClicked = null;
            }
        }
    }
    private void renderChosenTower(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Sans", Font.BOLD, 20));
        if (chosenTower != null) {
            int range = (int) chosenTower.getRange();
            drawTowerRange(g, mousePos.x, mousePos.y, range);
            chosenTower.renderImage(g, mousePos);
            chosenTower.renderString(g);
        }
    }
    private void drawTowerRange(Graphics g, int towerX, int towerY, int range){
        g.setColor(Color.black);
        int x = towerX - range + PIXEL_SIZE / 2;
        int y = towerY - range + PIXEL_SIZE / 2;
        int diameter = range*2;
        g.drawOval(x, y, diameter, diameter);
    }

    @Override public void handleMouseClick(Point point) {
        // check that we have chosen a tower and so that we placeit on grass
        if(chosenTower != null && getGame().getTileTypeAt(point.x, point.y).equals(TileType.GRASS)) {
            if (towerHandler.getTowerAt(point) == null) {
                int towerCost = Constants.Towers.getTowerCost(chosenTower.getTowerType());
                if (gameState.getCoins() >= towerCost) {
                    towerHandler.addTower(chosenTower, new Point((point.x / PIXEL_SIZE) * PIXEL_SIZE, (point.y / PIXEL_SIZE) * PIXEL_SIZE)); //so it snaps
                    gameState.setCoins(gameState.getCoins() - towerCost);
                }
            }
        } else {
            // not trying to buy a tower
            towerClicked = towerHandler.getTowerAt(mousePos);
        }
    }
    public void handleMouseMove(final Point point) {
            mousePos = new Point((point.x / PIXEL_SIZE) * PIXEL_SIZE, (point.y / PIXEL_SIZE) * PIXEL_SIZE);             //so it snaps
    }


    @Override public void render(final Graphics g) {
        renderMap(g);
        enemyHandler.render(g);
        towerHandler.render(g);
        bulletHandler.render(g);
        if (chosenTower != null)
            renderChosenTower(g);
        if (towerClicked != null)
            drawTowerRange(g, towerClicked.getPosition().x, towerClicked.getPosition().y, (int) towerClicked.getRange());
        renderHover(g);
        renderCoins(g);
        renderHP(g);
        renderWaveCounter(g);
    }

    private void renderWaveCounter(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Waves: " + waveHandler.getWaveCounter(), (int) (DIMENSION_X * 0.05), (int)(DIMENSION_Y * 0.95));
    }
    private void renderCoins(Graphics g) {
        g.setColor(Color.yellow);
        g.setFont(new Font("Sans", Font.BOLD, 20));
        g.drawString("Coins:" + gameState.getCoins(), (int)(DIMENSION_X * 0.8), (int) (DIMENSION_Y * 0.05));
    }
    private void renderHP(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Sans", Font.BOLD, 15));
        g.drawString("HP: " + gameState.getHp(), (int)(DIMENSION_X * 0.8), (int) (DIMENSION_Y * 0.13));
    }

    private void renderHover(final Graphics g) {
        g.setColor(Color.CYAN);
        if(mousePos != null)
            g.drawRect(mousePos.x, mousePos.y, PIXEL_SIZE, PIXEL_SIZE);
    }

    private void renderMap(Graphics g) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                TileType tileType = map[y][x];
                g.drawImage(tileHandler.getImage(tileType), x * PIXEL_SIZE, y * PIXEL_SIZE, null);
            }
        }
    }

    public void attack( Tower tower,  Enemy enemy) {
        bulletHandler.createBullet(enemy, tower);
    }
    public EnemyHandler getEnemyHandler() {
        return enemyHandler;
    }
    public WaveHandler getWaveHandler() {
        return waveHandler;
    }

    public GameState getGameState() {
        return gameState;
    }
}
