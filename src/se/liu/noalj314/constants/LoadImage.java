package se.liu.noalj314.constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static se.liu.noalj314.constants.Constants.BULLET_SIZE;
import static se.liu.noalj314.constants.Constants.PIXEL_SIZE;

/**
 * The LoadImage class is responsible for loading and scaling images used in the game.
 * It provides static methods and fields for accessing the images.
 */
public class LoadImage
{
    /**
     * The grass image used in the game.
     */
    public final static BufferedImage GRASS;

    /**
     * The road image used in the game.
     */
    public final static BufferedImage ROAD;

    /**
     * The water image used in the game.
     */
    public final static BufferedImage WATER;

    /**
     * The bat image used in the game.
     */
    public final static BufferedImage BAT;

    /**
     * The rat image used in the game.
     */
    public final static BufferedImage RAT;

    /**
     * The bear image used in the game.
     */
    public final static BufferedImage BEAR;

    /**
     * The humanoid image used in the game.
     */
    public final static BufferedImage HUMANOID;

    /**
     * The mage image used in the game.
     */
    public final static BufferedImage MAGE;

    /**
     * The artillery image used in the game.
     */
    public final static BufferedImage ARTILLERY;

    /**
     * The hunter image used in the game.
     */
    public final static BufferedImage HUNTER;

    /**
     * The arrow image used in the game.
     */
    public final static BufferedImage ARROW;

    /**
     * The shell image used in the game.
     */
    public final static BufferedImage SHELL;

    /**
     * The ice bolt image used in the game.
     */
    public final static BufferedImage ICE_BOLT;

    /**
     * The explosion image used in the game.
     */
    public final static BufferedImage EXPLOSION;

    /**
     * The freeze image used in the game.
     */
    public final static BufferedImage FREEZE;


    static {
	try {
	    GRASS = loadImage("/images/grass.png", PIXEL_SIZE);
	    ROAD = loadImage("/images/road.png", PIXEL_SIZE);
	    WATER = loadImage("/images/water.png", PIXEL_SIZE);
	    BAT = loadImage("/images/bat.png", PIXEL_SIZE);
	    RAT = loadImage("/images/rat.png", PIXEL_SIZE);
	    BEAR = loadImage("/images/bear.png", PIXEL_SIZE);
	    HUMANOID = loadImage("/images/humanoid.png", PIXEL_SIZE);
	    MAGE = loadImage("/images/mage.png", PIXEL_SIZE);
	    ARTILLERY = loadImage("/images/artillery.png", PIXEL_SIZE);
	    HUNTER = loadImage("/images/hunter.png", PIXEL_SIZE);
	    ARROW = loadImage("/images/arrow.png", BULLET_SIZE);
	    SHELL = loadImage("/images/shell.png", BULLET_SIZE);
	    ICE_BOLT = loadImage("/images/ice.png", BULLET_SIZE);
	    EXPLOSION = loadImage("/images/explosion.png",PIXEL_SIZE);
	    FREEZE = loadImage("/images/freeze.png", PIXEL_SIZE);
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
    private static BufferedImage loadImage(String path, int scaling) throws IOException {
	try (InputStream imgStream = LoadImage.class.getResourceAsStream(path)) {
	    if (imgStream == null) {
		throw new IOException("Resource not found: " + path);
	    }
	    BufferedImage img = ImageIO.read(imgStream);
	    if (img == null) {
		throw new IOException("Failed to read image: " + path);
	    }
	    return scaleImage(img, scaling, scaling);
	}
    }
}
