package se.liu.noalj314.Screens;

import se.liu.noalj314.constants.Constants;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.gui.Button;
import se.liu.noalj314.handlers.EnemyHandler;
import se.liu.noalj314.handlers.TileHandler;
import se.liu.noalj314.objects.TileType;
import se.liu.noalj314.projekt.Game;
import se.liu.noalj314.projekt.GameStatus;
import se.liu.noalj314.projekt.MapMaker;

import java.awt.*;

public class PlayingScreen extends GameScreen implements Methods
{
    private TileType[][] map;
    private TileHandler tileHandler;
    private Button menu;
    private EnemyHandler enemyHandler;
    public PlayingScreen(final Game game) {
        super(game);
        this.map = MapMaker.getMap();
        this.tileHandler = new TileHandler();
        this.enemyHandler = new EnemyHandler(this, game);
        createButtons();
    }
    private void createButtons(){
        menu = new Button(2, 2, 120, 40, "Menu");
    }
    public void update(){
        enemyHandler.update();
    }


    @Override public void mouseClick(final Point point) {
        if(menu.getBorder().contains(point)) {
            GameStatus.gameStatus = GameStatus.MENU;
        }
    }

    @Override public void mouseMove(final Point point) {

    }

    @Override public void render(final Graphics g) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                TileType tileType = map[y][x];
                g.drawImage(tileHandler.getImage(tileType), x * Constants.PIXELSIZE, y * Constants.PIXELSIZE, null);
            }
        }
        //menu.render(g);
        enemyHandler.render(g);
    }
}
