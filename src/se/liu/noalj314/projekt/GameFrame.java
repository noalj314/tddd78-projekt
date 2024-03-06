package se.liu.noalj314.projekt;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    private Game game;
    private GameComponent gameComponent;
    public GameFrame(Game game){
	this.game = game;
	this.gameComponent = new GameComponent(game);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new BorderLayout());
	this.add(gameComponent, BorderLayout.CENTER);
	this.pack();
	this.setVisible(true);
    }
}
