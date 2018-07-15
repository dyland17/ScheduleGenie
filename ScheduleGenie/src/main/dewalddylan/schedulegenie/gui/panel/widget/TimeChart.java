package main.dewalddylan.schedulegenie.gui.panel.widget;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.gui.panel.ChartPanel;
import main.dewalddylan.schedulegenie.tools.LabelGroupFactory;

public class TimeChart {
	private Point drawPoint;
	public static final int BLOCKSIZE = 50;
	public static final int BARYOFFSET = 10;
	private int startHour;
	private int endHour;
	//vvvv Don't leave this field here vvvv
	private final int totalEmployees = 11;
	//^^^^ Don't leave this field here ^^^^
	private final ChartPanel parentPanel;
	private LabelGroup timeLabels;
	private LabelGroup employeeLabels;
	
	public TimeChart(int xPos, int yPos, ChartPanel parentPanel){
		this.drawPoint = new Point(xPos,yPos);
		this.parentPanel = parentPanel;
		this.startHour = 6;
		this.endHour = 22;
		timeLabels = LabelGroupFactory.createTimeLabelsForFullDay(xPos, getChartHeight() + 5);
		//employeeLabels = LabelGroupFactory.createEmployeeLabels(xPos - 20, yPos, parentPanel.getList());
	}
	
	public void moveChart(Point newDrawPoint){
		drawPoint.translate((int)newDrawPoint.getX(), (int)newDrawPoint.getY());
		timeLabels.translate((int)newDrawPoint.getX(), (int)newDrawPoint.getY());
		//employeeLabels.translate((int)newDrawPoint.getX(), (int)newDrawPoint.getY());
	}

	public void paint(Graphics2D g2d){
		timeLabels.paint(g2d);
		//employeeLabels.paint(g2d);
		paintBars(g2d);
		paintChart(g2d);
		
	}
	
	private void paintBars(Graphics2D g2d) {
		//TimeBar bar1 = new TimeBar(drawPoint.x, drawPoint.y + 10, 3);
		TimeBar bar1 = new TimeBar(getXBarPosition(2),getYBarPosition(1), 6);
		bar1.paint(g2d);
	}

	private void paintChart(Graphics2D g2d) {
		//int totalEmployees = parentPanel.getEmployeeCount();
				g2d.setColor(Color.black);
				final int horizontalLines = totalEmployees + 1;
				int xPos = (int) drawPoint.getX();
				int yPos = (int) drawPoint.getY();
				final int chartWidth = getChartWidth();
				final int chartHeight = getChartHeight();
				
				for(int hLine = 0; hLine < horizontalLines; hLine++){
					//Horizontal lines
					final int lineYPos = yPos+(BLOCKSIZE * hLine);
					g2d.drawLine(xPos, lineYPos, chartWidth, lineYPos);	
				}	
				
				final int verticalLines = getTotalHours() + 1;
				for(int vLine = 0; vLine < verticalLines; vLine++){
					//Vertical lines
					final int lineXPos = xPos + (BLOCKSIZE * vLine);
					g2d.drawLine(lineXPos, yPos, lineXPos, chartHeight);
				}
	}
	
	
	private int getTotalHours(){
		return (endHour - startHour);
	}
	
	public int getChartWidth(){
		 return (int)(drawPoint.getX() + (getTotalHours() * BLOCKSIZE));
	}
	
	public int getChartHeight(){
		return (int)(drawPoint.getY() + (totalEmployees * BLOCKSIZE));
	}
	
	public int getYBarPosition(int row) {
		return ((drawPoint.y +BARYOFFSET) + (BLOCKSIZE * row));
	}
	
	public int getXBarPosition(int col) {
		return (drawPoint.x +(BLOCKSIZE * col));
	}
	
}
