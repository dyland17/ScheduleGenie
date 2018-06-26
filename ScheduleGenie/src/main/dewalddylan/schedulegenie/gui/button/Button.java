package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Button {
	protected final int butXPos;
	protected final int butYPos;
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
	protected abstract void paintUnClickedButton(Graphics g);
	protected abstract void paintClickedButton(Graphics g);
	
	public void paint(Graphics g){
		//Button when it is not clicked.
		if(!buttonClicked){
			paintUnClickedButton(g);
		}
		else {
			paintClickedButton(g);
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle(butXPos, butYPos, butLength, butLength);
	}
}
