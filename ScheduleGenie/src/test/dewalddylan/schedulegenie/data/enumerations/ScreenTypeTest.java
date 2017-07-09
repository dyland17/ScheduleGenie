package test.dewalddylan.schedulegenie.data.enumerations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Assert;
import org.junit.Test;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;

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
