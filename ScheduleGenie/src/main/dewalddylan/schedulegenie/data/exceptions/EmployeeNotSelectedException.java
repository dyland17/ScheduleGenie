package main.dewalddylan.schedulegenie.data.exceptions;

import javax.swing.JOptionPane;

public class EmployeeNotSelectedException extends Exception{
	private String message = "Employee was not selected.";
	public EmployeeNotSelectedException(){
		super("Employee was not selected.");
	}
	public void showMessage() {
		JOptionPane.showMessageDialog(null, "Error: " + message);
	}
}
