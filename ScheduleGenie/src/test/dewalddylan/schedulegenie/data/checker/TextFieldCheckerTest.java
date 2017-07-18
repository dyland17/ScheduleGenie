package test.dewalddylan.schedulegenie.data.checker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.SGTextField;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;
import main.dewalddylan.schedulegenie.gui.EditEmployeeScreen;

public class TextFieldCheckerTest {
	private static TextFieldChecker checker;
	@Before
	public void setup(){
		 checker = new TextFieldChecker();
	}
	@Test
	public void utilCheckStringAlphabetForSymbolsTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method utilAlphabetMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonAlphabet", String.class);
		utilAlphabetMethod.setAccessible(true);
		boolean error = (boolean) utilAlphabetMethod.invoke(checker, "#");
		assertTrue(error);
	}
	
	@Test
	public void utilCheckStringAlphabetForWhiteSpaceTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Method utilAlphabetMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonAlphabet", String.class);
		utilAlphabetMethod.setAccessible(true);
		boolean error = (boolean) utilAlphabetMethod.invoke(checker, "Greg er");
		assertFalse(error);
	}
	
	@Test
	public void utilCheckStringAlphabetForDigits() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method utilAlphabetMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonAlphabet", String.class);
		utilAlphabetMethod.setAccessible(true);
		boolean error = (boolean) utilAlphabetMethod.invoke(checker, "98");
		assertTrue(error);
		
	}
	@Test
	public void utilCheckStringDigitForAlphabetTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method utilDigitMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonDigits", String.class);
		utilDigitMethod.setAccessible(true);
		boolean error = (boolean) utilDigitMethod.invoke(checker, "Adam");
		assertTrue(error);
	}
	@Test
	public void utilCheckStringDigitForWhiteSpaceTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method utilDigitMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonDigits", String.class);
		utilDigitMethod.setAccessible(true);
		boolean error = (boolean) utilDigitMethod.invoke(checker, "8 9");
		assertTrue(error);
	}
	
	@Test
	public void utilCheckStringDigitForSymbolsTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method utilDigitMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonDigits", String.class);
		utilDigitMethod.setAccessible(true);
		boolean error = (boolean) utilDigitMethod.invoke(checker, "@$");
		assertTrue(error);
	}
	@Test
	public void utilCheckStringDigitForDigitsTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method utilDigitMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonDigits", String.class);
		utilDigitMethod.setAccessible(true);
		boolean error = (boolean) utilDigitMethod.invoke(checker, "89");
		assertFalse(error);
	}
	
	@Test
	public void getRecentErrorsWithNoErrorsTest() throws GUITextFieldException{
		EditEmployeeScreen screen = new EditEmployeeScreen(new Employee("Adam","West",25));
		checker.check(screen);
		assertEquals(0,checker.getRecentErrors());
	}

	@Test(expected = GUITextFieldException.class)
	public void checkErrorAlphabetTest() throws GUITextFieldException{
		EditEmployeeScreen screen = new EditEmployeeScreen(new Employee("47","West",25));
		checker.check(screen);
	}
	
	@Test(expected = GUITextFieldException.class)
	public void checkErrorDigitTest() throws GUITextFieldException{
		EditEmployeeScreen screen = new EditEmployeeScreen(new Employee("Adam","West",25));
		SGTextField[] allFields = screen.getAllSGTextFields();
		for(SGTextField field: allFields){
			if(field.getTitle().equals("Age")){
				field.setText("Dan");
				break;
			}
		}
		checker.check(screen);
	}
	
	@Test
	public void getRecentErrorsWithErrorsTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method utilDigitMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonDigits", String.class);
		Method utilAlphabetMethod = TextFieldChecker.class.getDeclaredMethod("utilCheckStringForNonAlphabet", String.class);
		utilAlphabetMethod.setAccessible(true);
		utilDigitMethod.setAccessible(true);
		utilDigitMethod.invoke(checker, "Bat");
		utilAlphabetMethod.invoke(checker, "89");
		assertEquals(2,checker.getRecentErrors());
	}
	
}
