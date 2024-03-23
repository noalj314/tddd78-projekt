package se.liu.noalj314.constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static se.liu.noalj314.constants.Constants.BULLET_SIZE;
import static se.liu.noalj314.constants.Constants.PIXEL_SIZE;

public class LoadImage
{
    /**
     * The grass image used in the game.
     */
    public static BufferedImage grass;

    /**
     * The road image used in the game.
     */
    public static BufferedImage road;

    /**
     * The water image used in the game.
     */
    public static BufferedImage water;

    /**
     * The bat image used in the game.
     */
    public static BufferedImage bat;

    /**
     * The rat image used in the game.
     */
    public static BufferedImage rat;

    /**
     * The bear image used in the game.
     */
    public static BufferedImage bear;

    /**
     * The humanoid image used in the game.
     */
    public static BufferedImage humanoid;

    /**
     * The mage image used in the game.
     */
    public static BufferedImage mage;

    /**
     * The artillery image used in the game.
     */
    public static BufferedImage artillery;

    /**
     * The hunter image used in the game.
     */
    public static BufferedImage hunter;

    /**
     * The arrow image used in the game.
     */
    public static BufferedImage arrow;

    /**
     * The shell image used in the game.
     */
    public static BufferedImage shell;

    /**
     * The ice bolt image used in the game.
     */
    public static BufferedImage icebolt;

    /**
     * The explosion image used in the game.
     */
    public static BufferedImage explosion;

    /**
     * The freeze image used in the game.
     */
    public static BufferedImage freeze;


    static {
	try {
	    grass = loadImage("/images/grass.png");
	    road = loadImage("/images/road.png");
	    water = loadImage("/images/water.png");
	    bat = loadImage("/images/bat.png");
	    rat = loadImage("/images/rat.png");
	    bear = loadImage("/images/bear.png");
	    humanoid = loadImage("/images/humanoid.png");
	    mage = loadImage("/images/mage.png");
	    artillery = loadImage("/images/artillery.png");
	    hunter = loadImage("/images/hunter.png");
	    arrow = loadImage("/images/arrow.png");
	    shell = loadImage("/images/shell.png");
	    icebolt = loadImage("/images/ice.png");
	    explosion = loadImage("/images/explosion.png");
	    freeze = loadImage("/images/freeze.png");
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }
	private static BufferedImage scaleImage(BufferedImage source, int width, int height) {
	    Image tmp = source.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = scaled.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	    return scaled;
    }
    private static BufferedImage loadImage(String path) throws IOException {
	InputStream imgStream = LoadImage.class.getResourceAsStream(path);
	BufferedImage img = ImageIO.read(imgStream);
	return scaleImage(img, Constants.PIXEL_SIZE, Constants.PIXEL_SIZE);
    }
}
