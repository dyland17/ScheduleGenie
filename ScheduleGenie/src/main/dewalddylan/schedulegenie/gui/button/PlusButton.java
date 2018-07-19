package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	protected void paintUnClickedButton(Graphics2D g2d) {
		//Green background
		g2d.setColor(Color.green);
		g2d.fillRect(butXPos, butYPos, butLength, butLength);
		//Horizontal bar
		g2d.setColor(Color.black);
		g2d.fillRect(horizontalRectX, horizontalRectY, HORIZONTALBARWIDTH, HORIZONTALBARHEIGHT);
		//Vertical bar
		g2d.fillRect(verticalRectX, verticalRectY, VERTICALBARWIDTH, VERTICALBARHEIGHT);
		//Border
		g2d.setColor(Color.black);
		g2d.drawRect(butXPos, butYPos, butLength, butLength);
		
	}

	@Override
	protected void paintClickedButton(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}
	public void moveButton(int newYPos){
		butYPos = newYPos + butYOffset;
		setPlusPositions();
	}
	
	private void setPlusPositions(){
		this.horizontalRectX = (int) (this.butXPos + (.15 * this.butLength));
		this.horizontalRectY = (int)(this.butYPos + (.44 * this.butLength));
		this.verticalRectX = ((int)(horizontalRectX + HORIZONTALBARWIDTH/2 - VERTICALBARWIDTH/2));
		this.verticalRectY = ((int)(this.butYPos + this.butLength * .15));
	}
}
