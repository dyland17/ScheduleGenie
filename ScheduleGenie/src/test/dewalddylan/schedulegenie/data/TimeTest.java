package test.dewalddylan.schedulegenie.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.dewalddylan.schedulegenie.data.Time;
import main.dewalddylan.schedulegenie.data.enumerations.TimeOfDay;
import main.dewalddylan.schedulegenie.data.exceptions.TimeException;

public class TimeTest {
	private Time newTime;
	
	@Test(expected = TimeException.class)
	public void wrongHourLowTest()throws Exception{
		newTime = new Time(-2,0,TimeOfDay.AM);
		
	}
	@Test(expected = TimeException.class)
	public void wrongHourHighTest()throws Exception{
			newTime = new Time(15,0,TimeOfDay.AM);
			
	}
	@Test
	public void rightHourTest() throws Exception{
		newTime = new Time(4,0,TimeOfDay.AM);
		assertEquals(4,newTime.getHour());
	}
	
	@Test(expected = TimeException.class)
	public void wrongMinuteLowTest()throws Exception{
			newTime = new Time(2,-5,TimeOfDay.AM);
	}
	@Test(expected = TimeException.class)
	public void wrongMinuteHighTest() throws Exception{
			newTime = new Time(2,60,TimeOfDay.AM);
	}	
	@Test
	public void rightMinuteTest()throws Exception{
		newTime = new Time(4,0,TimeOfDay.AM);
		assertEquals(0,newTime.getMinute());
	}
	@Test
	public void getHourTest()throws Exception{
		newTime = new Time(2,5,TimeOfDay.PM);
		assertEquals(2,newTime.getHour());
	}
	
	@Test
	public void getMinuteTest()throws Exception{
		newTime = new Time(2,5,TimeOfDay.PM);
		assertEquals(5,newTime.getMinute());
	}
	
	@Test
	public void setHourTest()throws Exception{
		newTime = new Time(2,5,TimeOfDay.PM);
		newTime.setHour(4);
		assertEquals(4,newTime.getHour());
	}
	
	@Test
	public void setMinuteTest()throws Exception{
		newTime = new Time(2,5,TimeOfDay.PM);
		newTime.setMinute(20);
		assertEquals(20,newTime.getMinute());
	}
	
	@Test
	public void setTimeOfDayTest()throws Exception{
		newTime = new Time(2,5,TimeOfDay.PM);
		newTime.setTimeOfDay(TimeOfDay.AM);
		assertEquals(TimeOfDay.AM,newTime.getTimeOfDay());
	}
	
	@Test
	public void getTimeOfDayTest()throws Exception{
		newTime = new Time(2,5,TimeOfDay.PM);
		assertEquals(TimeOfDay.PM,newTime.getTimeOfDay());
	}	
}