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
import main.dewalddylan.schedulegenie.data.SelectionItem;
import main.dewalddylan.schedulegenie.data.SelectionList;
import main.dewalddylan.schedulegenie.data.names.GUIDim;

import static main.dewalddylan.schedulegenie.data.manager.MouseManager.*;
import static javax.swing.JOptionPane.*;

public class EmployeePanel extends Panel implements MouseListener{
	private static EmployeeManager employeeManager;
	private SelectionList selectionList;
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
		employeeManager.addEmployee(new Employee("Dylan","Dewald",18,1));
		employeeManager.addEmployee(new Employee("Gary","Anderson",18,2));
		employeeManager.addEmployee(new Employee("Duke","Hill",18,3));
		selectionList = SelectionList.convert(employeeManager.getEmployeeList());
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.drawTitleLineCenteredTop(g2d);
		selectionList.paint(g2d);

	}

	private void showUserRemovalDialog(SelectionItem item) {
		int optionSelected = showConfirmDialog(null, "Would you like to remove " +  item);
		if(optionSelected == YES_OPTION){
			remove(item);
		}
		else{
			item.setMinusButtonClicked(false);
		}
		
	}
	private void remove(SelectionItem item){
		selectionList.remove(item);
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
		if(wasThePlusButtonClicked(selectionList.getPlusButtonBounds(), clickPoint)){
			System.out.println("PlusButton was clicked.");
		}
		SelectionItem selectedItem = wasASelectedItemClicked(selectionList, clickPoint);
		if(selectedItem != null){
			if(selectedItem.getMinusButtonClicked()){
				showUserRemovalDialog(selectedItem);
			}
			selectionList.setSelectedItem(selectedItem);;
		}
		else{
			selectionList.resetSelectedItem();
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
