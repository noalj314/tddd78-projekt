package se.liu.noalj314.constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static se.liu.noalj314.constants.Constants.PIXELSIZE;

public class LoadImage
{
    public static BufferedImage grass;
    public static BufferedImage road;
    public static BufferedImage water;
    public static BufferedImage bat, rat, bear, humanoid;
    public static BufferedImage mage, hunter, artillery;






    public static void loadImages(){
	InputStream grassimg = LoadImage.class.getResourceAsStream("/images/grass.png");
	InputStream roadimg = LoadImage.class.getResourceAsStream("/images/road.png");
	InputStream waterimg = LoadImage.class.getResourceAsStream("/images/water.png");
	InputStream batimg = LoadImage.class.getResourceAsStream("/images/bat.png");
	InputStream ratimg = LoadImage.class.getResourceAsStream("/images/rat.png");
	InputStream beartimg = LoadImage.class.getResourceAsStream("/images/bear.png");
	InputStream humanoidimg = LoadImage.class.getResourceAsStream("/images/humanoid.png");
	InputStream mageimg = LoadImage.class.getResourceAsStream("/images/mage.png");
	InputStream artilleryimg = LoadImage.class.getResourceAsStream("/images/artillery.png");
	InputStream hunterimg = LoadImage.class.getResourceAsStream("/images/hunter.png");

	try {
	    grass = ImageIO.read(grassimg);
	    road = ImageIO.read(roadimg);
	    water = ImageIO.read(waterimg);
	    bat = ImageIO.read(batimg);
	    rat = ImageIO.read(ratimg);
	    bear = ImageIO.read(beartimg);
	    humanoid = ImageIO.read(humanoidimg);
	    mage = ImageIO.read(mageimg);
	    artillery = ImageIO.read(artilleryimg);
	    hunter = ImageIO.read(hunterimg);
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
	grass = scaleImage(grass, PIXELSIZE, PIXELSIZE);
	road = scaleImage(road, PIXELSIZE, PIXELSIZE);
	water = scaleImage(water, PIXELSIZE, PIXELSIZE);
	bat = scaleImage(bat, PIXELSIZE, PIXELSIZE);
	rat = scaleImage(rat, PIXELSIZE, PIXELSIZE);
	bear = scaleImage(bear, PIXELSIZE, PIXELSIZE);
	humanoid = scaleImage(humanoid, PIXELSIZE, PIXELSIZE);
	mage = scaleImage(mage, PIXELSIZE, PIXELSIZE);
	artillery = scaleImage(artillery, PIXELSIZE, PIXELSIZE);
	hunter = scaleImage(hunter, PIXELSIZE, PIXELSIZE);
    }
	private static BufferedImage scaleImage(BufferedImage source, int width, int height) {
	    Image tmp = source.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = scaled.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	    return scaled;
    }
}
