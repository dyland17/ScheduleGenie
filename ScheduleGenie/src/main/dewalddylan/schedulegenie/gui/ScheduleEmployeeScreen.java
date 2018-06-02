package main.dewalddylan.schedulegenie.gui;

import java.awt.event.ActionEvent;

import main.dewalddylan.schedulegenie.data.DayTracker;
import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;

public class ScheduleEmployeeScreen  extends EmployeeScreen{
	private Employee employeeBeingScheduled;
	public ScheduleEmployeeScreen(Employee employeeToBeScheduled, ScheduleScreen scheduleScreen) {
		super(Window.SCHEDULEEMPLOYEESCREEN,Window.EMPLOYEETIMESHEETSCREEN,ScreenType.SCHEDULEEMPLOYEE, scheduleScreen);
		employeeBeingScheduled =	employeeToBeScheduled;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == butUpdate){
			updateEmployeeSchedule();
		}
	}
	private void updateEmployeeSchedule() {
		DayTracker employeeDayTracker = employeeBeingScheduled.getDayTracker();
		//employeeDayTracker.
		
	}
	
}
