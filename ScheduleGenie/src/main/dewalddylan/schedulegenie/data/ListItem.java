package main.dewalddylan.schedulegenie.data;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class ListItem {
	private final String name;
	private final int yPos;
	private final int xPos;
	private final int indent;
	public static final int HEIGHT = 20;
	public static final int WIDTH = GUIDim.SIDEPANELDIM.width;
	private final Font nameFont;
	private final int fontYOffset = 18;
	private MinusButton minusBut;
	
	public ListItem(String name,int y){
		indent = 10;
		this.name = name;
		xPos = 0;
		yPos = (y + fontYOffset);
		minusBut = new MinusButton((int)(WIDTH * .8), yPos);
		nameFont = new Font("SansSerif", Font.BOLD, 18);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.setFont(nameFont);
		g.drawString(name, (xPos + indent), yPos);
		g.drawLine(xPos, yPos, WIDTH, yPos);
		minusBut.paint(g);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(xPos, yPos, WIDTH, HEIGHT);
	}
}
class MinusButton{
	private final int butXPos;
	private final int butYPos;
	private final int minusXPos;
	private final int minusYPos;
	private final int minusWidth;
	private final int minusHeight;
	private final int butLength;
	private boolean buttonClicked;
	
	public MinusButton(int butXPos, int butYPos){
		this.butXPos = butXPos;
		this.butYPos = butYPos - 14;
		this.butLength = 14;
		this.minusXPos = (int) (this.butXPos + (.2 * butLength));
		this.minusYPos =  (int)(this.butYPos + (.48 * butLength));
		this.minusHeight = (int)(butLength * .25);
		this.minusWidth = (int)(butLength * .75);
		buttonClicked = false;
		
	}
	
	public void paint(Graphics g){
		//Minus button when it is not clicked.
		if(!buttonClicked){
			paintMinusButton(g);
		}
		else {
			paintClickedButton(g);
		}
	}
	
	private void paintClickedButton(Graphics g) {
		
	}

	private void paintMinusButton(Graphics g) {
		//Background red color.
		g.setColor(Color.red);
		g.fillRect(butXPos, butYPos, butLength, butLength);
		//White minus sign
		g.setColor(Color.white);
		g.fillRect(minusXPos, minusYPos,  minusWidth , minusHeight);
		// black Border
		g.setColor(Color.black);
		g.drawRect(butXPos, butYPos, butLength, butLength);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(butXPos, butYPos, butLength, butLength);
	}
}
