package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.names.ChartViewLimit;
import main.dewalddylan.schedulegenie.data.names.GUIDim;
import main.dewalddylan.schedulegenie.gui.panel.widget.TimeChart;
import static main.dewalddylan.schedulegenie.tools.PointMath.*;

public class ChartPanel extends Panel implements MouseListener{
	private final int GRAPHVERTICALOFFSET = 20;
	private static final int GRAPHHORIZONTALOFFSET = 120;
	private TimeChart chart;
	private Point viewPoint;
	private Point pressedPoint;
	public ChartPanel(){
		super(GUIDim.MAINPANELDIM,"ChartPanel: ",Panel.LOWERBORDER);
		chart = new TimeChart(20,20,this);
		viewPoint = new Point();
		pressedPoint = new Point();
		init();
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g; 
		chart.paint(g2d);
		
	}

	@Override
	protected void setupPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void init() {
		this.addMouseListener(this);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		pressedPoint.move(e.getX(), e.getY());
		System.out.println("X: " + e.getX() + "Y: " + e.getY());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//Point deltaPoint = new Point((int)(pressedPoint.getX() - e.getX()),(int)(pressedPoint.getY() - e.getY()));
		Point deltaPoint = getDeltaPoint(e.getPoint(), pressedPoint);
	
		chart.moveChart(deltaPoint);
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
