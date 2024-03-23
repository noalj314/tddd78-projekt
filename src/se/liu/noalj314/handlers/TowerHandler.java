package se.liu.noalj314.handlers;
import java.util.List;
import java.util.ArrayList;
import se.liu.noalj314.objects.towers.Artillery;
import se.liu.noalj314.objects.towers.Hunter;
import se.liu.noalj314.objects.towers.Mage;
import se.liu.noalj314.screens.PlayingScreen;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.towers.Tower;

import java.awt.*;


import static se.liu.noalj314.constants.Constants.PIXEL_SIZE;

/**
 * The TowerHandler class is responsible for managing all the towers in the game.
 * It maintains a list of towers, handles the rendering of the towers, and manages the interaction between towers and enemies.
 * It also provides methods to add new towers and to get a tower at a specific position.
 */
public class TowerHandler
{
    private PlayingScreen playingScreen;
    private List<Tower> towers = new ArrayList<>();
    private int towerCounter = 1;
    public TowerHandler(PlayingScreen playingScreen){
        this.playingScreen = playingScreen;
    }
    public void render(Graphics g){
        for (Tower tower: towers)
           tower.renderImage(g, tower.getPosition());
    }


    public void update() {
        // Specify the generic type for towersCopy to match the towers list
        List<Tower> towersCopy = new ArrayList<>(towers);
        for (Tower tower : towersCopy) {
            tower.update();
            shootEnemy(tower);
        }
    }

    private void shootEnemy(Tower tower) {
        List<Enemy> enemiesCopy = new ArrayList<>(playingScreen.getEnemyHandler().getEnemies());
        for (Enemy enemy : enemiesCopy) {
            if (enemy.isAlive() && isEnemyInRange(enemy, tower) && tower.timeToShoot()) {
                playingScreen.attack(tower, enemy);
                tower.resetFirerateCounter();
            }
        }
    }


    private boolean isEnemyInRange(Enemy enemy, Tower tower) {
        int distance = (int) Math.hypot(Math.abs(enemy.getX() - tower.getPosition().x), Math.abs(enemy.getY() - tower.getPosition().y));
        return distance < tower.getRange();
    }

    public void addTower(Tower chosenTower, Point point) {
        switch(chosenTower.getTowerType()) {
            case MAGE -> towers.add(new Mage(point, chosenTower.getTowerType(), towerCounter));
            case ARTILLERY -> towers.add(new Artillery(point, chosenTower.getTowerType(), towerCounter));
            case HUNTER -> towers.add(new Hunter(point, chosenTower.getTowerType(), towerCounter));
        }
        towerCounter++;
    }


    public Tower getTowerAt(Point position) {
        for (Tower tower: towers) {
            if((tower.getPosition().x / PIXEL_SIZE) == (position.x / PIXEL_SIZE) && (tower.getPosition().y / PIXEL_SIZE) == (position.y / PIXEL_SIZE))
                return tower;
        }
        return null;
    }
}
