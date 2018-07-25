package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import main.dewalddylan.schedulegenie.data.Position;

public class PlusButton extends Button{
	private int horizontalRectX;
	private int horizontalRectY;
	private int verticalRectX;
	private int verticalRectY;

	public PlusButton(Position position) {
		super(position, Button.PLUSBUTTONSIZE);
		myPosition = myPosition.newInstance(myPosition.xPos(), myPosition.yPos(), myPosition.xOffset(),5);
		setPlusPositions();
	}

	@Override
	protected void paintUnClickedButton(Graphics2D g2d) {
		//Green background
		g2d.setColor(Color.green);
		g2d.fillRect(myPosition.xPos(),myPosition.yPos(), butLength, butLength);
		//Horizontal bar
		g2d.setColor(Color.black);
		g2d.fillRect(horizontalRectX, horizontalRectY, HORIZONTALBARWIDTH, HORIZONTALBARHEIGHT);
		//Vertical bar
		g2d.fillRect(verticalRectX, verticalRectY, VERTICALBARWIDTH, VERTICALBARHEIGHT);
		//Border
		g2d.setColor(Color.black);
		g2d.drawRect(myPosition.xPos(),myPosition.yPos(), butLength, butLength);
		
	}

	@Override
	protected void paintClickedButton(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}
	public void moveButton(int yOffset){
		myPosition = myPosition.newInstance(myPosition.xPos(), myPosition.yPos() + yOffset);
		setPlusPositions();
	}
	
	private void setPlusPositions(){
		this.horizontalRectX = (int) (this.myPosition.xPos() + (.15 * this.butLength));
		this.horizontalRectY = (int)(this.myPosition.yPos() + (.44 * this.butLength));
		this.verticalRectX = ((int)(horizontalRectX + HORIZONTALBARWIDTH/2 - VERTICALBARWIDTH/2));
		this.verticalRectY = ((int)(this.myPosition.yPos() + this.butLength * .15));
	}
}
