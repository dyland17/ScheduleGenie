package main.dewalddylan.schedulegenie.data.checker;

import java.awt.Color;

import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.SGTextField;
import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;
import main.dewalddylan.schedulegenie.gui.Window;

public class TextFieldChecker {
	private int recentErrors;
	public void check(Window screen)throws GUITextFieldException{
		recentErrors = 0;
		SGTextField[] allTextFields = screen.getAllSGTextFields();
		for(SGTextField field: allTextFields){
			if(field.getTextFieldType() == TypeOfTextField.ALPHABET)
				field.changeBorderColor((utilCheckStringForNonAlphabet(field.getText())? Color.red : Color.gray));
			else
				field.changeBorderColor((utilCheckStringForNonDigits((field.getText()))? Color.red : Color.gray));
		}
		if(recentErrors > 0){
			throw new GUITextFieldException(this);
		}
	}
	
	private boolean utilCheckStringForNonAlphabet(String toBeChecked){
		boolean alphabetError = false;
		for(char c: toBeChecked.toCharArray()){
			if(Character.isWhitespace(c))
				continue;
			if(!Character.isAlphabetic(c)){
				recentErrors++;
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
				recentErrors++;
				digitError = true;
				break;
			}
		}
		return digitError;
	}
	
	public int getRecentErrors() {
		return recentErrors;
	}
}
