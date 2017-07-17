package test.dewalddylan.schedulegenie.data.checker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;
import main.dewalddylan.schedulegenie.gui.EditEmployeeScreen;

public class TextFieldCheckerTest {
	private static TextFieldChecker checker;
	@BeforeClass
	public static void setup(){
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
	//vvvv Need to fix this vvvv
	@Rule
		public ExpectedException guiTFException = ExpectedException.none();
	@Test(expected = GUITextFieldException.class)
	public void getRecentErrorsWithErrorsTest() throws GUITextFieldException{
		guiTFException.expect(GUITextFieldException.class);
		EditEmployeeScreen screen = new EditEmployeeScreen(new Employee("#$","25",40));
		checker.check(screen);
		assertEquals(2,checker.getRecentErrors());
	}
}
