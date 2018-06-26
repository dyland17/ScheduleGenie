package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Color;
import java.awt.Graphics;

public class PlusButton extends Button{
	private final int horizontalRectX;
	private final int horizontalRectY;
	private final int verticalRectX;
	private final int verticalRectY;

	public PlusButton(int butXPos, int butYPos) {
		super(butXPos, butYPos, Button.PLUSBUTTONSIZE);
		this.horizontalRectX = (int) (this.butXPos + (.15 * this.butLength));
		this.horizontalRectY = (int)(this.butYPos + (.44 * this.butLength));
		this.verticalRectX = ((int)(horizontalRectX + HORIZONTALBARWIDTH/2 - VERTICALBARWIDTH/2));
		this.verticalRectY = ((int)(this.butYPos + this.butLength * .15));
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
}
