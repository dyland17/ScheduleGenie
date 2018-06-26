package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Color;
import java.awt.Graphics;

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
	protected void paintClickedButton(Graphics g) {
		
	}

	@Override
	protected void paintUnClickedButton(Graphics g) {
		//Background red color.
		g.setColor(Color.red);
		g.fillRect(butXPos, butYPos, butLength, butLength);
		//White minus sign
		g.setColor(Color.white);
		g.fillRect(minusXPos, minusYPos,  HORIZONTALBARWIDTH , HORIZONTALBARHEIGHT);
		// black Border
		g.setColor(Color.black);
		g.drawRect(butXPos, butYPos, butLength, butLength);
		
	}
	
}
