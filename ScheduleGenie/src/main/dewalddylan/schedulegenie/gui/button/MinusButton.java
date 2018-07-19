package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import main.dewalddylan.schedulegenie.data.SelectionItem;

public class MinusButton extends Button{
	private int minusXPos;
	private int minusYPos;
	
	public MinusButton(int butYPos){
		super((int)(SelectionItem.WIDTH * .8),(butYPos - Button.MINUSBUTTONSIZE), Button.MINUSBUTTONSIZE);
		setupMinusLocation();
	}
	
	//vvvv Have to implement yet. vvvv
	@Override
	protected void paintClickedButton(Graphics2D g2d) {
		
	}
	public void setYPos(int yPos){
		this.butYPos = yPos  - Button.MINUSBUTTONSIZE;
		setupMinusLocation();
	}
	
	private void setupMinusLocation(){
		this.minusXPos = (int) (this.butXPos + (.2 * this.butLength));
		this.minusYPos =  (int)(this.butYPos + (.48 * this.butLength));
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
