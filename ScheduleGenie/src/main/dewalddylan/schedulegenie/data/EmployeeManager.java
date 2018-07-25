package main.dewalddylan.schedulegenie.data;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class EmployeeManager {
	private ArrayList<Employee> employeeList;
	private Employee selectedEmployee;
	public EmployeeManager(){
		employeeList = new ArrayList<Employee>();
	}
	
	public void add(Employee newEmployee){
		if(newEmployee != null){
			newEmployee.setLocation(getNextEmployeePosition());
			employeeList.add(newEmployee);
		}
	}
	
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public Employee getEmployee(int index){
		return employeeList.get(index);
	}
	public ArrayList<Employee> getEmployeeList(){
		return employeeList;
	}
	
	public void remove(Employee item){
		employeeList.remove(item);
	}
	public Employee findEmployeeByName(String name){
		if(employeeList.size() == 0){
			return null;
		}
		for(Employee employee : employeeList){
			if(employee.fullName().equals(name)){
				return employee;
			}
		}
		return null;
	}
	
	public boolean isListEmpty() {
		return employeeList.isEmpty();
	}
	public void printList(){
		for(Employee employee: employeeList){
			System.out.print("FirstName: " + employee.firstName() + " ");
			System.out.println("LastName: " + employee.lastName());
		}
	}

	public void paint(Graphics2D g2d) {
		for(Employee employee: employeeList){
			employee.paint(g2d);
		}
	}
	
	private Position getNextEmployeePosition(){
		final int yOffset = SelectionItem.HEIGHT * employeeList.size();
		return new Position(0, 0, 0,yOffset);
	}
}
