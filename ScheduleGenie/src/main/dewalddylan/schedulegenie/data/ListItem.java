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
	private final int YOffset = 18;
	private MinusButton minusBut;
	private static PlusButton pButton = new PlusButton((int)(WIDTH/2 -Button.PLUSBUTTONSIZE/2),140);
	
	public ListItem(String name,int y){
		indent = 10;
		this.name = name;
		xPos = 0;
		yPos = (y + YOffset);
		minusBut = new MinusButton((int)(WIDTH * .8), yPos);
		nameFont = new Font("SansSerif", Font.BOLD, 18);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.setFont(nameFont);
		g.drawString(name, (xPos + indent), yPos);
		g.drawLine(xPos, yPos, WIDTH, yPos);
		minusBut.paint(g);
		pButton.paint(g);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(xPos, yPos, WIDTH, HEIGHT);
	}
}

abstract class Button{
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








class MinusButton extends Button{
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
class PlusButton extends Button{
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
