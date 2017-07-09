package test.dewalddylan.schedulegenie.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.EmployeeManager;
public class EmployeeManagerTest {
	@Test
	public void sortAlphabeticallyByFirstLetterTest(){
		EmployeeManager manager = new EmployeeManager();
		//First switch with two elements
		manager.addEmployee(new Employee("Tom", "Thomas", 18));
		manager.addEmployee(new Employee("Dylan", "Dewald",23));
		//Moving an element to the middle
		assertEquals("Dewald", manager.getEmployee(0).getLastName());
		manager.addEmployee(new Employee("Andy", "Everett", 20));
		assertEquals("Everett", manager.getEmployee(1).getLastName());
		//Moving name to front
		manager.addEmployee(new Employee("Anthony","Anderson",16));
		assertEquals("Anderson",manager.getEmployee(0).getLastName());
	}
	@Test
	public void sortAlphabeticallySameFirstLetterTest(){
		EmployeeManager manager = new EmployeeManager();
		manager.addEmployee(new Employee("Don", "Phantom",16));
		manager.addEmployee(new Employee("Danny", "Peterson",20));
		assertEquals("Peterson", manager.getEmployee(0).getLastName());
		manager.printList();
	}
	@Test
	public void sortAlphabeticallySameNameTest(){
		EmployeeManager manager = new EmployeeManager();
		manager.addEmployee(new Employee("Don", "Phantom",16));
		manager.addEmployee(new Employee("Danny", "Phantom",20));
		assertEquals("Don", manager.getEmployee(0).getFirstName());
	}
}
