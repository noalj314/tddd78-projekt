package se.liu.noalj314.constants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadImage
{
    public static BufferedImage grass;
    public static BufferedImage road;
    public static BufferedImage water;
    public static BufferedImage bat, rat, bear, humanoid;



    public static void loadImages(){
	InputStream grassimg = LoadImage.class.getResourceAsStream("/images/grass.png");
	InputStream roadimg = LoadImage.class.getResourceAsStream("/images/road.png");
	InputStream waterimg = LoadImage.class.getResourceAsStream("/images/water.png");
	InputStream batimg = LoadImage.class.getResourceAsStream("/images/bat.png");
	InputStream ratimg = LoadImage.class.getResourceAsStream("/images/rat.png");
	InputStream beartimg = LoadImage.class.getResourceAsStream("/images/bear.png");
	InputStream humanoidimg = LoadImage.class.getResourceAsStream("/images/humanoid.png");
	try {
	    grass = ImageIO.read(grassimg);
	    road = ImageIO.read(roadimg);
	    water = ImageIO.read(waterimg);
	    bat = ImageIO.read(batimg);
	    rat = ImageIO.read(ratimg);
	    bear = ImageIO.read(beartimg);
	    humanoid = ImageIO.read(humanoidimg);
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }
}
