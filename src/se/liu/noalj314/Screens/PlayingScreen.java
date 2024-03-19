package se.liu.noalj314.Screens;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.gui.Button;
import se.liu.noalj314.handlers.EnemyHandler;
import se.liu.noalj314.handlers.TileHandler;
import se.liu.noalj314.handlers.TowerHandler;
import se.liu.noalj314.objects.TileType;
import se.liu.noalj314.objects.towers.Tower;
import se.liu.noalj314.objects.towers.TowerType;
import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.GameStatus;
import se.liu.noalj314.projekt.MapMaker;

import java.awt.*;
import java.awt.event.KeyEvent;

import static se.liu.noalj314.constants.Constants.PIXELSIZE;
import static se.liu.noalj314.objects.towers.TowerType.MAGE;

public class PlayingScreen extends GameScreen implements Methods
{
    private TileType[][] map;
    private TileHandler tileHandler;
    private Button menu;
    private EnemyHandler enemyHandler;
    private TowerHandler towerHandler;
    private Tower chosenTower;
    private Point mousePos;

    public PlayingScreen(final Game game) {
        super(game);
        this.map = MapMaker.getMap();
        this.tileHandler = new TileHandler();
        this.enemyHandler = new EnemyHandler(this, game);
        this.towerHandler = new TowerHandler(this);

        createButtons();
    }
    private void createButtons(){
        menu = new Button(2, 2, 120, 40, "Menu");
    }
    public void update(){
        enemyHandler.update();
        towerHandler.update();
    }

    public void keyPressed(final KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_1 -> this.chosenTower = new Tower(new Point(0,0), TowerType.MAGE, 0);
            case KeyEvent.VK_2 -> this.chosenTower = new Tower(new Point(0,0), TowerType.HUNTER,0);
            case KeyEvent.VK_3 -> this.chosenTower = new Tower(new Point(0,0), TowerType.ARTILLERY, 0);
            case KeyEvent.VK_ESCAPE -> this.chosenTower = null;
        }
    }
    private void renderChosenTower(Graphics g) {
        if (chosenTower != null) {
            switch (chosenTower.getTowerType()) {
                case MAGE -> g.drawImage(LoadImage.mage, mousePos.x, mousePos.y, null);
                case ARTILLERY -> g.drawImage(LoadImage.artillery, mousePos.x, mousePos.y, null);
                case HUNTER -> g.drawImage(LoadImage.hunter, mousePos.x, mousePos.y, null);
            }
        }
    }



    @Override public void mouseClick(final Point point) {
        // check that we have chosen a tower and so that we placeit on grass
        if(chosenTower != null && getGame().getTileTypeAt(point.x, point.y).equals(TileType.GRASS)) {
            if (!towerHandler.checkIfTowerAt(point))
                towerHandler.addTower(chosenTower, new Point((point.x / PIXELSIZE) * PIXELSIZE, (point.y / PIXELSIZE) * PIXELSIZE)); //so it snaps
        }
    }

    @Override public void mouseMove(final Point point) {
            mousePos = new Point((point.x / PIXELSIZE) * PIXELSIZE, (point.y / PIXELSIZE) * PIXELSIZE);             //so it snaps

    }


    @Override public void render(final Graphics g) {
        renderMap(g);
        enemyHandler.render(g);
        towerHandler.render(g);
        if (chosenTower != null)
            renderChosenTower(g);
        renderHover(g);
    }

    private void renderHover(final Graphics g) {
        g.setColor(Color.CYAN);
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
}
