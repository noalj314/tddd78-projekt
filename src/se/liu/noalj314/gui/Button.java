package se.liu.noalj314.gui;

import java.awt.*;

/**
 * The Button class represents a GUI button.
 * It contains methods for rendering the button and handling its visual aspects.
 */
public class Button
{
    private String text;
    private int x, y, width, height;
    private Rectangle border = null;
    public Button(int x, int y, int width, int height, String text) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.text = text;
	setBorder();
    }
    public void render(Graphics g) {
	drawRectangle(g);
	drawBorder(g);
	drawText(g);
    }

    private void drawBorder(Graphics g) {
	g.setColor(Color.CYAN);
	g.drawRect(x,y,width,height);
    }

    public void drawRectangle(Graphics g){
	g.setColor(Color.WHITE);
	g.fillRect(x,y,width,height);
    }
    public void drawText(Graphics g){
	g.setColor(Color.BLACK);
	FontMetrics fm = g.getFontMetrics();
	int textWidth = fm.stringWidth(text);
	int textHeight = fm.getHeight();
	int textX = x + (width - textWidth) / 2;
	int textY = y + (height - textHeight) / 2 + fm.getAscent(); // fm.getAscent() is the distance from the baseline to the top of most alphanumeric characters
	g.drawString(text, textX, textY);
    }
    public void setBorder(){
	this.border = new Rectangle(x, y, width,height);
    }
    public Rectangle getBorder(){
	return border;
    }
}
