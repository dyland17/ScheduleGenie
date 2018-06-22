package main.dewalddylan.schedulegenie.gui;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.EmployeeManager;
import main.dewalddylan.schedulegenie.data.ListItem;
import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class EmployeePanel extends JPanel{
	private static EmployeeManager employeeManager;
	private ArrayList<ListItem> guiList;
	public EmployeePanel(){
		employeeManager = new EmployeeManager();
		guiList = new ArrayList<ListItem>();
		setupPanel();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		guiList.get(0).paint(g);
	}

	private void setupPanel(){
		setPreferredSize(GUIDim.SIDEPANELDIM);
		guiList.add(new ListItem("Dylan Dewald", 0, getWidth()));
	}
}
