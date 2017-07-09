package main.dewalddylan.schedulegenie.data;

import java.util.ArrayList;

import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

public class DayTracker {
	private ArrayList<TimeSheet> daySheet;
	public DayTracker(){
		daySheet = new ArrayList<TimeSheet>();
	}
	
	public TimeSheet getTimeSheetByDay(WorkDay day){
		for(int i = 0; i < daySheet.size(); i++){
			if(day == daySheet.get(i).getWorkDay())
				return daySheet.get(i);
		}
		return null;
	}
	public void setTimeSheetByTimeSheet(TimeSheet timeSheet){
		WorkDay timeSheetDay = timeSheet.getWorkDay();
			for(int i = 0; i < daySheet.size(); i++){
				if(timeSheetDay == daySheet.get(i).getWorkDay()){
					daySheet.get(i).setTimeSheet(timeSheet);
					return;
				}
		}
		addNewTimeSheet(timeSheet);
	}
	
	public void addNewTimeSheet(TimeSheet sheet){
		daySheet.add(sheet);
	}
}
