package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class ChartPanel extends Panel{
	private final int GRAPHVERTICALOFFSET = 40;
	private static final int GRAPHHORIZONTALOFFSET = 160;
	private final int LABTIMEOFFSET = 10;
	private final int EMPLOYEEOFFSET = 20;
	private final int NAMEOFFSET = 20;
	private static final int BLOCKWIDTH = 80;
	private static final int BLOCKHEIGHT = 50;
	private int amountOfEmployees;
	
	public ChartPanel(){
		super(GUIDim.MAINPANELDIM, Panel.NOTHINGBORDER);
		//Graph starts out at 9 employee blocks. Will be updated if Employees exceed 9.
		amountOfEmployees = 9;
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
		//Drawing Time frame
		for(int x = 0; x < 24; x++){
			g.drawLine(((x*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET), GRAPHVERTICALOFFSET, ((x*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET), ((9*BLOCKHEIGHT)+GRAPHVERTICALOFFSET));
			if((x+1) >= 12){
				if((x+1) == 12){
					g.drawString((x+1) + "pm", ((x*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
					continue;
				}
				else if ((x+1) == 24){
					g.drawString(((x+1)-12) + "am", ((x*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
					continue;
				}
				g.drawString(((x+1)-12) + "pm", ((x*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
			}
			else{
				g.drawString((x+1) + "am", ((x*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
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
}
