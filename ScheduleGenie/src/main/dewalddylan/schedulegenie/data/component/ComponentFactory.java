package main.dewalddylan.schedulegenie.data.component;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.LabelComponentPair;
import main.dewalddylan.schedulegenie.data.enumerations.TimeOfDay;

public class ComponentFactory {
	public static final String FIRSTNAME = "First_Name";
	public static final String LASTNAME = "Last_Name";
	public static final String AGE = "age";
	public static final String TOTALHOURS = "Total_Hours";
	public static final String TIME_MIN = "Time_Min";
	public static final String TIME_HOUR = "Time_Hour";
	public static final String TITLE = "title";
	public static final String TIMEOFDAY = "Time_of_Day";
	
	public static Component<JComponent> createComponentJTextField(String name){
		JTextField newField = new JTextField(LabelComponentPair.TFSIZE);
		Component<JComponent> newComponent = new Component<JComponent>();
		newComponent.add(name, newField);
		return newComponent;
	}
	
	public static Component<JComponent> createTimeComboBox( Integer[] hourList, Integer[] minList){
		JComboBox<Integer> timeHourBox = new JComboBox<Integer>(hourList);
		JComboBox<Integer> timeMinBox = new JComboBox<Integer>(minList);
		JComboBox<TimeOfDay> AmPmBox = new JComboBox<TimeOfDay>(TimeOfDay.values());
		Component<JComponent> comboBoxComponent = new Component<JComponent>();
		comboBoxComponent.add(TIME_HOUR, timeHourBox);
		comboBoxComponent.add(TIME_MIN, timeMinBox);
		comboBoxComponent.add(TIMEOFDAY, AmPmBox);
		return comboBoxComponent;
		
	}
}
