package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class ChartPanel extends Panel implements MouseListener{
	private final int GRAPHVERTICALOFFSET = 20;
	private static final int GRAPHHORIZONTALOFFSET = 100;
	private final int LABTIMEOFFSET = 10;
	private final int EMPLOYEEOFFSET = 20;
	private final int NAMEOFFSET = 20;
	private static final int BLOCKWIDTH = 30;
	private static final int BLOCKHEIGHT = 50;
	private int amountOfEmployees;
	private int panelXPoint;
	private int panelYPoint;
	public ChartPanel(){
		super(GUIDim.MAINPANELDIM,Panel.LOWERBORDER);
		//Graph starts out at 9 employee blocks. Will be updated if Employees exceed 9.
		amountOfEmployees = 9;
		panelXPoint = 0;
		panelYPoint = 0;
	}
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		//Horizontal Lines and Vertical Lines
			//S.N. the 10 is not set it is a place value for now.
			//Later, I will implement it based on current number of employees.
		for(int i = 0; i < 10; i++){
			g.drawLine(GRAPHHORIZONTALOFFSET,((i*BLOCKHEIGHT)+ GRAPHVERTICALOFFSET), getWidth(), (i*BLOCKHEIGHT) + GRAPHVERTICALOFFSET);
		}
		//Drawing Times and vertical lines.
		for(int x = 6; x < 24; x+=2){
			g.drawLine((((x - 6)*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET), GRAPHVERTICALOFFSET, (((x - 6)*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET), ((9*BLOCKHEIGHT)+GRAPHVERTICALOFFSET));
			if(x  >= 12){
				if(x == 12){
					g.drawString((x) + "pm", (((x - 6)*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
					continue;
				}
				else if (x == 24){
					g.drawString((x-12) + "am", (((x - 6)*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
					continue;
				}
				g.drawString(((x) -12) + "pm", (((x - 6)*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
			}
			else{
				g.drawString(x + "am", (((x - 6)*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
			}
		}
		int y = 1;
		//Write names in
//		for(Employee employee: MainScreen.employeeMonitor.getEmployeeList()){
//			g.drawString(employee.getFirstName() + " " + employee.getLastName(), EMPLOYEEOFFSET, y*BLOCKHEIGHT + NAMEOFFSET);
//			y++;
//		}
	}

	@Override
	protected void setupPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
