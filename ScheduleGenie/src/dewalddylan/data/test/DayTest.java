package dewalddylan.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import dewalddylan.data.WorkDay;

public class DayTest {
	@Test
	public void daysAreTheSameTest(){
		WorkDay monday = WorkDay.MONDAY;
		assertEquals(WorkDay.MONDAY, monday);
	}
	@Test
	public void daysAreNotTheSameTest(){
		WorkDay monday = WorkDay.MONDAY;
		assertNotEquals(WorkDay.TUESDAY, monday);
	}
}
