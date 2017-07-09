package test.dewalddylan.schedulegenie.data.enumerations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import main.dewalddylan.schedulegenie.data.enumerations.TimeOfDay;

public class TimeOfDayTest {
	@Test
	public void sameTimeOfDayTest(){
		TimeOfDay timeOfDay = TimeOfDay.AM;
		assertEquals(TimeOfDay.AM,timeOfDay);
	}
	@Test
	public void notTheSameTimeOfDayTest(){
		TimeOfDay timeOfDay = TimeOfDay.PM;
		assertNotEquals(TimeOfDay.AM,timeOfDay);
	}
}
