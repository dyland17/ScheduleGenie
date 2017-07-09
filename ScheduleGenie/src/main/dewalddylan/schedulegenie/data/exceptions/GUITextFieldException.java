package main.dewalddylan.schedulegenie.data.exceptions;

import javax.swing.JOptionPane;

import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;

public class GUITextFieldException extends Exception{
	private int amountOfErrors;
	public TextFieldChecker checker;
	public GUITextFieldException(TextFieldChecker checker){
		super("One of the textFields have a char that can't be used.");
		amountOfErrors = checker.getErrors();
		this.checker = checker;
	}
	
	public void showMessage(){
		JOptionPane.showMessageDialog(null, "Errors: " + amountOfErrors + "\nPlease fix the boxes marked in red.");
	}
}
