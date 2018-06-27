package test.dewalddylan.schedulegenie.gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.junit.Test;

import java.awt.Color;

import static org.junit.Assert.*;

import main.dewalddylan.schedulegenie.gui.EmployeePanel;
import main.dewalddylan.schedulegenie.gui.Panel;
import main.dewalddylan.schedulegenie.tools.BorderTester;

public class PanelTest {
	@Test
	public void testSetBorderLookDefault(){
		Panel pan = new EmployeePanel();
		pan.setBorderLook();
		BevelBorder panBorder = (BevelBorder)pan.getBorder();
		BevelBorder factoryBorder = (BevelBorder) BorderFactory.createRaisedBevelBorder();
		boolean sameBorder = BorderTester.testBevelBorders(panBorder, factoryBorder);
		assertEquals(true, sameBorder);
	}
	
	@Test
	public void testSetBorderLowered(){
		Panel pan = new EmployeePanel();
		pan.setBorderLook(Panel.LOWERBORDER);
		BevelBorder panBorder = (BevelBorder)pan.getBorder();
		BevelBorder factoryBorder = (BevelBorder) BorderFactory.createLoweredBevelBorder();
		boolean sameBorder = BorderTester.testBevelBorders(panBorder, factoryBorder);
		assertEquals(true, sameBorder);
	}
	
	@Test
	public void testSetBorderRaised(){
		Panel pan = new EmployeePanel();
		pan.setBorderLook(Panel.RAISEDBORDER);
		BevelBorder panBorder = (BevelBorder)pan.getBorder();
		BevelBorder factoryBorder = (BevelBorder) BorderFactory.createRaisedBevelBorder();
		boolean sameBorder = BorderTester.testBevelBorders(panBorder, factoryBorder);
		assertEquals(true, sameBorder);
	}
	
	@Test
	public void testSetBorderDark(){
		Panel pan = new EmployeePanel();
		pan.setBorderLook(Panel.DARKBORDER);
		LineBorder panBorder = (LineBorder)pan.getBorder();
		LineBorder factoryBorder = (LineBorder) BorderFactory.createLineBorder(Color.black, 2, true);
		boolean sameBorder = BorderTester.testLineBorders(panBorder, factoryBorder);
		assertEquals(true, sameBorder);
	}
	
	@Test
	public void testsetBorderWithHigherNumber(){
		Panel pan = new EmployeePanel();
		final int testNumber = 5;
		pan.setBorderLook(testNumber);
		BevelBorder panBorder = (BevelBorder)pan.getBorder();
		BevelBorder factoryBorder = (BevelBorder) BorderFactory.createRaisedBevelBorder();
		boolean sameBorder = BorderTester.testBevelBorders(panBorder, factoryBorder);
		assertEquals(true, sameBorder);
	}
	
	@Test
	public void testsetBorderWithLowerNumber(){
		Panel pan = new EmployeePanel();
		final int testNumber = -5;
		pan.setBorderLook(testNumber);
		BevelBorder panBorder = (BevelBorder)pan.getBorder();
		BevelBorder factoryBorder = (BevelBorder) BorderFactory.createRaisedBevelBorder();
		boolean sameBorder = BorderTester.testBevelBorders(panBorder, factoryBorder);
		assertEquals(true, sameBorder);
	}
}
