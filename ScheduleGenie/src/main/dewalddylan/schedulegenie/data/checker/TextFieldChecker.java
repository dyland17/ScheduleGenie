package main.dewalddylan.schedulegenie.data.checker;

import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;

public class TextFieldChecker {
	private int errors = 0;
	private boolean firstNameError;
	private boolean lastNameError;
	private boolean ageError;
	private boolean titleError;
	private boolean totalHourError;
	
	public TextFieldChecker(){
		firstNameError = false;
		lastNameError = false;
		ageError = false;
		titleError = false;
		totalHourError = false;
	}
	public void check(Employee checkEmployee, JTextField tfAge, JTextField tfTotalHours)throws GUITextFieldException{
		checkEmployeeForNonAlphabetChars(checkEmployee);
		checkFieldsForDigits(tfAge,tfTotalHours);
		if(errors > 0){
			throw new GUITextFieldException(this);
		}
	}
	private void checkFieldsForDigits(JTextField tfAge, JTextField tfTotalHours) {
		ageError = utilCheckStringForNonDigits(tfAge.getText());
		totalHourError = utilCheckStringForNonDigits(tfTotalHours.getText());
		
	}
	public void  checkEmployeeForNonAlphabetChars(Employee checkEmployee){
		firstNameError = utilCheckStringForNonAlphabet(checkEmployee.getFirstName());
		lastNameError = utilCheckStringForNonAlphabet(checkEmployee.getLastName());
		titleError = utilCheckStringForNonAlphabet(checkEmployee.getTitle());
	}
	
	private boolean utilCheckStringForNonAlphabet(String toBeChecked){
		boolean alphabetError = false;
		for(char c: toBeChecked.toCharArray()){
			if(Character.isWhitespace(c))
				continue;
			if(!Character.isAlphabetic(c)){
				errors++;
				alphabetError = true;
				break;
			}
		}
		return alphabetError;
	}
	
	private boolean utilCheckStringForNonDigits(String toBeChecked){
		boolean digitError = false;
		for(char c: toBeChecked.toCharArray()){
			if(!Character.isDigit(c)){
				errors++;
				digitError = true;
				break;
			}
		}
		return digitError;
	}
	
	
	public int getErrors() {
		return errors;
	}
	
	public boolean getFirstNameError() {
		return firstNameError;
	}
	
	public boolean getLastNameError() {
		return lastNameError;
	}
	
	public boolean getAgeError() {
		return ageError;
	}
	
	public boolean getTitleError() {
		return titleError;
	}
	
	public boolean getTotalHourError() {
		return totalHourError;
	}

	public void setErrors(int errors) {
		this.errors = errors;
	}
}
