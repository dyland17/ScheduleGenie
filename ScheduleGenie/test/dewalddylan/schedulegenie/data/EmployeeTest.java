package dewalddylan.schedulegenie.data.test;

import org.junit.Test;

import dewalddylan.schedulegenie.data.Employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class EmployeeTest {
	@Test
	public void secondConstructorTest(){
		Employee newEmployee = new Employee("Dylan","Dewald",23,40,"Manager");
		assertEquals(40,newEmployee.getTotalHours());
		assertEquals("Manager",newEmployee.getTitle());
	}
	@Test
	public void isMinorTest(){
		Employee newEmployee = new Employee("Tom","Hawkins",21);
		assertEquals(false,newEmployee.isMinor());
		newEmployee = new Employee("Adam","West",17);
		assertEquals(true,newEmployee.isMinor());
		
		newEmployee.setAge(21);
		assertEquals(false,newEmployee.isMinor());
		newEmployee.setAge(17);
		assertEquals(true,newEmployee.isMinor());
	}
	
	@Test
	public void changeEmployeeFieldsCloneTest(){
		Employee newEmployee = new Employee("Ted","Bearington",18);
		newEmployee.setFirstName("Teddy");
		assertEquals("Teddy",newEmployee.getFirstName());
		
		newEmployee.setLastName("Washington");
		assertEquals("Washington",newEmployee.getLastName());
		
		newEmployee.setAge(17);
		assertEquals(17,newEmployee.getAge());
		
		newEmployee.setTitle("Sales Associate");
		assertEquals("Sales Associate",newEmployee.getTitle());
		
		newEmployee.setTotalHours(40);
		assertEquals(40,newEmployee.getTotalHours());
		
		Employee anotherEmployee = newEmployee.copy();
		assertNotEquals(anotherEmployee,newEmployee);
	}
	
}
