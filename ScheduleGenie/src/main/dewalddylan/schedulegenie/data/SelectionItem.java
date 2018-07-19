package main.dewalddylan.schedulegenie.data;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.dewalddylan.schedulegenie.data.names.GUIDim;
import main.dewalddylan.schedulegenie.data.names.LabelInfo;
import main.dewalddylan.schedulegenie.gui.button.*;

public class SelectionItem {
	private final String name;
	private int yPos;
	private final int xPos;
	private final int indent;
	public static final int HEIGHT = 20;
	public static final int WIDTH = GUIDim.SIDEPANELDIM.width;
	public static final int YOFFSET = (18 * 3);
	private boolean selected = false;
	private MinusButton minusBut;
	
	public SelectionItem(String name,int yPos){
		this.indent = 10;
		this.name = name;
		this.xPos = 0;
		this.yPos = yPos;
		this.minusBut = new MinusButton(yPos);
	}
	
	public void paint(Graphics2D g2d){
		//Need to create class to update selected field
		if(selected) {
			g2d.setColor(new Color(0,0,210,120));
			g2d.fill(getBounds());
		}
		g2d.setColor(Color.black);
		g2d.setFont(LabelInfo.PLAINFONT);
		g2d.drawString(name, (xPos + indent), yPos);
		g2d.drawLine(xPos, yPos, WIDTH, yPos);
		minusBut.paint(g2d);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(xPos, yPos-HEIGHT, WIDTH, HEIGHT);
	}
	
	public Rectangle getMinusButtonBounds(){
		return minusBut.getBounds();
	}
	
	public void setMinusButtonClicked(boolean b){
		minusBut.setClicked(b);
	}
	
	public boolean getMinusButtonClicked(){
		return minusBut.getClicked();
	}
	
	public void setSelected(boolean b) {
		selected = b;
	}
	
	public boolean getSelected(){
		return selected;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setLocation(int yPos) {
		this.yPos = yPos;
		minusBut.setYPos(yPos);
		
	}
	
	
}
