package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.EmployeeManager;
import main.dewalddylan.schedulegenie.data.ListItem;
import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class EmployeePanel extends Panel implements MouseListener{
	private static EmployeeManager employeeManager;
	private ArrayList<ListItem> guiList;
	public EmployeePanel(){
		super(GUIDim.SIDEPANELDIM, "EmployeePanel: ");
		init();
		setupPanel();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.drawTitleLineCenteredTop(g2d);
		for(ListItem item: guiList) 
			item.paint(g2d);
	}
	
	@Override
	protected void init(){
		employeeManager = new EmployeeManager();
		guiList = new ArrayList<ListItem>();
	}
	
	@Override
	protected void setupPanel(){
		employeeManager.addEmployee(new Employee("Dylan","Dewald",18,1));
		employeeManager.addEmployee(new Employee("Gary","Anderson",18,2));
		employeeManager.addEmployee(new Employee("Duke","Hill",18,3));
		addEmployees(employeeManager.getEmployeeList());
		addMouseListener(this);
	}
	
	private void addNewEmployee(String name) {
		final int yPos = ListItem.getProperYPos(guiList.size());
		guiList.add(new ListItem(name, yPos));
		ListItem.plusButton.moveButtonDown(yPos);
	}
	
	private void addEmployees(LinkedList<Employee> employeeList) {
		int yPos = 0;
		for(Employee employee: employeeList) {
			yPos = ListItem.getProperYPos(guiList.size());
			ListItem item = new ListItem(employee.getFullName(),yPos);
			guiList.add(item);
		}
		ListItem.plusButton.moveButtonDown(yPos);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		Point clickPoint = new Point(me.getX(),me.getY());
		for(int index = 0; index < guiList.size(); index++) {
			if(guiList.get(index).getBounds().contains(clickPoint)) {
				guiList.get(index).setSelected(true);
				repaint();
			}
		}
	}
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public LinkedList<Employee> getEmployeeList(){
		return employeeManager.getEmployeeList();
	}
	public Employee getSelectedEmployee() {
		return employeeManager.getSelectedEmployee();
	}
}
