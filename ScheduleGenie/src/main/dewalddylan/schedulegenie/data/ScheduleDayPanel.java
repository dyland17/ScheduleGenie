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
	private JComboBox[] hourSTBox;
	private JComboBox[] minuteSTBox;
	private JComboBox[] timeOfDaySTBox;
	private JComboBox[] hourETBox;
	private JComboBox[] minuteETBox;
	private JComboBox[] timeOfDayETBox;
	
	
	public ScheduleDayPanel(){
		super();
		this.setPreferredSize(new Dimension(400,120));
		this.setLayout(new FlowLayout());
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
	class HourPanel extends JPanel{
		private JComboBox[] hourBox;
		private JComboBox[] minBox;
		private JComboBox[] TODBox;
		public HourPanel(JComboBox[] hBox, JComboBox[] mBox, JComboBox[] todBox){
			hourBox = hBox;
			minBox = mBox;
			TODBox = todBox;
			this.setLayout(new FlowLayout());
			this.setPreferredSize(new Dimension(200, 100));
			for(int i = 0; i < hBox.length; i++){
				this.add(hourBox[i]);
				this.add(minBox[i]);
				this.add(TODBox[i]);
			}
		}
		public JComboBox[] getHourBox() {
			return hourBox;
		}
		public JComboBox[] getMinBox() {
			return minBox;
		}
		public JComboBox[] getTODBox() {
			return TODBox;
		}
		
		
	}
	private void setupPanel() {
		HourPanel STPanel = new HourPanel(hourSTBox, minuteSTBox,timeOfDaySTBox);
		HourPanel ETPanel = new HourPanel(hourETBox, minuteETBox,timeOfDayETBox);
		add(STPanel);
		add(ETPanel);
	}
}
