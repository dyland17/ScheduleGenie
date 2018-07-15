package main.dewalddylan.schedulegenie.data.manager;
import java.util.ArrayList;
import java.util.LinkedList;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;
import main.dewalddylan.schedulegenie.gui.MainScreen;

public class PanelManager {
	private MainScreen mainScreen;
	public PanelManager(MainScreen screen) {
		mainScreen = screen;
	}
	
	public LinkedList<Employee> getEmployeeList(){
		return mainScreen.getEmployeeList();
	}
	public Employee getSelectedEmployee() {
		return mainScreen.getSelectedEmployee();
	}
	
	public void updateSelectedEmployee(Employee employee) {
		WorkDay currentDay = mainScreen.getCurrentDay();
		mainScreen.updateSelectedEmployee(employee, currentDay);
	}
}
