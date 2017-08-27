package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SchedulePanel extends JPanel{
	private final Dimension PANELDIM;
	private final int graphVerticalOffset = 40;
	private final int graphHorizontalOffset = 160;
	private final int labTimeOffset = 10;
	private final int blockWidth = 80;
	private final int blockHeight = 50;
	public SchedulePanel(){
		PANELDIM = new Dimension(((blockWidth*24)+graphHorizontalOffset),550);
		this.setPreferredSize(PANELDIM);
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		//Horizontal Lines and Vertical Lines
			//S.N. the 10 is not set it is a place value for now.
			//Later, I will implement it based on current number of employees.
		for(int i = 0; i < 10; i++){
			g.drawLine(graphHorizontalOffset,((i*blockHeight)+ graphVerticalOffset), getWidth(), (i*blockHeight) + graphVerticalOffset);
		}
		//Drawing Time frame
		for(int x = 0; x < 24; x++){
			g.drawLine(((x*blockWidth)+ graphHorizontalOffset), graphVerticalOffset, ((x*blockWidth)+graphHorizontalOffset), ((9*blockHeight)+graphVerticalOffset));
			if((x+1) >= 12){
				if((x+1) == 12){
					g.drawString((x+1) + "pm", ((x*blockWidth)+ graphHorizontalOffset),((10*blockHeight)+labTimeOffset));
					continue;
				}
				g.drawString(((x+1)-12) + "pm", ((x*blockWidth)+graphHorizontalOffset),((10*blockHeight)+labTimeOffset));
			}
			else{
				g.drawString((x+1) + "am", ((x*blockWidth)+graphHorizontalOffset),((10*blockHeight)+labTimeOffset));
			}
		}
	}
}