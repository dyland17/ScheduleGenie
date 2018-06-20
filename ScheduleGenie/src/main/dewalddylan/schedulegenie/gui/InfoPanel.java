package main.dewalddylan.schedulegenie.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.LabelComponentPair;
import main.dewalddylan.schedulegenie.data.component.ComponentFactory;
import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;

public class InfoPanel extends JPanel{
	private LabelComponentPair<JTextField> firstName;
	private LabelComponentPair<JTextField> lastName;
	private LabelComponentPair<JTextField> age;
	private LabelComponentPair<JTextField> title;
	private LabelComponentPair<JTextField> totalHours;
	private LabelComponentPair<JComboBox> time_in;
	private LabelComponentPair<JComboBox> time_out;
	
	public InfoPanel(Dimension dim){
		initialize();
		setupPanel(dim);
	}

	private void initialize() {
		firstName = new LabelComponentPair<JTextField>("First name:", ComponentFactory.createComponentJTextField(ComponentFactory.FIRSTNAME));
		lastName = new LabelComponentPair<JTextField>("Last name:", ComponentFactory.createComponentJTextField(ComponentFactory.LASTNAME));
		age = new LabelComponentPair<JTextField>("Age:", ComponentFactory.createComponentJTextField(ComponentFactory.AGE));
		title = new LabelComponentPair<JTextField>("Job title:", ComponentFactory.createComponentJTextField(ComponentFactory.TITLE));
		totalHours = new LabelComponentPair<JTextField>("Total hours:",ComponentFactory.createComponentJTextField(ComponentFactory.TOTALHOURS));
		Integer hourTime[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
		Integer minTime[] = {0,15,30,45};
		time_in = new LabelComponentPair<JComboBox>("Time-in:", ComponentFactory.createTimeComboBox(hourTime, minTime));
		time_out = new LabelComponentPair<JComboBox>("Time-out",ComponentFactory.createTimeComboBox(hourTime, minTime));
	}

	private void setupPanel(Dimension dim) {
		this.setPreferredSize(dim);
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(2,2,2,2);
		setRulesForLayout(0, 0, constraints);
		this.addLabelComponentPair(firstName, ComponentFactory.FIRSTNAME,constraints);
		setRulesForLayout(0, 1, constraints);
		this.addLabelComponentPair(lastName, ComponentFactory.LASTNAME,constraints);
		setRulesForLayout(0, 2, constraints);
		this.addLabelComponentPair(age, ComponentFactory.AGE,constraints);
		setRulesForLayout(0, 3, constraints);
		this.addLabelComponentPair(title, ComponentFactory.TITLE,constraints);
		setRulesForLayout(0, 4, constraints);
		this.addLabelComponentPair(totalHours, ComponentFactory.TOTALHOURS,constraints);
		setRulesForLayout(0, 5, constraints);
		this.addLabelComponentPair(time_in,constraints);
		setRulesForLayout(0, 6, constraints);
		this.addLabelComponentPair(time_out,constraints);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	private void setRulesForLayout(int posX, int posY, GridBagConstraints rules) {
		rules.gridx = posX;
		rules.gridy = posY;
		
	}

	private  void addLabelComponentPair(LabelComponentPair<JTextField> componentPair, String name,GridBagConstraints rules){
		this.add(componentPair.getJLabel(),rules);
		rules.gridx +=1;
		this.add(componentPair.getComponentPart(name),rules);
		
	}
	
	private void addLabelComponentPair(LabelComponentPair<JComboBox> componentPair, GridBagConstraints rules){
		this.add(componentPair.getJLabel(),rules);
		rules.gridx +=1;
		this.add(componentPair.getComponentPart(ComponentFactory.TIME_HOUR),rules);
		rules.gridx +=1;
		this.add(componentPair.getComponentPart(ComponentFactory.TIME_MIN),rules);
	}
	
//	public void clearBoxes(){
//		((JTextField) firstName.getEdiatableField()).setText("");
//		((JTextField) lastName.getEdiatableField()).setText("");
//		((JTextField) age.getEdiatableField()).setText("");
//		((JTextField) title.getEdiatableField()).setText("");
//		((JTextField) totalHours.getEdiatableField()).setText("");
//		clearDropDownBoxes(((DoubleDropDownBox) time_in.getEdiatableField()));
//		clearDropDownBoxes(((DoubleDropDownBox) time_out.getEdiatableField()));
//	}
//	private void clearDropDownBoxes(DoubleDropDownBox doubleBoxComponent){
//		doubleBoxComponent.setFirstBoxIndexItem(0);
//		doubleBoxComponent.setLastBoxItemByIndex(0);
//	}
}
