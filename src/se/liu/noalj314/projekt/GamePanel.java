package se.liu.noalj314.projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import se.liu.noalj314.constants.LoadImage;

public class GamePanel extends JPanel
{

    private BufferedImage bat;
    private BufferedImage road;
    private BufferedImage water;
    private BufferedImage grass;

    public GamePanel(){
        this.bat = LoadImage.bat;
        this.grass = LoadImage.grass;
        this.water = LoadImage.bat;
        this.road = LoadImage.grass;
    }
    @Override protected void paintComponent( Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                g2d.drawImage(bat, x*32, y*32, null);
            }
        }
        repaint();
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640,640);
    }
}
