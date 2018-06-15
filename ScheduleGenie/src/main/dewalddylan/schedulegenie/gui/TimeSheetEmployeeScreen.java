package main.dewalddylan.schedulegenie.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.DayTracker;
import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.GUIDim;
import main.dewalddylan.schedulegenie.data.TimeSheetPanel;
import main.dewalddylan.schedulegenie.data.TitleName;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;

public class TimeSheetEmployeeScreen  extends ManipulatorEmployeeScreen{
	private Employee employeeBeingScheduled;
	private TimeSheetPanel daysPanel;
	
	public TimeSheetEmployeeScreen(Employee employeeToBeScheduled, ScheduleScreen scheduleScreen) {
		super(TitleName.TIMESHEETEMPLOYEESCREENNAME,ScreenType.TIMESHEETEMPLOYEE,scheduleScreen);
		mainScreen = scheduleScreen;
		employeeBeingScheduled =	employeeToBeScheduled;
		this.styleEmployeeScreen();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == butUpdate){
			updateEmployeeSchedule();
		}
		else if(e.getSource() == butCancel){
			if(e.getSource() == butCancel){
				mainScreen.window.setEnabled(true);
				mainScreen.window.requestFocus();
				window.dispose();
			}
		}
	}
	private void updateEmployeeSchedule() {
		DayTracker employeeDayTracker = employeeBeingScheduled.getDayTracker();
		//employeeDayTracker.
		
	}
	
	@Override
	protected void styleEmployeeScreen() {
		Container c = window.getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(daysPanel);
		
		JPanel jpButPanel = createButtonGUIPanel();
		
		c.add(jpButPanel);
		
	}
		
}
