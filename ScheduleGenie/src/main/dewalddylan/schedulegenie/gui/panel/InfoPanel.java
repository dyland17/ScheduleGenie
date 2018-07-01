package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
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
import main.dewalddylan.schedulegenie.data.names.GUIDim;
import main.dewalddylan.schedulegenie.tools.GridBagHelper;

public class InfoPanel extends Panel{
	private LabelComponentPair<JTextField> firstName;
	private LabelComponentPair<JTextField> lastName;
	private LabelComponentPair<JTextField> age;
	private LabelComponentPair<JTextField> title;
	private LabelComponentPair<JTextField> totalHours;
	private LabelComponentPair<JComboBox> time_in;
	private LabelComponentPair<JComboBox> time_out;
	
	public InfoPanel(){
		super(GUIDim.SIDEPANELDIM);
		init();
		setupPanel();
	}
	@Override
	protected void init() {
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

	protected void setupPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(2,2,2,2);
		
		GridBagHelper.setupConstraints(constraints,0, 0);
		this.addLabelComponentPair(firstName, ComponentFactory.FIRSTNAME,constraints);
		GridBagHelper.setupConstraints(constraints,0, 1);
		this.addLabelComponentPair(lastName, ComponentFactory.LASTNAME,constraints);
		GridBagHelper.setupConstraints(constraints,0, 2);
		this.addLabelComponentPair(age, ComponentFactory.AGE,constraints);
		GridBagHelper.setupConstraints(constraints,0, 3);
		this.addLabelComponentPair(title, ComponentFactory.TITLE,constraints);
		GridBagHelper.setupConstraints(constraints,0, 4);
		this.addLabelComponentPair(totalHours, ComponentFactory.TOTALHOURS,constraints);
		GridBagHelper.setupConstraints(constraints,0, 5);
		this.addLabelComponentPair(time_in,constraints);
		GridBagHelper.setupConstraints(constraints,0, 6);
		this.addLabelComponentPair(time_out,constraints);
	}

	private  void addLabelComponentPair(LabelComponentPair<JTextField> componentPair, String name,GridBagConstraints rules){
		this.add(componentPair.getJLabel(),rules);
		rules.gridx +=1;
		rules.gridwidth = GridBagConstraints.REMAINDER;
		rules.fill = GridBagConstraints.HORIZONTAL;
		this.add(componentPair.getComponentPart(name),rules);
		//Resets rules for next method call.
		rules.gridwidth = 1;
		rules.fill = GridBagConstraints.NONE;
		
		
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
