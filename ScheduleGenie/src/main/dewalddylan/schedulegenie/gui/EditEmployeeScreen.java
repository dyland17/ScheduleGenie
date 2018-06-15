package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.TitleName;
import main.dewalddylan.schedulegenie.data.checker.TextFieldChecker;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.exceptions.GUITextFieldException;

public class EditEmployeeScreen extends ManipulatorEmployeeScreen{
	private Employee employeeToBeEdited;
	public EditEmployeeScreen(Employee employee,ScheduleScreen mScreen) {
		super(TitleName.EDITEMPLOYEESCREENNAME, ScreenType.EDITEMPLOYEE,mScreen);
		employeeToBeEdited = employee;
		butUpdate.addActionListener(this);
		setupTfInfo();
		super.styleEmployeeScreen();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == butUpdate){
		try{
				TextFieldChecker checker = new TextFieldChecker();
				checker.check(this);
				setEmployeeFieldsWithSGTextFields();
				mainScreen.employeeUpdate(employeeToBeEdited);
				mainScreen.window.requestFocus();
				mainScreen.window.setEnabled(true);
				this.window.dispose();
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
