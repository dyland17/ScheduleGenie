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
	private Position myPosition;
	public static final int HEIGHT = 20;
	public static final int WIDTH = GUIDim.SIDEPANELDIM.width;
	public static final int TITLE_OFFSET = (18*3);
	public static final int WORD_INDENT = 10;
	private boolean selected;
	private MinusButton minusBut;
	public SelectionItem(String name){
		this.myPosition = new Position(WORD_INDENT,TITLE_OFFSET,0,0);
		this.selected = false;
		this.name = name;
		this.minusBut = new MinusButton(myPosition);
	}
	
	public SelectionItem(String name,Position position){
		this(name);
		myPosition = new Position(WORD_INDENT,TITLE_OFFSET, 0, position.yPosPlusOffset());
		this.minusBut = new MinusButton(myPosition);
	}
	
	public void paint(Graphics2D g2d){
		//Need to create class to update selected field
		if(selected) {
			g2d.setColor(new Color(0,0,210,120));
			g2d.fill(getBounds());
		}
		int trueY = myPosition.yPosPlusOffset();
		int trueX = myPosition.xPosPlusOffset();
		
		g2d.setColor(Color.black);
		g2d.setFont(LabelInfo.PLAINFONT);
		g2d.drawString(name, trueX, trueY);
		g2d.drawLine(0,trueY, WIDTH,trueY);
		minusBut.paint(g2d);
	}
	
	public Rectangle getBounds(){
		int xPos = 0;
		int yPos = myPosition.yPosPlusOffset();
		return new Rectangle(xPos, yPos-HEIGHT, WIDTH, HEIGHT);
	}
	
	public int yPos(){
		return myPosition.yPos();
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

	public void setLocation(Position position) {
		this.myPosition = this.myPosition.newInstance(myPosition.xPos(), myPosition.yPos(), 0, position.yOffset());
		minusBut.setLocation(myPosition);
		
	}
	
}
