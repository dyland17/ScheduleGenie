package main.dewalddylan.schedulegenie.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;

public class EditEmployeeScreen extends Window{
	private Employee employeeToBeEdited;
	public EditEmployeeScreen(String name, Employee employee) {
		super(name, ScreenType.EDITEMPLOYEE);
		employeeToBeEdited = employee;
		butUpdate.addActionListener(this);
		setupTfInfo();
	}
	

	private void setupTfInfo() {
		tfEmployeeFirstName.setText(employeeToBeEdited.getFirstName());
		tfEmployeeLastName.setText(employeeToBeEdited.getLastName());
		tfAge.setText(String.valueOf(employeeToBeEdited.getAge()));
		tfTitle.setText(employeeToBeEdited.getTitle());
		tfTotalHours.setText(String.valueOf(employeeToBeEdited.getTotalHours()));
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		Employee originalEmployee = employeeToBeEdited.copy();
		if(e.getSource() == butUpdate){
			employeeToBeEdited.setFirstName(tfEmployeeFirstName.getText());
			employeeToBeEdited.setLastName(tfEmployeeLastName.getText());
			employeeToBeEdited.setAge(Integer.parseInt(tfAge.getText()));
			employeeToBeEdited.setTitle(tfTitle.getText());
			employeeToBeEdited.setTotalHours(Integer.parseInt(tfTotalHours.getText()));
			
		}
		
	}

}
