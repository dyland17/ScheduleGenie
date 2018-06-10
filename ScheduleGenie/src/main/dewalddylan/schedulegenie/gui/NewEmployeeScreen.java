package main.dewalddylan.schedulegenie.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.TitleName;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;

public class NewEmployeeScreen extends ManipulatorEmployeeScreen{
	
	public NewEmployeeScreen(ScheduleScreen mScreen){
		super(TitleName.NEWEMPLOYEESCREENNAME, ScreenType.NEWEMPLOYEE,mScreen);
		butUpdate.addActionListener(this);
	}
	//Creation button functionality.
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == butUpdate){
			TextFieldChecker checker = new TextFieldChecker();
			Random random = new Random();
			try {
				checker.check(this);
				Employee newEmployee = new Employee(tfEmployeeFirstName.getText(),tfEmployeeLastName.getText()
						,Integer.parseInt(tfAge.getText()), random.nextInt(Employee.TOTALEMPLOYEENUMBERS),Integer.parseInt(tfTotalHours.getText()),tfTitle.getText());
				mainScreen.addNewEmployee(newEmployee);
				mainScreen.window.requestFocus();
				mainScreen.window.setEnabled(true);
				this.window.dispose();
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
		System.out.println("Employee #: " + newEmployee.getEmployeeNumber());
		System.out.println("Title: "  + newEmployee.getTitle());
		System.out.println("TotalHours: " + newEmployee.getTotalHours());
	}
}