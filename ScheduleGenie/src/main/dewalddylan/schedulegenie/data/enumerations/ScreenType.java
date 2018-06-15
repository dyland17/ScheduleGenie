package main.dewalddylan.schedulegenie.data.enumerations;

import java.awt.Dimension;

import main.dewalddylan.schedulegenie.data.GUIDim;

public enum ScreenType {
	NEWEMPLOYEE(GUIDim.EMPLOYEESCREENDIM),
	EDITEMPLOYEE(GUIDim.EMPLOYEESCREENDIM),
	TIMESHEETEMPLOYEE(GUIDim.EMPLOYEESCREENDIM),
	SCHEDULESCREEN(GUIDim.SCHEDULESCREENDIM);
	
	private final Dimension myDim;
	ScreenType(Dimension dim){
		myDim = dim;
	}
	public Dimension myDim(){ return myDim;}
}
