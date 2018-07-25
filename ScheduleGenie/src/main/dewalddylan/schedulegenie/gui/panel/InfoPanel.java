package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.LabelComponentPair;
import main.dewalddylan.schedulegenie.data.Time;
import main.dewalddylan.schedulegenie.data.component.ComponentFactory;
import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;
import main.dewalddylan.schedulegenie.data.names.GUIDim;
import main.dewalddylan.schedulegenie.data.names.LabelInfo;
import main.dewalddylan.schedulegenie.tools.GridBagHelper;
import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

public class InfoPanel extends Panel{
	private LabelComponentPair firstName;
	private LabelComponentPair lastName;
	private LabelComponentPair age;
	private LabelComponentPair title;
	private LabelComponentPair totalHours;
	private LabelComponentPair time_in;
	private LabelComponentPair time_out;
	public InfoPanel(){
		super(GUIDim.SIDEPANELDIM, "InfoPanel: ");
		init();
		setupPanel();
	}
	
	@Override
	protected void init() {
		firstName = new LabelComponentPair("First name:", ComponentFactory.createComponentJTextField(ComponentFactory.FIRSTNAME));
		lastName = new LabelComponentPair("Last name:", ComponentFactory.createComponentJTextField(ComponentFactory.LASTNAME));
		age = new LabelComponentPair("Age:", ComponentFactory.createComponentJTextField(ComponentFactory.AGE));
		title = new LabelComponentPair("Job title:", ComponentFactory.createComponentJTextField(ComponentFactory.TITLE));
		totalHours = new LabelComponentPair("Total hours:",ComponentFactory.createComponentJTextField(ComponentFactory.TOTALHOURS));
		Integer hourTime[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
		Integer minTime[] = {0,15,30,45};
		time_in = new LabelComponentPair("Time-in:", ComponentFactory.createTimeComboBox(hourTime, minTime));
		time_out = new LabelComponentPair("Time-out",ComponentFactory.createTimeComboBox(hourTime, minTime));
	}

	protected void setupPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(2,2,2,2);
		
		GridBagHelper.setupConstraints(constraints,0, 0);
		this.addLabelComponentPairTextField(firstName, ComponentFactory.FIRSTNAME,constraints);
		GridBagHelper.setupConstraints(constraints,0, 1);
		this.addLabelComponentPairTextField(lastName, ComponentFactory.LASTNAME,constraints);
		GridBagHelper.setupConstraints(constraints,0, 2);
		this.addLabelComponentPairTextField(age, ComponentFactory.AGE,constraints);
		GridBagHelper.setupConstraints(constraints,0, 3);
		this.addLabelComponentPairTextField(title, ComponentFactory.TITLE,constraints);
		GridBagHelper.setupConstraints(constraints,0, 4);
		this.addLabelComponentPairTextField(totalHours, ComponentFactory.TOTALHOURS,constraints);
		GridBagHelper.setupConstraints(constraints,0, 5);
		this.addLabelComponentPairComboBox(time_in,constraints);
		GridBagHelper.setupConstraints(constraints,0, 6);
		this.addLabelComponentPairComboBox(time_out,constraints);
	}

	private  void addLabelComponentPairTextField(LabelComponentPair componentPair, String name,GridBagConstraints rules){
		this.add(componentPair.getJLabel(),rules);
		rules.gridx +=1;
		rules.gridwidth = GridBagConstraints.REMAINDER;
		rules.fill = GridBagConstraints.HORIZONTAL;
		this.add(componentPair.getComponentPart(name),rules);
		//Resets rules for next method call.
		rules.gridwidth = 1;
		rules.fill = GridBagConstraints.NONE;
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.drawTitleLineCenteredTop(g2d);
	}

	private void addLabelComponentPairComboBox(LabelComponentPair componentPair, GridBagConstraints rules){
		this.add(componentPair.getJLabel(),rules);
		rules.gridx +=1;
		this.add(componentPair.getComponentPart(ComponentFactory.TIME_HOUR),rules);
		rules.gridx +=1;
		this.add(componentPair.getComponentPart(ComponentFactory.TIME_MIN),rules);
		rules.gridx +=1;
		this.add(componentPair.getComponentPart(ComponentFactory.TIMEOFDAY),rules);
	}
	
	private void setJTextField(LabelComponentPair componentPair, String keyValue, String value) {
		JTextField currentField = (JTextField)componentPair.getComponentPart(keyValue);
		currentField.setText(value);
	}
	
	private void setJComboBoxes(LabelComponentPair componentPair, final Time setTime) {
		JComboBox currentBox = (JComboBox) componentPair.getComponentPart(ComponentFactory.TIME_HOUR);
		currentBox.setSelectedIndex(setTime.getHour());
		
		currentBox = (JComboBox) componentPair.getComponentPart(ComponentFactory.TIME_MIN);
		currentBox.setSelectedIndex(setTime.getMinute());
		
		currentBox = (JComboBox) componentPair.getComponentPart(ComponentFactory.TIMEOFDAY);
		currentBox.setSelectedItem(setTime.getTimeOfDay());
	}
	
	public void displayInfo(Employee employee, WorkDay currentDay) {
		setJTextField(firstName, ComponentFactory.FIRSTNAME, employee.firstName());
		setJTextField(lastName, ComponentFactory.LASTNAME, employee.lastName());
		setJTextField(age, ComponentFactory.AGE,Integer.toString(employee.age()));
		setJTextField(title,ComponentFactory.TITLE,employee.title());
		setJTextField(totalHours, ComponentFactory.TOTALHOURS,Integer.toString(employee.getTotalHours()));
		
		final Time startTime = employee.getStartTime(currentDay);
		setJComboBoxes(time_in, startTime);
		
		final Time endTime = employee.getEndTime(currentDay);
		setJComboBoxes(time_out, endTime);
	}
}
