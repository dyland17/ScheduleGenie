package main.dewalddylan.schedulegenie.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;

public class NewEmployeeScreen extends Window implements ActionListener{

	
	public NewEmployeeScreen() {
		super(Window.NEWSCREEN, ScreenType.NEWEMPLOYEE);
		butUpdate.addActionListener(this);
	}
	//Creation button functionality.
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == butUpdate){
			Employee newEmployee = new Employee(tfEmployeeFirstName.getText(),tfEmployeeLastName.getText(),Integer.parseInt(tfAge.getText()),Integer.parseInt(tfTotalHours.getText()),tfTitle.getText());
			printEmployeeInfo(newEmployee);
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
