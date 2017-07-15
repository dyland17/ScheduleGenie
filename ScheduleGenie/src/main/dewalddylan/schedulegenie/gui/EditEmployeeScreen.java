package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;

public class EditEmployeeScreen extends Window{
	private Employee employeeToBeEdited;
	public EditEmployeeScreen(Employee employee) {
		super(Window.EDITSCREEN, ScreenType.EDITEMPLOYEE);
		employeeToBeEdited = employee;
		butUpdate.addActionListener(this);
		setupTfInfo();
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


	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == butUpdate){
		try{
			TextFieldChecker checker = new TextFieldChecker();
				employeeToBeEdited.setFirstName(tfEmployeeFirstName.getText());
				employeeToBeEdited.setLastName(tfEmployeeLastName.getText());
				employeeToBeEdited.setTitle(tfTitle.getText());
			checker.check(employeeToBeEdited,tfAge,tfTotalHours);
				employeeToBeEdited.setAge(Integer.parseInt(tfAge.getText()));
				employeeToBeEdited.setTotalHours(Integer.parseInt(tfTotalHours.getText()));
			}
			catch(GUITextFieldException guiEx){
				setBordersRedThatCausedError(guiEx);
				guiEx.showMessage();
			}
		}
	}
	private void setBordersRedThatCausedError(GUITextFieldException guiEx) {
		if(guiEx.checker.getFirstNameError())
			tfEmployeeFirstName.setBorder(BorderFactory.createLineBorder(Color.red));
		else
			tfEmployeeFirstName.setBorder(BorderFactory.createLineBorder(Color.gray));
		if(guiEx.checker.getLastNameError())
			tfEmployeeLastName.setBorder(BorderFactory.createLineBorder(Color.red));
		else
			tfEmployeeLastName.setBorder(BorderFactory.createLineBorder(Color.gray));
		if(guiEx.checker.getAgeError())
			tfAge.setBorder(BorderFactory.createLineBorder(Color.red));
		else
			tfAge.setBorder(BorderFactory.createLineBorder(Color.gray));
		if(guiEx.checker.getTitleError())
			tfTitle.setBorder(BorderFactory.createLineBorder(Color.red));
		else
			tfTitle.setBorder(BorderFactory.createLineBorder(Color.gray));
		if(guiEx.checker.getTotalHourError())
			tfTotalHours.setBorder(BorderFactory.createLineBorder(Color.red));
		else
			tfTotalHours.setBorder(BorderFactory.createLineBorder(Color.gray));
	}
	
	public Employee getCurrentEmployeeToBeEdited(){
		return employeeToBeEdited;
	}
}
