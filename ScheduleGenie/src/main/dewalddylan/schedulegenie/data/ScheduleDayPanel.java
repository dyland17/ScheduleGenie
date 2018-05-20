package main.dewalddylan.schedulegenie.data;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.dewalddylan.schedulegenie.data.enumerations.TimeOfDay;
import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;
import main.dewalddylan.schedulegenie.gui.Window;

public class ScheduleDayPanel extends JPanel{
	//ST = Start time	ET = End Time
	WorkDay dayOfTheWeek;
	JComboBox hourSTBox;
	JComboBox minuteSTBox;
	JComboBox timeOfDaySTBox;
	JComboBox hourETBox;
	JComboBox minuteETBox;
	JComboBox timeOfDayETBox;
	
	public ScheduleDayPanel(WorkDay dayOfSchedule){
		super();
		this.setPreferredSize(new Dimension(400,120));
		this.setLayout(new FlowLayout());
		dayOfTheWeek = dayOfSchedule;
		Integer hourTime[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		Integer minTime[] = {0,15,30,45};
		hourSTBox = new JComboBox(hourTime);
		hourSTBox.setBorder(new EmptyBorder(5,5,10,0));
		minuteSTBox = new JComboBox(minTime);
		minuteSTBox.setBorder(new EmptyBorder(5,5,10,0));
		timeOfDaySTBox = new JComboBox(TimeOfDay.values());
		timeOfDaySTBox.setBorder(new EmptyBorder(5,5,10,0));
		hourETBox = new JComboBox(hourTime);
		hourETBox.setBorder(new EmptyBorder(5,5,10,0));
		minuteETBox = new JComboBox(minTime);
		minuteETBox.setBorder(new EmptyBorder(5,5,10,0));
		timeOfDayETBox = new JComboBox(TimeOfDay.values());
		timeOfDayETBox.setBorder(new EmptyBorder(5,5,10,0));
		setupPanel();
	}
	private void setupPanel() {
		JLabel dayLabel = new JLabel(dayOfTheWeek.toString());
		add(dayLabel);
		add(hourSTBox);
		add(minuteSTBox);
		add(timeOfDaySTBox);
		add(hourETBox);
		add(minuteETBox);
		add(timeOfDayETBox);
	}
}
