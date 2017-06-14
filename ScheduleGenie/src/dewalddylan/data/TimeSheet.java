package dewalddylan.data;

import dewalddylan.data.enumerations.WorkDay;

public class TimeSheet {
	Time startTime;
	Time endTime;
	WorkDay dayForTimeSheet;
	public TimeSheet(Time sTime, Time eTime, WorkDay day){
		startTime = sTime;
		endTime = eTime;
		dayForTimeSheet = day;
	}
	
	public WorkDay getWorkDay(){
		return dayForTimeSheet;
	}
	
}
