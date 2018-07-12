package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MinusButton extends Button{
	private final int minusXPos;
	private final int minusYPos;
	
	public MinusButton(int butXPos, int butYPos){
		super(butXPos,(butYPos - Button.MINUSBUTTONSIZE), Button.MINUSBUTTONSIZE);
		this.minusXPos = (int) (this.butXPos + (.2 * this.butLength));
		this.minusYPos =  (int)(this.butYPos + (.48 * this.butLength));
		
	}
	
	//vvvv Have to implement yet. vvvv
	@Override
	protected void paintClickedButton(Graphics2D g2d) {
		
	}

	@Override
	protected void paintUnClickedButton(Graphics2D g2d) {
		//Background red color.
		g2d.setColor(Color.red);
		g2d.fillRect(butXPos, butYPos, butLength, butLength);
		//White minus sign
		g2d.setColor(Color.white);
		g2d.fillRect(minusXPos, minusYPos,  HORIZONTALBARWIDTH , HORIZONTALBARHEIGHT);
		// black Border
		g2d.setColor(Color.black);
		g2d.drawRect(butXPos, butYPos, butLength, butLength);
		
	}
	
}
