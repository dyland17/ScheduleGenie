package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class ChartPanel extends Panel implements MouseListener{
	private final int GRAPHVERTICALOFFSET = 20;
	private static final int GRAPHHORIZONTALOFFSET = 120;
	private final int LABTIMEOFFSET = 10;
	private final int EMPLOYEEOFFSET = 20;
	private final int NAMEOFFSET = 20;
	private static final int BLOCKWIDTH = 30;
	private static final int BLOCKHEIGHT = 50;
	private int amountOfEmployees;
	private int viewXPoint;
	private int viewYPoint;
	public ChartPanel(){
		super(GUIDim.MAINPANELDIM,Panel.LOWERBORDER);
		//Graph starts out at 9 employee blocks. Will be updated if Employees exceed 9.
		amountOfEmployees = 9;
		viewXPoint = 0;
		viewYPoint = 0;
		init();
	}
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Color.black);
		//Horizontal Lines and Vertical Lines
			//S.N. the 10 is not set it is a place value for now.
			//Later, I will implement it based on current number of employees.
		for(int i = 0; i < 10; i++){
			g.drawLine(GRAPHHORIZONTALOFFSET,((i*BLOCKHEIGHT)+ GRAPHVERTICALOFFSET), getWidth(), (i*BLOCKHEIGHT) + GRAPHVERTICALOFFSET);
		}
		//Drawing Times and vertical lines.
		for(int x = 6; x < 24; x+=2){
			g2d.drawLine((((x - 6)*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET), GRAPHVERTICALOFFSET, (((x - 6)*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET), ((9*BLOCKHEIGHT)+GRAPHVERTICALOFFSET));
			if(x  >= 12){
				if(x == 12){
					g2d.drawString((x) + "pm", (((x - 6)*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
					continue;
				}
				else if (x == 24){
					g2d.drawString((x-12) + "am", (((x - 6)*BLOCKWIDTH)+ GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
					continue;
				}
				g2d.drawString(((x) -12) + "pm", (((x - 6)*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
			}
			else{
				g2d.drawString(x + "am", (((x - 6)*BLOCKWIDTH)+GRAPHHORIZONTALOFFSET),(((amountOfEmployees + 1)*BLOCKHEIGHT)+LABTIMEOFFSET));
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
		this.addMouseListener(this);
		
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
