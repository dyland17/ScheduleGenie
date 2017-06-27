package dewalddylan.data.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dewalddylan.data.DayTracker;
import dewalddylan.data.Employee;
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
		
		assertEquals(sTime.getHour(), testTracker.getTimeSheetByDay(WorkDay.MONDAY).getStartTime().getHour());
		assertEquals(sTime.getMinute(), testTracker.getTimeSheetByDay(WorkDay.MONDAY).getStartTime().getMinute());
		
		assertEquals(eTime.getHour(), testTracker.getTimeSheetByDay(WorkDay.MONDAY).getEndTime().getHour());
		assertEquals(eTime.getMinute(), testTracker.getTimeSheetByDay(WorkDay.MONDAY).getEndTime().getMinute());
		assertEquals(WorkDay.MONDAY, testTracker.getTimeSheetByDay(WorkDay.MONDAY).getWorkDay());
		//Second test with more TimeSheets.
		sTime = new Time(10,0,TimeOfDay.PM);
		eTime = new Time(12,0,TimeOfDay.AM);
		testTracker.addNewTimeSheet(new TimeSheet(sTime,eTime,WorkDay.FRIDAY));
		assertEquals(sTime.getHour(), testTracker.getTimeSheetByDay(WorkDay.FRIDAY).getStartTime().getHour());
		assertEquals(sTime.getMinute(), testTracker.getTimeSheetByDay(WorkDay.FRIDAY).getStartTime().getMinute());
		
		assertEquals(eTime.getHour(), testTracker.getTimeSheetByDay(WorkDay.FRIDAY).getEndTime().getHour());
		assertEquals(eTime.getMinute(), testTracker.getTimeSheetByDay(WorkDay.FRIDAY).getEndTime().getMinute());
		assertEquals(WorkDay.FRIDAY,  testTracker.getTimeSheetByDay(WorkDay.FRIDAY).getWorkDay());
	}
	
	@Test
	public void getTimeSheetByDayNullTest(){
		Employee newEmployee = new Employee("Dan", "SexBang",21);
		DayTracker eDayTracker = newEmployee.getDayTracker();
		assertEquals(null, eDayTracker.getTimeSheetByDay(WorkDay.MONDAY));
		
	}
	@Test
	public void setTimeSheetByTimeSheetTest(){
		DayTracker testTracker = new DayTracker();
		Time sTime = new Time(2,30,TimeOfDay.PM);
		Time eTime = new Time(4,0, TimeOfDay.PM);
		testTracker.addNewTimeSheet(new TimeSheet(sTime,eTime,WorkDay.MONDAY));
		
		sTime = new Time(10,0,TimeOfDay.PM);
		eTime = new Time(12,0,TimeOfDay.AM);
		testTracker.addNewTimeSheet(new TimeSheet(sTime,eTime,WorkDay.FRIDAY));
		
		sTime = new Time(1,15,TimeOfDay.PM);
		eTime = new Time(2,0,TimeOfDay.PM);
		TimeSheet timeSheet = new TimeSheet(sTime,eTime,WorkDay.MONDAY);
		testTracker.setTimeSheetByTimeSheet(timeSheet);
		//Starting time changed.
		assertEquals(1,testTracker.getTimeSheetByDay(WorkDay.MONDAY).getStartTime().getHour());
		assertEquals(15,testTracker.getTimeSheetByDay(WorkDay.MONDAY).getStartTime().getMinute());
		//Ending time changed.
		assertEquals(2,testTracker.getTimeSheetByDay(WorkDay.MONDAY).getEndTime().getHour());
		assertEquals(0,testTracker.getTimeSheetByDay(WorkDay.MONDAY).getEndTime().getMinute());
		//Did WorkDay changed.
		assertEquals(WorkDay.MONDAY,testTracker.getTimeSheetByDay(WorkDay.MONDAY).getWorkDay());
	}
	
	@Test
	public void setTimeSheetByTimeSheetWhenWorkDayIsNotPresentTest(){
		DayTracker testTracker = new DayTracker();
		Time sTime = new Time(2,30,TimeOfDay.PM);
		Time eTime = new Time(4,0, TimeOfDay.PM);
		testTracker.addNewTimeSheet(new TimeSheet(sTime,eTime,WorkDay.MONDAY));
		
		sTime = new Time(10,0,TimeOfDay.PM);
		eTime = new Time(12,0,TimeOfDay.AM);
		TimeSheet newSheet = new TimeSheet(sTime,eTime,WorkDay.TUESDAY);
		testTracker.setTimeSheetByTimeSheet(newSheet);
		TimeSheet sheetToBeTested = testTracker.getTimeSheetByDay(WorkDay.TUESDAY);
		
		//Starting time changed.
		assertEquals(sTime.getHour(),sheetToBeTested.getStartTime().getHour());
		assertEquals(sTime.getMinute(),sheetToBeTested.getStartTime().getMinute());
		//Ending time changed.
		assertEquals(eTime.getHour(),sheetToBeTested.getEndTime().getHour());
		assertEquals(eTime.getMinute(),sheetToBeTested.getEndTime().getMinute());
		//Did WorkDay changed.
		assertEquals(WorkDay.TUESDAY,sheetToBeTested.getWorkDay());
	}
}
