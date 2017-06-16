package dewalddylan.data.test;

import org.junit.Test;

import dewalddylan.data.DayTracker;
import dewalddylan.data.Time;
import dewalddylan.data.TimeSheet;
import dewalddylan.data.enumerations.TimeOfDay;
import dewalddylan.data.enumerations.WorkDay;

public class DayTrackerTest {
	@Test
	public void getTimeSheetByDayTest(){
		DayTracker testTracker = new DayTracker();
		Time sTime = new Time(2,30,TimeOfDay.PM);
		Time eTime = new Time(4,0, TimeOfDay.PM);
		testTracker.addNewTimeSheet(new TimeSheet(sTime,eTime,WorkDay.MONDAY));
	}
}
