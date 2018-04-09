package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;

public class EditEmployeeScreen extends EmployeeScreen{
	private Employee employeeToBeEdited;
	public EditEmployeeScreen(Employee employee,ScheduleScreen mScreen) {
		super(Window.EDITSCREEN, ScreenType.EDITEMPLOYEE,mScreen);
		employeeToBeEdited = employee;
		butUpdate.addActionListener(this);
		setupTfInfo();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == butUpdate){
		try{
				TextFieldChecker checker = new TextFieldChecker();
				checker.check(this);
				setEmployeeFieldsWithSGTextFields();
			}
			catch(GUITextFieldException  except){
				 except.showMessage();
			}
		}
	}


	public Employee getCurrentEmployeeToBeEdited(){
		return employeeToBeEdited;
	}


	private void setupTfInfo() {
		tfEmployeeFirstName.setText(employeeToBeEdited.getFirstName());
		tfEmployeeFirstName.setBorder(BorderFactory.createLineBorder(Color.gray));
		tfEmployeeLastName.setText(employeeToBeEdited.getLastName());
		tfEmployeeLastName.setBorder(BorderFactory.createLineBorder(Color.gray));
		tfAge.setText(String.valueOf(employeeToBeEdited.getAge()));
		tfAge.setBorder(BorderFactory.createLineBorder(Color.gray));
		tfTitle.setText(employeeToBeEdited.getTitle());
		tfTitle.setBorder(BorderFactory.createLineBorder(Color.gray));
		tfTotalHours.setText(String.valueOf(employeeToBeEdited.getTotalHours()));
		tfTotalHours.setBorder(BorderFactory.createLineBorder(Color.gray));
	}

	private void setEmployeeFieldsWithSGTextFields() {
		employeeToBeEdited.setFirstName(tfEmployeeFirstName.getText());
		employeeToBeEdited.setLastName(tfEmployeeLastName.getText());
		employeeToBeEdited.setTitle(tfTitle.getText());
		employeeToBeEdited.setAge(Integer.parseInt(tfAge.getText()));
		employeeToBeEdited.setTotalHours(Integer.parseInt(tfTotalHours.getText()));
	}
}
