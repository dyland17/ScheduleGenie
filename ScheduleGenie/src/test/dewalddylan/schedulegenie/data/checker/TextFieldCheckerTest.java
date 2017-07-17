package test.dewalddylan.schedulegenie.data.checker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;
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
}
