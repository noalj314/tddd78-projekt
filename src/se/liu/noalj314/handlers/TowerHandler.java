package se.liu.noalj314.handlers;

import se.liu.noalj314.Screens.PlayingScreen;
import se.liu.noalj314.constants.LoadImage;
import se.liu.noalj314.objects.towers.Tower;

import java.awt.*;
import java.util.ArrayList;

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
    }

    public void addTower(Tower chosenTower, Point point) {
        towers.add(new Tower(point, chosenTower.getTowerType(), towerCounter++));
    }

    public boolean checkIfTowerAt(Point position) {
        for (Tower tower: towers) {
            if((tower.getPosition().x/PIXELSIZE) == (position.x / PIXELSIZE)  && (tower.getPosition().y/PIXELSIZE) == (position.y / PIXELSIZE))
                return true;
        }
        return false;
    }
}
