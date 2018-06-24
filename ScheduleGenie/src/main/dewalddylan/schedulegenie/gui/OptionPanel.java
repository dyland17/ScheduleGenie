package main.dewalddylan.schedulegenie.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.names.GUIDim;
import main.dewalddylan.schedulegenie.tools.GUIBuilderFactory;

public class OptionPanel extends JPanel{
	private JComboBox<String> selectedEmployeeBox;
	private JButton addButton;
	private JButton editButton;
	private JButton scheduleButton;
	public OptionPanel(ActionListener buttonListener) {
		setPreferredSize(GUIDim.OPTIONPANELDIM);
		setLayout(new FlowLayout());
		setupPanel(buttonListener);
	}
	
	private void setupPanel(ActionListener buttonListener) {
		//Buttons for right now, might add scroll down menu before buttons.
		JLabel panelInfo = new JLabel("Employee Update Panel: ");
		add(panelInfo);
		selectedEmployeeBox = new JComboBox<String>();
		add(selectedEmployeeBox);
		
		addButton = GUIBuilderFactory.buildButton("Add", buttonListener);
		add(addButton);
		
		editButton = GUIBuilderFactory.buildButton("Edit", buttonListener);
		add(editButton);
		
		scheduleButton = GUIBuilderFactory.buildButton("Schedule", buttonListener);
		add(scheduleButton);
	}

	public JComboBox<String> getSelectedEmployeeBox() {
		return selectedEmployeeBox;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getEditButton() {
		return editButton;
	}

	public JButton getScheduleButton() {
		return scheduleButton;
	}
}
