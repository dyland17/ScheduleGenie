package dewalddylan.data;

import java.util.ArrayList;

import dewalddylan.data.enumerations.WorkDay;

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
	public void setTimeSheetByDay(WorkDay day, TimeSheet timeSheet){
		for(int i = 0; i < daySheet.size(); i++){
			if(day == daySheet.get(i).getWorkDay()){
				daySheet.get(i).setTimeSheet(timeSheet);
				return;
			}
		}
	}
	
	public void addNewTimeSheet(TimeSheet sheet){
		daySheet.add(sheet);
	}
}
