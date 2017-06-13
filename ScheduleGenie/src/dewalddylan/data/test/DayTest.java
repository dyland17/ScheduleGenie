package dewalddylan.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import dewalddylan.data.Day;

public class DayTest {
	@Test
	public void daysAreTheSameTest(){
		Day monday = Day.MONDAY;
		assertEquals(Day.MONDAY, monday);
	}
	@Test
	public void daysAreNotTheSameTest(){
		Day monday = Day.MONDAY;
		assertNotEquals(Day.TUESDAY, monday);
	}
}
