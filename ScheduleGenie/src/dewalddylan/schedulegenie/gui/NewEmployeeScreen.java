package dewalddylan.schedulegenie.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dewalddylan.data.Employee;
import dewalddylan.data.enumerations.ScreenType;

public class NewEmployeeScreen extends Window implements ActionListener{

	
	public NewEmployeeScreen(String name, ScreenType type) {
		super(name, type);
		butCancel.addActionListener(this);
		butCreate.addActionListener(this);
	}
	//Creation button functionality.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == butCancel){
			window.dispose();
		}
		else if(e.getSource() == butCreate){
			Employee newEmployee = new Employee(tfEmployeeName.getText(),Integer.parseInt(tfAge.getText()),Integer.parseInt(tfTotalHours.getText()),tfTitle.getText());
			printEmployeeInfo(newEmployee);
		}
	}
	//Just to Debug if an employee's information is correct.
	private void printEmployeeInfo(Employee newEmployee) {
		System.out.println("Name: " + newEmployee.getName());
		System.out.println("Age: " + newEmployee.getAge());
		System.out.println("Title: "  + newEmployee.getTitle());
		System.out.println("TotalHours: " + newEmployee.getTotalHours());
	}
	
}
