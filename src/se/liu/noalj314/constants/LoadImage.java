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
    public static BufferedImage bat;

    public static  void loadImages(){
	InputStream grassimg = LoadImage.class.getResourceAsStream("/images/grass.png");
	InputStream roadimg = LoadImage.class.getResourceAsStream("/images/road.png");
	InputStream waterimg = LoadImage.class.getResourceAsStream("/images/water.png");
	InputStream batimg = LoadImage.class.getResourceAsStream("/images/bat.png");
	try {
	    grass = ImageIO.read(grassimg);
	    road = ImageIO.read(roadimg);
	    water = ImageIO.read(waterimg);
	    bat = ImageIO.read(batimg);
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }
}
