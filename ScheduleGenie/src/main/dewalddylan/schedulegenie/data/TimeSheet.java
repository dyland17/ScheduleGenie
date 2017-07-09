package main.dewalddylan.schedulegenie.data;

import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

public class TimeSheet {
	private Time startTime;
	private Time endTime;
	private WorkDay dayForTimeSheet;
	public TimeSheet(Time sTime, Time eTime, WorkDay day){
		startTime = sTime;
		endTime = eTime;
		dayForTimeSheet = day;
	}
	
	public WorkDay getWorkDay(){
		return dayForTimeSheet;
	}
	
	public void setWorkDay(WorkDay day){
		dayForTimeSheet = day;
	}
	public Time getStartTime(){
		return startTime;
	}
	public Time getEndTime(){
		return endTime;
	}
	public void setStartTime(Time time){
		startTime.setHour(time.getHour());
		startTime.setMinute(time.getMinute());
	}
	public void setEndTime(Time time){
		endTime.setHour(time.getHour());
		endTime.setMinute(time.getMinute());
	}
	public void setTimeSheet(TimeSheet sheet){
		setStartTime(sheet.getStartTime());
		setEndTime(sheet.getEndTime());
		setWorkDay(sheet.getWorkDay());
	}
}
