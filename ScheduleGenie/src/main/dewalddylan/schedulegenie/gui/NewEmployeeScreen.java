package main.dewalddylan.schedulegenie.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;

public class NewEmployeeScreen extends EmployeeScreen implements ActionListener{

	public NewEmployeeScreen() {
		super(Window.NEWSCREEN, ScreenType.NEWEMPLOYEE);
		butUpdate.addActionListener(this);
	}
	//Creation button functionality.
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == butUpdate){
			TextFieldChecker checker = new TextFieldChecker();
			try {
				checker.check(this);
				Employee newEmployee = new Employee(tfEmployeeFirstName.getText(),tfEmployeeLastName.getText()
						,Integer.parseInt(tfAge.getText()),Integer.parseInt(tfTotalHours.getText()),tfTitle.getText());
				printEmployeeInfo(newEmployee);
			} catch (GUITextFieldException ex) {
				ex.showMessage();
			}
		}
	}
	//Just to Debug if an employee's information is correct.
	private void printEmployeeInfo(Employee newEmployee) {
		System.out.println("First Name: " + newEmployee.getFirstName());
		System.out.println("Last Name: " + newEmployee.getLastName());
		System.out.println("Age: " + newEmployee.getAge());
		System.out.println("Title: "  + newEmployee.getTitle());
		System.out.println("TotalHours: " + newEmployee.getTotalHours());
	}	
}