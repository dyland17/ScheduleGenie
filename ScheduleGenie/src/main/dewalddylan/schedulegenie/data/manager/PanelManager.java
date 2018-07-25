package main.dewalddylan.schedulegenie.data.manager;
import java.util.ArrayList;
import java.util.LinkedList;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;
import main.dewalddylan.schedulegenie.gui.MainScreen;
import main.dewalddylan.schedulegenie.gui.panel.EmployeePanel;
import main.dewalddylan.schedulegenie.gui.panel.GraphPanel;
import main.dewalddylan.schedulegenie.gui.panel.InfoPanel;

public class PanelManager {
	private EmployeePanel employeePanel;
	private InfoPanel infoPanel;
	private GraphPanel graphPanel;
	
	
	public PanelManager(EmployeePanel employeePanel, InfoPanel infoPanel, GraphPanel graphPanel) {
		this.employeePanel = employeePanel;
		this.infoPanel = infoPanel;
		this.graphPanel = graphPanel;
	}

	public ArrayList<Employee> getEmployeeList(){
		return employeePanel.getEmployeeList();
	}
	public Employee getSelectedEmployee() {
		return employeePanel.getSelectedEmployee();
	}
	//Updating infoPanel
	private void updateSelectedEmployee(Employee employee) {
		WorkDay currentDay = graphPanel.getCurrentDay();
		infoPanel.displayInfo(employee, currentDay);
	}
	
	public void updateInfoPanel() {
		Employee selectedEmployee = employeePanel.getSelectedEmployee();
		updateSelectedEmployee(selectedEmployee);
	}
	
//	public void updateGraphPanel() {
//		LinkedList<Employee> employeeList = employeePanel.getEmployeeList();
//		graphPanel.pa
//	}
	
	public void paintPanels(){
		employeePanel.repaint();
		graphPanel.repaint();
	}
}
