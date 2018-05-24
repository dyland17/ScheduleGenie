package main.dewalddylan.schedulegenie.gui;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;

public class ScheduleEmployeeScreen  extends EmployeeScreen{
	private Employee employeeBeingScheduled;
	public ScheduleEmployeeScreen(Employee employeeToBeScheduled, ScheduleScreen scheduleScreen) {
		super(Window.SCHEDULEEMPLOYEESCREEN,ScreenType.SCHEDULEEMPLOYEE, scheduleScreen);
		employeeBeingScheduled =	employeeToBeScheduled;
	}
	
}
