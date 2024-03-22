package se.liu.noalj314.Screens;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.gui.Button;
import se.liu.noalj314.handlers.BulletHandler;
import se.liu.noalj314.handlers.EnemyHandler;
import se.liu.noalj314.handlers.TileHandler;
import se.liu.noalj314.handlers.TowerHandler;
import se.liu.noalj314.handlers.WaveHandler;
import se.liu.noalj314.objects.TileType;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.towers.Tower;
import se.liu.noalj314.objects.towers.TowerType;
import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.GameStatus;
import se.liu.noalj314.projekt.MapMaker;

import java.awt.*;
import java.awt.event.KeyEvent;

import static se.liu.noalj314.constants.Constants.COINS;
import static se.liu.noalj314.constants.Constants.DIMENSIONX;
import static se.liu.noalj314.constants.Constants.DIMENSIONY;
import static se.liu.noalj314.constants.Constants.HP;
import static se.liu.noalj314.constants.Constants.PIXELSIZE;
import static se.liu.noalj314.objects.towers.TowerType.ARTILLERY;
import static se.liu.noalj314.objects.towers.TowerType.HUNTER;
import static se.liu.noalj314.objects.towers.TowerType.MAGE;

public class PlayingScreen extends GameScreen implements Methods
{
    private TileType[][] map;
    private TileHandler tileHandler;
    private Button menu;
    private EnemyHandler enemyHandler;
    private TowerHandler towerHandler;
    private BulletHandler bulletHandler;
    private WaveHandler waveHandler;
    private Tower chosenTower;
    private Point mousePos;
    private int coins = COINS;
    private int hp = HP;
    private boolean gameOver;
    private Tower towerClicked;

    public PlayingScreen(final Game game) {
        super(game);
        this.map = MapMaker.getMap();
        this.tileHandler = new TileHandler();
        this.enemyHandler = new EnemyHandler(this);
        this.towerHandler = new TowerHandler(this);
        this.bulletHandler = new BulletHandler(this);
        this.waveHandler = new WaveHandler(this);
    }

    public void update(){
        if(!gameOver) {
            enemyHandler.update();
            towerHandler.update();
            waveHandler.update();
            bulletHandler.update();
        } else {
            getGame().initClasses();
            GameStatus.gameStatus = GameStatus.MENU;
        }
    }

    public void keyPressed(final KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_1 -> this.chosenTower = new Tower(new Point(0,0), TowerType.MAGE, 0);
            case KeyEvent.VK_2 -> this.chosenTower = new Tower(new Point(0,0), TowerType.HUNTER,0);
            case KeyEvent.VK_3 -> this.chosenTower = new Tower(new Point(0,0), TowerType.ARTILLERY, 0);
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
            int towerCost = Constants.Towers.getTowerCost(chosenTower.getTowerType());
            drawTowerRange(g, mousePos.x, mousePos.y, range);
            switch (chosenTower.getTowerType()) {
                case MAGE -> {
                    g.drawImage(LoadImage.mage, mousePos.x, mousePos.y, null);
                    g.drawString("Mage Cost: " + towerCost, (int) (DIMENSIONX * 0.75), (int) (DIMENSIONY * 0.1));
                }
                case ARTILLERY -> {
                    g.drawImage(LoadImage.artillery, mousePos.x, mousePos.y, null);
                    g.drawString("Artillery Cost: " + towerCost, (int) (DIMENSIONX * 0.75), (int) (DIMENSIONY * 0.1));

                }
                case HUNTER -> {
                    g.drawImage(LoadImage.hunter, mousePos.x, mousePos.y, null);
                    g.drawString("Hunter Cost: " + towerCost, (int) (DIMENSIONX * 0.75), (int) (DIMENSIONY * 0.1));
                }
            }
        }
    }
    private void drawTowerRange(Graphics g, int towerX, int towerY, int range){
        g.setColor(Color.black);
        int x = towerX - range + PIXELSIZE / 2;
        int y = towerY - range + PIXELSIZE / 2;
        int diameter = range*2;
        g.drawOval(x, y, diameter, diameter);
    }

    @Override public void mouseClick(Point point) {
        // check that we have chosen a tower and so that we placeit on grass
        if(chosenTower != null && getGame().getTileTypeAt(point.x, point.y).equals(TileType.GRASS)) {
            if (towerHandler.getTowerAt(point) == null)
                if (coins >= Constants.Towers.getTowerCost(chosenTower.getTowerType())) {
                    towerHandler.addTower(chosenTower, new Point((point.x / PIXELSIZE) * PIXELSIZE, (point.y / PIXELSIZE) * PIXELSIZE)); //so it snaps
                    setCoins(coins - Constants.Towers.getTowerCost(chosenTower.getTowerType())); // remove coins
                }
        } else {
            // not trying to buy a tower
            towerClicked = towerHandler.getTowerAt(mousePos);
        }
    }



    @Override public void mouseMove(final Point point) {
            mousePos = new Point((point.x / PIXELSIZE) * PIXELSIZE, (point.y / PIXELSIZE) * PIXELSIZE);             //so it snaps
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
        g.drawString("Waves: " + waveHandler.getWaveCounter(), (int) (DIMENSIONX *0.05), (int)(DIMENSIONY*0.95));
    }

    public void decreaseHP(){
        hp --;
        if (hp <= 0){
            gameOver = true;
        }
    }

    private void renderCoins(Graphics g) {
        g.setColor(Color.yellow);
        g.setFont(new Font("Sans", Font.BOLD, 20));
        g.drawString("Coins:" + coins, (int)( DIMENSIONX * 0.8), (int) (DIMENSIONY*0.05));
    }
    private void renderHP(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Sans", Font.BOLD, 15));
        g.drawString("HP: " + hp, (int)( DIMENSIONX * 0.8), (int) (DIMENSIONY*0.13));
    }

    private void renderHover(final Graphics g) {
        g.setColor(Color.CYAN);
        if(mousePos != null)
            g.drawRect(mousePos.x, mousePos.y, PIXELSIZE, PIXELSIZE);
    }

    private void renderMap(Graphics g) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                TileType tileType = map[y][x];
                g.drawImage(tileHandler.getImage(tileType), x * PIXELSIZE, y * PIXELSIZE, null);
            }
        }
    }

    public void attack( Tower tower,  Enemy enemy) {
        bulletHandler.newBullet(enemy, tower);
    }
    public EnemyHandler getEnemyHandler() {
        return enemyHandler;
    }
    public WaveHandler getWaveHandler() {
        return waveHandler;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}
