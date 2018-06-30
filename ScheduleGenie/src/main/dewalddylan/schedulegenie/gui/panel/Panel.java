package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public abstract class Panel extends JPanel{
	
	public static final int DARKBORDER = 1;
	public static final int LOWERBORDER = 2;
	public static final int RAISEDBORDER = 3;
	public static final int NOTHINGBORDER = 4;
	
	public Panel(Dimension dim){
		setPreferredSize(dim);
		setBorderLook();
	}
	
	public Panel(Dimension dim, int borderStyle){
		setPreferredSize(dim);
		setBorderLook(borderStyle);
	}
	
	public void setBorderLook(){
		setBorderLook(RAISEDBORDER);
	}
	
	public void setBorderLook(int borderLook){
		switch(borderLook){
			case 1:
				this.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
				break;
			case 2:
				this.setBorder(BorderFactory.createLoweredBevelBorder());
				break;
			case 3:
				this.setBorder(BorderFactory.createRaisedBevelBorder());
				break;
			case 4:
				this.setBorder(BorderFactory.createEmptyBorder());
				break;
			default:
				this.setBorder(BorderFactory.createRaisedBevelBorder());
		}
	}

	abstract protected void setupPanel();
	abstract protected void init();
}
