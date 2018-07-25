package main.dewalddylan.schedulegenie.tools;

import java.util.ArrayList;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.LabelOrientation;
import main.dewalddylan.schedulegenie.data.names.LabelInfo;
import main.dewalddylan.schedulegenie.gui.panel.widget.LabelGroup;

public class LabelGroupFactory {
	
	public static LabelGroup createTimeLabelsForFullDay(int startXPos, int startYPos){
		LabelGroup timeLabels = new LabelGroup(startXPos, startYPos, LabelOrientation.LEFTTORIGHT);
		for(int timeIndex = 6; timeIndex < 23; timeIndex++){
			if(timeIndex <= 12)
				timeLabels.add(timeIndex+"am");
			else
				timeLabels.add((timeIndex-12) +"pm");
		}
		return timeLabels;
	}
	
	public static LabelGroup createEmployeeLabels(int startXPos, int startYPos,ArrayList<Employee> employeeList){
		LabelGroup employeeLabels = new LabelGroup(startXPos, startYPos, LabelOrientation.TOPTOBOTTOM);
		for(Employee employee: employeeList){
			String modifiedName = employee.firstName().charAt(0) + ". " + employee.lastName(); 
			employeeLabels.add(modifiedName);
		}
		return employeeLabels;
	}
}
