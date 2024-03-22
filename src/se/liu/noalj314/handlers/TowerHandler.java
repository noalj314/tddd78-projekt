package se.liu.noalj314.handlers;
import java.util.List;
import java.util.ArrayList;

import se.liu.noalj314.Screens.PlayingScreen;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.enemies.Enemy;
import se.liu.noalj314.objects.towers.Tower;

import java.awt.*;


import static se.liu.noalj314.constants.Constants.PIXELSIZE;

public class TowerHandler
{
    private Tower tower;
    private PlayingScreen playingScreen;
    private ArrayList<Tower> towers = new ArrayList<>();
    private int towerCounter = 0;
    public TowerHandler(PlayingScreen playingScreen){
        this.playingScreen = playingScreen;
    }
    public void render(Graphics g){
        for (Tower tower: towers)
            switch(tower.getTowerType()){
                case MAGE -> g.drawImage(LoadImage.mage, tower.getPosition().x, tower.getPosition().y, null);
                case HUNTER -> g.drawImage(LoadImage.hunter, tower.getPosition().x, tower.getPosition().y, null);
                case ARTILLERY -> g.drawImage(LoadImage.artillery, tower.getPosition().x, tower.getPosition().y, null);
            }
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
            if (enemy.isAlive() && enemyInRange(enemy, tower) && tower.timeToShoot()) {
                playingScreen.attack(tower, enemy);
                tower.resetFirerateCounter();
            }
        }
    }


    private boolean enemyInRange(Enemy enemy, Tower tower) {

        int distance = (int) Math.hypot(Math.abs(enemy.getX() - tower.getPosition().x), Math.abs(enemy.getY() - tower.getPosition().y));
        return distance < tower.getRange();
    }

    public void addTower(Tower chosenTower, Point point) {
        towers.add(new Tower(point, chosenTower.getTowerType(), towerCounter++));
    }

    public Tower getTowerAt(Point position) {
        for (Tower tower: towers) {
            if((tower.getPosition().x/PIXELSIZE) == (position.x / PIXELSIZE)  && (tower.getPosition().y/PIXELSIZE) == (position.y / PIXELSIZE))
                return tower;
        }
        return null;
    }
}
