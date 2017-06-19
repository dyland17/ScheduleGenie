package dewalddylan.data;

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
			//return;
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
		for(int i = 0; i <  sortSize; i++){
			previousEmployee = employeeList.get(i);
			for(int n = (i+1); n < sortSize; n++){
				nextEmployee = employeeList.get(n);
				if(nextEmployee.getLastName().charAt(0) < previousEmployee.getLastName().charAt(0)){
					Collections.swap(employeeList, (n-1), n);
				}
				previousEmployee = nextEmployee;
			}
			sortSize--;
		}
		
	}
	public Employee getEmployee(int index){
		return employeeList.get(index);
	}
	public void printList(){
		for(Employee employee: employeeList){
			System.out.println("LastName: " + employee.getLastName());
		}
	}
}
