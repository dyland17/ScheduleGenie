package dewalddylan.data.enumerations.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Assert;
import org.junit.Test;

import dewalddylan.data.enumerations.ScreenType;

public class ScreenTypeTest {
	
	@Test
	public void screenTypeIsTheSameTest(){
		ScreenType screenType = ScreenType.EDITEMPLOYEE;
		assertEquals(ScreenType.EDITEMPLOYEE,screenType);
	}
	
	@Test
	public void screenTypeIsNotTheSameTest(){
		ScreenType screenType = ScreenType.NEWEMPLOYEE;
		assertNotEquals(ScreenType.EDITEMPLOYEE, screenType);
	}
}
