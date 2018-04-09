package main.dewalddylan.schedulegenie.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.EmployeeManager;

public class ScheduleScreen extends Window{
	//GUI components
	private JPanel optionPanel;
	private JTabbedPane tabbedPane;
	private JPanel outsidePanel;
	private JComboBox<String> comboBoxEmployee;
	private JButton addButton;
	private JButton editButton;
	//Dimensions for gui
	public static final Dimension OPTIONPANELSIZE = new Dimension(190,620);
	public static final Dimension SCHEDULEPANELSIZE = new Dimension(500,560);
	//Data
	public static EmployeeManager employeeMonitor;
	public ScheduleScreen() {
		super(Window.SCHEDULESCREEN, Window.MAINSCREEN);
		setupScreen();
		this.finishPackingScreen();
		employeeMonitor = new EmployeeManager();
	}

	private void setupScreen() {
		Container c = window.getContentPane();
		outsidePanel = new JPanel();
		outsidePanel.setPreferredSize(Window.SCHEDULESCREEN);
		setupOptionPanel();
		setupGraphPanel();
		c.add(outsidePanel);
	}

	private void setupGraphPanel() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(SCHEDULEPANELSIZE);
		String[] days = {"Sunday","Monday","Tuesday","Wednesday",
							"Thursday","Friday","Saturday"};
		for(int i = 0; i < 7; i++){
			SchedulePanel drawPanel = new SchedulePanel();
			JScrollPane scrollPane = new JScrollPane(drawPanel);
			tabbedPane.add(days[i], scrollPane);
		}
		outsidePanel.add(tabbedPane,BorderLayout.EAST);
	}

	private void setupOptionPanel() {
		optionPanel = new JPanel();
		optionPanel.setPreferredSize(OPTIONPANELSIZE);
		optionPanel.setLayout(new FlowLayout());
		//Buttons for right now, might add scroll down menu before buttons.
		JLabel panelInfo = new JLabel("Employee Update Panel: ");
		optionPanel.add(panelInfo);
		comboBoxEmployee = new JComboBox<String>();
		//Temporary name for comboBox.
		comboBoxEmployee.addItem("Jeffery Hutchman");
		optionPanel.add(comboBoxEmployee);
		addButton = new JButton("Add");
		addButton.setPreferredSize(Window.SCHEDULEBUTTONSIZE);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				window.setEnabled(false);
				new NewEmployeeScreen(ScheduleScreen.this);
			}
		});
		optionPanel.add(addButton);
		editButton = new JButton("Edit");
		editButton.setPreferredSize(Window.SCHEDULEBUTTONSIZE);
		optionPanel.add(editButton);
		
		outsidePanel.add(optionPanel, BorderLayout.WEST);
	}

	public void employeeUpdate(Employee updateEmployee) {
		for(Employee listEmployee: employeeMonitor.getEmployeeList()){
			if(employeeMonitor.checkIfDublicate(updateEmployee, listEmployee)){
				employeeMonitor.copyNewInformation(updateEmployee, listEmployee);
				return;
			}	
		}
		employeeMonitor.addEmployee(updateEmployee);
		screenUpdate();
	}
	public void screenUpdate(){
		SchedulePanel panel = (SchedulePanel) tabbedPane.getComponent(tabbedPane.getSelectedIndex());
		panel.repaint();
	}
}
