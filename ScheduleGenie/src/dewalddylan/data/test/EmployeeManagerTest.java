package dewalddylan.data.test;

import dewalddylan.data.Employee;
import dewalddylan.data.EmployeeManager;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class EmployeeManagerTest {
	@Test
	public void sortAlphabeticallyTest(){
		EmployeeManager manager = new EmployeeManager();
		manager.addEmployee(new Employee("Tom", "Thomas", 18));
		manager.addEmployee(new Employee("Dylan", "Dewald",23));
		assertEquals("Dewald", manager.getEmployee(0).getLastName());
		manager.addEmployee(new Employee("Andy", "Everett", 20));
		assertEquals("Everett", manager.getEmployee(1).getLastName());
		manager.addEmployee(new Employee("Anthony","Anderson",16));
		assertEquals("Anderson",manager.getEmployee(0));
		manager.printList();
	}
}
