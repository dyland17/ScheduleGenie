package dewalddylan.schedulegenie.data.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import dewalddylan.schedulegenie.data.Time;
import dewalddylan.schedulegenie.data.enumerations.TimeOfDay;
import dewalddylan.schedulegenie.data.exceptions.TimeException;

public class TimeTest {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();
	@Test
	public void wrongHourTest(){
		Time newTime = new Time(-2,0,TimeOfDay.AM);
		newTime = new Time(15,0,TimeOfDay.AM);
		newTime = new Time(4,0,TimeOfDay.AM);
	}
	
	@Test
	public void wrongMinuteTest(){
		Time newTime = new Time(2,-5,TimeOfDay.AM);
		newTime = new Time(2,60,TimeOfDay.AM);
		newTime = new Time(4,0,TimeOfDay.AM);
	}
	
	@Test
	public void getHourTest(){
		Time newTime = new Time(2,5,TimeOfDay.PM);
		assertEquals(2,newTime.getHour());
	}
	
	@Test
	public void getMinuteTest(){
		Time newTime = new Time(2,5,TimeOfDay.PM);
		assertEquals(5,newTime.getMinute());
	}
	
	@Test
	public void setHourTest(){
		Time newTime = new Time(2,5,TimeOfDay.PM);
		newTime.setHour(4);
		assertEquals(4,newTime.getHour());
	}
	
	@Test
	public void setMinuteTest(){
		Time newTime = new Time(2,5,TimeOfDay.PM);
		newTime.setMinute(20);
		assertEquals(20,newTime.getMinute());
	}
	
	@Test
	public void setTimeOfDayTest(){
		Time newTime = new Time(2,5,TimeOfDay.PM);
		newTime.setTimeOfDay(TimeOfDay.AM);
		assertEquals(TimeOfDay.AM,newTime.getTimeOfDay());
	}
	
	@Test
	public void getTimeOfDayTest(){
		Time newTime = new Time(2,5,TimeOfDay.PM);
		assertEquals(TimeOfDay.PM,newTime.getTimeOfDay());
	}
	
	//vvvvvvvvvvv Look at later vvvvvvvvvv
	/*@Test
	public void timeExceptionThrownTest(){
		expectedException.expect(TimeException.class);
		expectedException.expectMessage(substring);
	}*/
	
}
