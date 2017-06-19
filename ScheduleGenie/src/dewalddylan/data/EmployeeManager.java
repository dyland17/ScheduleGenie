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
