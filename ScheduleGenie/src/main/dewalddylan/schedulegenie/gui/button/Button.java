package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Button {
	protected  int butXPos;
	protected  int butYPos;
	protected final int butLength;
	protected boolean buttonClicked;
	protected final int HORIZONTALBARWIDTH;
	protected final int HORIZONTALBARHEIGHT;
	protected final int VERTICALBARWIDTH;
	protected final int VERTICALBARHEIGHT;
	public static final int MINUSBUTTONSIZE = 14;
	public static final int PLUSBUTTONSIZE = 20;
	public Button(int butXPos, int butYPos, int butLength){
		this.butXPos = butXPos;
		this.butYPos = butYPos;
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
	
	public Rectangle getBounds(){
		return new Rectangle(butXPos, butYPos, butLength, butLength);
	}
}
