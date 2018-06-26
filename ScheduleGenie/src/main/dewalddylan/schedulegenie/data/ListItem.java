package main.dewalddylan.schedulegenie.data;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.dewalddylan.schedulegenie.data.names.GUIDim;
import main.dewalddylan.schedulegenie.gui.button.*;

public class ListItem {
	private final String name;
	private final int yPos;
	private final int xPos;
	private final int indent;
	public static final int HEIGHT = 20;
	public static final int WIDTH = GUIDim.SIDEPANELDIM.width;
	public static final Font nameFont = new Font("SansSerif", Font.BOLD, 18);
	private static final int YOFFSET = 18;
	private MinusButton minusBut;
	public static PlusButton plusButton = new PlusButton((int)(WIDTH/2 -Button.PLUSBUTTONSIZE/2),getProperYPos(0));
	
	public ListItem(String name,int yPos){
		this.indent = 10;
		this.name = name;
		this.xPos = 0;
		this.yPos = yPos;
		this.minusBut = new MinusButton((int)(WIDTH * .8), yPos);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.setFont(nameFont);
		g.drawString(name, (xPos + indent), yPos);
		g.drawLine(xPos, yPos, WIDTH, yPos);
		minusBut.paint(g);
		plusButton.paint(g);
	}
	public static int getProperYPos(int listSize){
		return ((listSize * HEIGHT) + YOFFSET);
	}
	
	public void updatePlusButtonPosition(int listSize){
		plusButton.moveButtonDown(getProperYPos(listSize));
	}
	public Rectangle getBounds(){
		return new Rectangle(xPos, yPos, WIDTH, HEIGHT);
	}
}
