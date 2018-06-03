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
/**
 * 
 * @author Dylan Dewald
 *<h2>JPanel to input timesheet values for employee.</h2>
 *<p>A panel of dropdown boxes that keep track of an employee's time in and time out values.
 *		It uses the GrabBagLayout to keep all dropdown boxes together and neat. </p>
 */
public class TimeSheetPanel extends JPanel{
	
	//ST = Start time	ET = End Time
	private JComboBox[] hourSTBox;
	private JComboBox[] minuteSTBox;
	private JComboBox[] timeOfDaySTBox;
	private JComboBox[] hourETBox;
	private JComboBox[] minuteETBox;
	private JComboBox[] timeOfDayETBox;
	
	
	public TimeSheetPanel(){
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
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		for(int row = 0; row < 7; row++){
			//Gridy is what row it is on.
				//Gridx is the column that the component is placed.
			gbc.gridx = 0;
			gbc.gridy = row;
			setupRowOfTimeDropBoxes(gbc, row);
		}
	}
	
	private void setupRowOfTimeDropBoxes(GridBagConstraints gbc, int row){
		WorkDay[] day = WorkDay.values();
		add(new JLabel(day[row].toString()),gbc);
		gbc.gridx += 1;
		
		add(hourSTBox[row], gbc);
		gbc.gridx += 1;
		
		add(minuteSTBox[row], gbc);
		gbc.gridx += 1;
		
		add(timeOfDaySTBox[row], gbc);
		gbc.gridx += 1;
		
		add(new JLabel(" To "), gbc);
		gbc.gridx += 1;
		
		add(hourETBox[row], gbc);
		gbc.gridx += 1;
		
		add(minuteETBox[row], gbc);
		gbc.gridx += 1;
		
		add(timeOfDayETBox[row], gbc);
	}
}