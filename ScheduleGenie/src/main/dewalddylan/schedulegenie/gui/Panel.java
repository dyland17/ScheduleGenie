package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public abstract class Panel extends JPanel{
	public Panel(Dimension dim){
		setPreferredSize(dim);
		Border roundedBorder = BorderFactory.createLineBorder(Color.black, 2,true);
		//this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		//this.setBorder(roundedBorder);
	}

	abstract protected void setupPanel();
	abstract protected void init();
}
