package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SchedulePanel extends JPanel{
	public static final Dimension PANELDIM = new Dimension(540,660);
	public SchedulePanel(){
		this.setPreferredSize(new Dimension(540,660));
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		//Horizontal Lines
		for(int i = 0; i < 24; i++){
			g.drawLine((i*40), 0, (i*40), (getHeight()));
		}
		
	}
}
