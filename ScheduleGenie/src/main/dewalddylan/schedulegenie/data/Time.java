package main.dewalddylan.schedulegenie.data;

import main.dewalddylan.schedulegenie.data.enumerations.TimeOfDay;
import main.dewalddylan.schedulegenie.data.exceptions.TimeException;

public class Time{
	private int hour;
	private int minute;
	private TimeOfDay timeOfDay;
	public Time(int hour, int min, TimeOfDay timeOfDay)throws TimeException{
		this.hour = hour;
		minute = min;
		this.timeOfDay = timeOfDay;
			if(hour  > 12 || hour <= 0 ){
				throw new TimeException(this.hour, minute,TimeException.EHOUR);
			}
			else if(minute < 0 || minute > 59){
				throw new TimeException(this.hour, minute,TimeException.EMINUTE);
			}
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public TimeOfDay getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(TimeOfDay timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	
}
