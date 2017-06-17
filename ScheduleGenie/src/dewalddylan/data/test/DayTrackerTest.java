package dewalddylan.data.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dewalddylan.data.DayTracker;
import dewalddylan.data.Time;
import dewalddylan.data.TimeSheet;
import dewalddylan.data.enumerations.TimeOfDay;
import dewalddylan.data.enumerations.WorkDay;

public class DayTrackerTest {
	@Test
	public void getTimeSheetByDayTest(){
		//Test to see if timesheet's workday comes back the same.
		DayTracker testTracker = new DayTracker();
		Time sTime = new Time(2,30,TimeOfDay.PM);
		Time eTime = new Time(4,0, TimeOfDay.PM);
		testTracker.addNewTimeSheet(new TimeSheet(sTime,eTime,WorkDay.MONDAY));
		assertEquals(WorkDay.MONDAY, testTracker.getTimeSheetByDay(WorkDay.MONDAY).getWorkDay());
		//Second test with more TimeSheets.
		sTime = new Time(10,0,TimeOfDay.PM);
		eTime = new Time(12,0,TimeOfDay.AM);
		testTracker.addNewTimeSheet(new TimeSheet(sTime,eTime,WorkDay.FRIDAY));
		assertEquals(WorkDay.FRIDAY,  testTracker.getTimeSheetByDay(WorkDay.FRIDAY).getWorkDay());
		
	}
}
