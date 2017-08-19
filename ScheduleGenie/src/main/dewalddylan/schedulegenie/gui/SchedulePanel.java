package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SchedulePanel extends JPanel{
	
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		//Horizontal Lines
		for(int i = 0; i < 24; i++){
			g.drawLine((i*40), 0, (i*40), getHeight());
		}
		
	}
}
