package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.EmployeeManager;
import main.dewalddylan.schedulegenie.data.ListItem;
import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class EmployeePanel extends Panel implements MouseListener{
	private static EmployeeManager employeeManager;
	private ArrayList<ListItem> guiList;
	public EmployeePanel(){
		super(GUIDim.SIDEPANELDIM);
		employeeManager = new EmployeeManager();
		guiList = new ArrayList<ListItem>();
		setupPanel();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(ListItem item: guiList) 
			item.paint(g);
	}
	@Override
	protected void init(){
		
	}
	@Override
	protected void setupPanel(){
		addNewEmployee("Dylan Dewald");
		addNewEmployee("Gary Anderson");
		addNewEmployee("Duke Hill");
		addMouseListener(this);
	}
	
	private void addNewEmployee(String name) {
		int yPos = ListItem.getProperYPos(guiList.size());
		guiList.add(new ListItem(name, yPos));
		ListItem.plusButton.moveButtonDown(yPos);
	}

	@Override
	public void mouseClicked(MouseEvent mv) {
		System.out.println("X: " + mv.getX() + " Y: " + mv.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
