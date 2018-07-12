package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import main.dewalddylan.schedulegenie.data.names.LabelInfo;

public abstract class Panel extends JPanel{
	public static final int DARKBORDER = 1;
	public static final int LOWERBORDER = 2;
	public static final int RAISEDBORDER = 3;
	public static final int NOTHINGBORDER = 4;
	protected final String TITLE;
	public Panel(Dimension dim, String title){
		setPreferredSize(dim);
		setMinimumSize(dim);
		TITLE = title;
		setBorderLook(RAISEDBORDER);
	}
	
	public Panel(Dimension dim,String title, int borderStyle){
			this(dim,title);
			setBorderLook(borderStyle);
	
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
	
	public void drawTitleLineCenteredTop(Graphics2D g2d){
		g2d.setColor(Color.black);
		g2d.setFont(LabelInfo.TITLEFONT);
		FontMetrics metrics = g2d.getFontMetrics();
		final int titleX = (getWidth()/2) - (metrics.stringWidth(TITLE)/2);
		final int titleY = 20;
		g2d.drawString(TITLE, titleX, titleY);
		g2d.drawLine(0, metrics.getHeight(), getWidth(), metrics.getHeight());
	}

	abstract protected void setupPanel();
	abstract protected void init();
}
