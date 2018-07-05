package main.dewalddylan.schedulegenie.gui.panel.widget;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import main.dewalddylan.schedulegenie.data.enumerations.LabelState;
import main.dewalddylan.schedulegenie.gui.panel.ChartPanel;

public class TimeChart {
	private Point drawPoint;
	private final int BLOCKSIZE;
	private final ChartPanel parentPanel;
	private TimeLabels timeLabels;
	
	public TimeChart(int xPos, int yPos, ChartPanel parentPanel){
		drawPoint = new Point(xPos,yPos);
		BLOCKSIZE = 50;
		this.parentPanel = parentPanel;
		labelInit();
	}
	
	public TimeChart(int xPos, int yPos, ChartPanel parentPanel, LabelState state){
		this(xPos, yPos, parentPanel);
		timeLabels = new TimeLabels(state);
	}

	private void labelInit() {
		if(timeLabels == null){
			timeLabels = new TimeLabels(LabelState.NONE);
		}
	}
	
	public void moveChart(Point newDrawPoint){
		drawPoint.translate((int)newDrawPoint.getX(), (int)newDrawPoint.getY());
	}

	public void paint(Graphics2D g2d){
		//int totalEmployees = parentPanel.getEmployeeCount();
		// it's not going to stay at 9 it will be replace with method above.
		int totalEmployees = 11;
		final int horizontalLines = totalEmployees + 1;
		int xPos = (int) drawPoint.getX();
		int yPos = (int) drawPoint.getY();
		final int chartWidth = xPos + (timeLabels.getTotalHours() * BLOCKSIZE);
		final int chartHeight = yPos + (totalEmployees * BLOCKSIZE);
		
		for(int hLine = 0; hLine < horizontalLines; hLine++){
			//Horizontal lines
			final int lineYPos = yPos+(BLOCKSIZE * hLine);
			g2d.setColor(Color.black);
			g2d.drawLine(xPos, lineYPos, chartWidth, lineYPos);	
		}	
		
		final int verticalLines = timeLabels.getTotalHours() + 1;
		for(int vLine = 0; vLine < verticalLines; vLine++){
			//Vertical lines
			final int lineXPos = xPos + (BLOCKSIZE * vLine);
			
			g2d.drawLine(lineXPos, yPos, lineXPos, chartHeight);
		}
		
	}
	
}
class TimeLabels{
	private final LabelState labelState;
	private final int startHour;
	private final int endHour;
	/**
	 * 
	 * @param state determines a pre-set values for labels.
	 * 		<h2>Pre-set values:</h2>
	 * 				<p>1. SINGLELABEL: label displayed is 6am.<br>
	 * 					  2. HASLABELS: labels start at 6am to 10pm.<br>
	 * 					  3. NONE: displays no labels at all, which is default.. </p>
	 */
	public TimeLabels(LabelState state){
		labelState = state;
		switch(labelState){
			case SINGLELABEL:
				startHour = 6;
				endHour = 6;
				break;
			case HASLABELS:
				startHour = 6;
				endHour = 22;
				break;
			default :
				startHour = 0;
				endHour = 0;
				
		}
	}
	
	
	public int getTotalHours(){
		switch(labelState){
			case SINGLELABEL:
				return 6;
			case HASLABELS:
				return (endHour - startHour);
			default:
				return 0;
		}
	}


	public int getRegularStartHour() {
		return getRegularHour(startHour);
	}

	public int getRegularEndHour() {
		return getRegularHour(endHour);
	}
	
	private int getRegularHour(int hour){
		if(hour > 12){
			return (hour - 12);
		}
		else{
			return hour;
		}
	}
}
