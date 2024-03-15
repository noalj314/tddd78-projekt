package se.liu.noalj314.gui;

import java.awt.*;

public class Button
{
    private String string;
    private int x, y, width, height;
    private Rectangle border;
    public Button(int x, int y, int width, int height, String string) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.string = string;
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
	int textWidth = fm.stringWidth(string);
	int textHeight = fm.getHeight();
	int textX = x + (width - textWidth) / 2;
	int textY = y + (height - textHeight) / 2 + fm.getAscent(); // fm.getAscent() is the distance from the baseline to the top of most alphanumeric characters
	g.drawString(string, textX, textY);
    }
    public void setBorder(){
	this.border = new Rectangle(x, y, width,height);
    }
    public Rectangle getBorder(){
	return border;
    }
}
