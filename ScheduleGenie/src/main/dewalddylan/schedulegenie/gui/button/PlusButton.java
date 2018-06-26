package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Color;
import java.awt.Graphics;

public class PlusButton extends Button{
	private int horizontalRectX;
	private int horizontalRectY;
	private int verticalRectX;
	private int verticalRectY;
	private final int butYOffset = 5;

	public PlusButton(int butXPos, int butYPos) {
		super(butXPos, butYPos, Button.PLUSBUTTONSIZE);
		setPlusPositions();
	}

	@Override
	protected void paintUnClickedButton(Graphics g) {
		//Green background
		g.setColor(Color.green);
		g.fillRect(butXPos, butYPos, butLength, butLength);
		//Horizontal bar
		g.setColor(Color.black);
		g.fillRect(horizontalRectX, horizontalRectY, HORIZONTALBARWIDTH, HORIZONTALBARHEIGHT);
		//Vertical bar
		g.fillRect(verticalRectX, verticalRectY, VERTICALBARWIDTH, VERTICALBARHEIGHT);
		//Border
		g.setColor(Color.black);
		g.drawRect(butXPos, butYPos, butLength, butLength);
		
	}

	@Override
	protected void paintClickedButton(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	public void moveButtonDown(int newYPos){
		this.butYPos = newYPos + butYOffset;
		setPlusPositions();
	}
	
	private void setPlusPositions(){
		this.horizontalRectX = (int) (this.butXPos + (.15 * this.butLength));
		this.horizontalRectY = (int)(this.butYPos + (.44 * this.butLength));
		this.verticalRectX = ((int)(horizontalRectX + HORIZONTALBARWIDTH/2 - VERTICALBARWIDTH/2));
		this.verticalRectY = ((int)(this.butYPos + this.butLength * .15));
	}
}
