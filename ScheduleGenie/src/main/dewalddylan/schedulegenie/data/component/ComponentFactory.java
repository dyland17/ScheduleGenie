package main.dewalddylan.schedulegenie.data.component;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.LabelComponentPair;

public class ComponentFactory {
	public static final String FIRSTNAME = "First_Name";
	public static final String LASTNAME = "Last_Name";
	public static final String AGE = "age";
	public static final String TOTALHOURS = "Total_Hours";
	public static final String TIME_MIN = "Time_Min";
	public static final String TIME_HOUR = "Time_Hour";
	public static final String TITLE = "title";
	
	public static Component<JTextField> createComponentJTextField(String name){
		JTextField newField = new JTextField(LabelComponentPair.TFSIZE);
		Component<JTextField> newComponent = new Component();
		newComponent.add(name, newField);
		return newComponent;
	}
	
	public static Component<JComboBox<Integer>> createTimeComboBox( Integer[] hourList, Integer[] minList){
		JComboBox<Integer> timeHourBox = new JComboBox<Integer>(hourList);
		JComboBox<Integer> timeMinBox = new JComboBox<Integer>(minList);
		Component<JComboBox<Integer>> comboBoxComponent = new Component<JComboBox<Integer>>();
		comboBoxComponent.add(TIME_HOUR, timeHourBox);
		comboBoxComponent.add(TIME_MIN, timeMinBox);
		return comboBoxComponent;
		
	}
}
