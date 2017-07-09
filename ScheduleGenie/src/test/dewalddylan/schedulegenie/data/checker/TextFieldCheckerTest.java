package test.dewalddylan.schedulegenie.data.checker;

import org.junit.Test;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;

public class TextFieldCheckerTest {
	
	@Test
	public void isAlphabetTest(){
		TextFieldChecker checker = new TextFieldChecker();
		checker.checkEmployeeForNonAlphabetChars(new Employee("@#","Dewalt",23));
	}
}
