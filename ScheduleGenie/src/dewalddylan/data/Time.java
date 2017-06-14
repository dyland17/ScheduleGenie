package dewalddylan.data;

import dewalddylan.data.enumerations.TimeOfDay;

public class Time {
	private int hour;
	private int minute;
	private TimeOfDay timeOfDay;
	public Time(int hour, int min, TimeOfDay timeOfDay){
		this.hour = hour;
		minute = min;
		this.timeOfDay = timeOfDay;
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
