package main.dewalddylan.schedulegenie.data;

import java.util.Collections;
import java.util.LinkedList;

public class EmployeeManager {
	private LinkedList<Employee> employeeList;
	public EmployeeManager(){
		employeeList = new LinkedList<Employee>();
	}
	
	public void addEmployee(Employee newEmployee){
		if(employeeList.isEmpty()){
			employeeList.add(newEmployee);
		}
		else{
			employeeList.add(newEmployee);
			sortAlphabetically();
		}
	}

	private void sortAlphabetically() {
		Employee previousEmployee;
		Employee nextEmployee;
		int sortSize = employeeList.size();
		int listSize = employeeList.size();
		for(int i = 0; i <  listSize; i++){
			for(int n = 0; n < sortSize; n++){
				if((n+1) >= sortSize)
					break;
				previousEmployee = employeeList.get(n);
				nextEmployee = employeeList.get(n+1);
				if(  nextEmployee.getLastName().charAt(0)<previousEmployee.getLastName().charAt(0)){
					Collections.swap(employeeList, (n+1), n);
				}
				else if(nextEmployee.getLastName().charAt(0) == previousEmployee.getLastName().charAt(0)){
					for(int c = 1; c < 6; c++ ){
						if(nextEmployee.getLastName().charAt(c)<previousEmployee.getLastName().charAt(c)){
							Collections.swap(employeeList, (n+1), n);
							break;
						}
					}
				}
			}
			sortSize--;
		}
		
	}
	public Employee getEmployee(int index){
		return employeeList.get(index);
	}
	public void printList(){
		for(Employee employee: employeeList){
			System.out.print("FirstName: " + employee.getFirstName() + " ");
			System.out.println("LastName: " + employee.getLastName());
		}
	}
}