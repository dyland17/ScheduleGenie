package main.dewalddylan.schedulegenie.data;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.enumerations.TimeOfDay;
import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

public class ScheduleDayPanel extends JPanel{
	//ST = Start time	ET = End Time
	private JComboBox[] hourSTBox;
	private JComboBox[] minuteSTBox;
	private JComboBox[] timeOfDaySTBox;
	private JComboBox[] hourETBox;
	private JComboBox[] minuteETBox;
	private JComboBox[] timeOfDayETBox;
	
	
	public ScheduleDayPanel(){
		this.setPreferredSize(new Dimension(430,280));
		this.setLayout(new GridBagLayout());
		Integer hourTime[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		Integer minTime[] = {0,15,30,45};
		hourSTBox = new JComboBox[7];
		minuteSTBox  = new JComboBox[7];
		timeOfDaySTBox  = new JComboBox[7];
		hourETBox  = new JComboBox[7];
		minuteETBox  = new JComboBox[7];
		timeOfDayETBox  = new JComboBox[7];
		for(int i = 0; i  < 7; i++){
			hourSTBox[i] = new JComboBox(hourTime);
			minuteSTBox[i] = new JComboBox(minTime);
			timeOfDaySTBox[i] = new JComboBox(TimeOfDay.values());
			hourETBox[i] = new JComboBox(hourTime);
			minuteETBox[i] = new JComboBox(minTime);
			timeOfDayETBox[i] = new JComboBox(TimeOfDay.values());
		}
		setupPanel();
	}
	
	private void setupPanel() {
		WorkDay[] day = WorkDay.values();
		GridBagConstraints gbc = new GridBagConstraints();
		for(int i = 0; i < 7; i++){
			//Gridy is what row it is on.
				//Gridx is the column that the component is placed.
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.insets = new Insets(5,5,5,5);
			add(new JLabel(day[i].toString()),gbc);
			moveGBCRightOneCol(gbc);
			add(hourSTBox[i], gbc);
			moveGBCRightOneCol(gbc);
			add(minuteSTBox[i], gbc);
			moveGBCRightOneCol(gbc);
			add(timeOfDaySTBox[i], gbc);
			moveGBCRightOneCol(gbc);
			add(new JLabel(" To "), gbc);
			moveGBCRightOneCol(gbc);
			add(hourETBox[i], gbc);
			moveGBCRightOneCol(gbc);
			add(minuteETBox[i], gbc);
			moveGBCRightOneCol(gbc);
			add(timeOfDayETBox[i], gbc);
		}
	}
	private void moveGBCRightOneCol(GridBagConstraints gbc){
		gbc.gridx += 1;
	}
}