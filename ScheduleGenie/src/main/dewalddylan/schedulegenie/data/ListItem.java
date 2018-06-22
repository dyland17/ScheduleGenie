package main.dewalddylan.schedulegenie.data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ListItem {
	private String name;
	private int yPos;
	private final int xPos;
	private final int indent;
	private final int height;
	private final int width;
	private MinusButton minusBut;
	
	public ListItem(String name,int y,int width){
		indent = 10;
		height = 20;
		this.width = width;
		this.name = name;
		xPos = 0;
		yPos = y;
		minusBut = new MinusButton((int)(width * .8), (yPos + 3));
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.drawString(name, (xPos + indent), yPos);
		minusBut.paint(g);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(xPos, yPos, width, height);
	}
}
class MinusButton{
	private int xPos;
	private int yPos;
	private final int length;
	
	public MinusButton(int x, int y){
		xPos = x;
		yPos = y;
		this.length = 14;
	}
	
	public void paint(Graphics g){
		//Background light blue color.
		g.setColor(new Color(153, 204, 255));
		g.fillRect(xPos, yPos, length, length);
		//White minus sign
		g.setColor(new Color(242, 242, 242));
		int lineXPos = (int) (xPos + (.1 * length));
		int lineYPos = (int)(yPos + (length/2));
		g.drawLine(lineXPos, lineYPos, (int)(lineXPos + (length * .8)), lineYPos);
		//Black border
		g.setColor(Color.black);
		g.drawRect(xPos, yPos, length, length);
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(xPos, yPos, length, length);
	}
}
