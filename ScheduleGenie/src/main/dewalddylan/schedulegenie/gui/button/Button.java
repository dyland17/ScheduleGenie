package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.dewalddylan.schedulegenie.data.Position;
import main.dewalddylan.schedulegenie.data.SelectionItem;

public abstract class Button {
	protected Position myPosition;
	protected final int butLength;
	protected boolean buttonClicked;
	protected final int HORIZONTALBARWIDTH;
	protected final int HORIZONTALBARHEIGHT;
	protected final int VERTICALBARWIDTH;
	protected final int VERTICALBARHEIGHT;
	public static final int MINUSBUTTONXOFFSET = (int)(SelectionItem.WIDTH * .8);
	public static final int MINUSBUTTONSIZE = 14;
	public static final int PLUSBUTTONSIZE = 20;
	public Button(Position position, int butLength){
		myPosition = new Position(position);
		this.butLength = butLength;
		HORIZONTALBARWIDTH = ((int)(butLength * .75));
		HORIZONTALBARHEIGHT = ((int)(butLength * .25));
		VERTICALBARWIDTH = ((int)(butLength * .25));
		VERTICALBARHEIGHT = ((int)(butLength * .75));
		buttonClicked = false;
	}
	protected abstract void paintUnClickedButton(Graphics2D g2d);
	protected abstract void paintClickedButton(Graphics2D g2d);
	
	public void paint(Graphics2D g2d){
		//Button when it is not clicked.
		if(!buttonClicked){
			paintUnClickedButton(g2d);
		}
		else {
			paintClickedButton(g2d);
		}
	}
	public void setClicked(boolean b){
		buttonClicked = b;
	}
	
	public boolean getClicked() {
		return buttonClicked;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(myPosition.xPos(), myPosition.yPos(), butLength, butLength);
	}
}
