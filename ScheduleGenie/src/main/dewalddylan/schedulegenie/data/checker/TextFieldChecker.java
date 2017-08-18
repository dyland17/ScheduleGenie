package main.dewalddylan.schedulegenie.data.checker;

import java.awt.Color;
import java.util.concurrent.atomic.AtomicBoolean;

import main.dewalddylan.schedulegenie.data.SGTextField;
import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;
import main.dewalddylan.schedulegenie.gui.EmployeeScreen;

public class TextFieldChecker {
	private int recentErrors;
	public void check(EmployeeScreen screen)throws GUITextFieldException{
		recentErrors = 0;
		SGTextField[] allTextFields = screen.getAllSGTextFields();
		for(SGTextField field: allTextFields){
			boolean error = false;
			TypeOfTextField fieldType = field.getTextFieldType();
			
			if(fieldType == TypeOfTextField.ALPHABETREQ || fieldType == TypeOfTextField.ALPHABETOP){
				error = utilCheckStringForNonAlphabet(field.getText(),fieldType);
				field.changeBorderColor(error? Color.red : Color.gray);
			}
			else{
				error = utilCheckStringForNonDigits(field.getText(), fieldType); 
				field.changeBorderColor( error ? Color.red : Color.gray);
			}	
		}
		if(recentErrors > 0){
			throw new GUITextFieldException(this);
		}
	}
	
	private boolean utilCheckStringForNonAlphabet(String toBeChecked, TypeOfTextField typeTF){
		AtomicBoolean alphabetError =  new AtomicBoolean(false);
		if(toBeChecked.equals("") && typeTF == TypeOfTextField.ALPHABETREQ){
			incrementErrorAndSetBooleanToTrue(alphabetError);
			return alphabetError.get();
		}
		for(char c: toBeChecked.toCharArray()){
			if(Character.isWhitespace(c))
				continue;
			if(!Character.isAlphabetic(c)){
				incrementErrorAndSetBooleanToTrue(alphabetError);
				break;
			}
		}
		return alphabetError.get();
	}
	
	private boolean utilCheckStringForNonDigits(String toBeChecked,TypeOfTextField typeTF){
		AtomicBoolean digitError = new AtomicBoolean(false);
		if(toBeChecked.equals("")){
			switch(typeTF){
					case NUMBERREQ:
							incrementErrorAndSetBooleanToTrue(digitError);
							return  digitError.get();
					case NUMBEROP:
						digitError.set(true);
						return digitError.get();
			}
		} 
		for(char c: toBeChecked.toCharArray()){
			if(!Character.isDigit(c)){
				incrementErrorAndSetBooleanToTrue(digitError);
				break;
			}
		}
		return digitError.get();
	}
	
	private void incrementErrorAndSetBooleanToTrue(AtomicBoolean bool){
		recentErrors++;
		bool.set(true);
	}
	
	public int getRecentErrors() {
		return recentErrors;
	}
}
