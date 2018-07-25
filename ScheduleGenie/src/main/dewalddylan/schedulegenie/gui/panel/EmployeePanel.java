package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.TrayIcon.MessageType;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.EmployeeManager;
import main.dewalddylan.schedulegenie.data.Position;
import main.dewalddylan.schedulegenie.data.SelectionItem;
import main.dewalddylan.schedulegenie.data.SelectionList;
import main.dewalddylan.schedulegenie.data.names.GUIDim;

import static main.dewalddylan.schedulegenie.data.manager.MouseManager.*;
import static javax.swing.JOptionPane.*;

public class EmployeePanel extends Panel implements MouseListener{
	private EmployeeManager employeeManager;
	//private SelectionList selectionList;
	public EmployeePanel(){
		super(GUIDim.SIDEPANELDIM, "EmployeePanel: ");
		init();
		setupPanel();
		
	}
	
	@Override
	protected void init(){
		employeeManager = new EmployeeManager();
	}

	@Override
	protected void setupPanel(){
		
		employeeManager.add(new Employee("Dylan","Dewald",18));
		employeeManager.add(new Employee("Gary","Anderson",18));
		employeeManager.add(new Employee("Duke","Hill",18));
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.drawTitleLineCenteredTop(g2d);
		this.employeeManager.paint(g2d);

	}

	private void showUserRemovalDialog(Employee item) {
		int optionSelected = showConfirmDialog(null, "Would you like to remove " +  item);
		if(optionSelected == YES_OPTION){
			remove(item);
		}
		else{
		//	item.setMinusButtonClicked(false);
		}
		
	}
	private void remove(Employee item){
		employeeManager.remove(item);
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Employee> getEmployeeList(){
		return employeeManager.getEmployeeList();
	}
	public Employee getSelectedEmployee() {
		return employeeManager.getSelectedEmployee();
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		final Point clickPoint = new Point(me.getX(),me.getY());
		ArrayList<Employee> employees = employeeManager.getEmployeeList();
		for(Employee employee: employees){
			if(employee.getBounds().contains(clickPoint.getLocation())){
				System.out.println(employee.fullName() + " was selected.");
				employee.setSelected(true);
			}
		}
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {}

	@Override
	public void mouseExited(MouseEvent me) {}

	@Override
	public void mousePressed(MouseEvent me) {}

}
