package main.dewalddylan.schedulegenie.gui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import main.dewalddylan.schedulegenie.data.Position;
import main.dewalddylan.schedulegenie.data.SelectionItem;

public class MinusButton extends Button{
	private int minusXPos;
	private int minusYPos;
	
	public MinusButton(Position position){
		super(position, Button.MINUSBUTTONSIZE);
		myPosition = myPosition.newInstance(0, position.yPosPlusOffset(),MINUSBUTTONXOFFSET, -Button.MINUSBUTTONSIZE);
		setupMinusLocation();
	}
	
	public void setLocation(Position position){
		this.myPosition = this.myPosition.newInstance(0, position.yPosPlusOffset(),MINUSBUTTONXOFFSET,-Button.MINUSBUTTONSIZE);
		setupMinusLocation();
	}
	
	private void setupMinusLocation(){
		this.minusXPos = (int) (this.myPosition.xPosPlusOffset() + (.2 * this.butLength));
		this.minusYPos =  (int)(this.myPosition.yPosPlusOffset() + (.48 * this.butLength));
	}
	@Override
	protected void paintUnClickedButton(Graphics2D g2d) {
		//Background red color.
		g2d.setColor(Color.red);
		g2d.fillRect(myPosition.xPosPlusOffset(), myPosition.yPosPlusOffset(), butLength, butLength);
		//White minus sign
		g2d.setColor(Color.white);
		g2d.fillRect(minusXPos, minusYPos,  HORIZONTALBARWIDTH , HORIZONTALBARHEIGHT);
		// black Border
		g2d.setColor(Color.black);
		g2d.drawRect(this.myPosition.xPosPlusOffset(), myPosition.yPosPlusOffset(), butLength, butLength);
		
	}

	//vvvv Have to implement yet. vvvv
	@Override
	protected void paintClickedButton(Graphics2D g2d) {
		
	}	
}
