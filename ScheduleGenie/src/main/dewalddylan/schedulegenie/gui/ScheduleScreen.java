package main.dewalddylan.schedulegenie.gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.EmployeeManager;
import main.dewalddylan.schedulegenie.data.exceptions.EmployeeNotSelectedException;

public class ScheduleScreen extends Window{
	//GUI components
	private JPanel optionPanel;
	private JTabbedPane tabbedPane;
	private JPanel outsidePanel;
	private JComboBox<String> comboBoxEmployee;
	private JButton addButton;
	private JButton editButton;
	private JButton scheduleButton;
	//Dimensions for gui
	public static final Dimension OPTIONPANELSIZE = new Dimension(200,640);
	public static final Dimension EDITEMPLOYEEPANELSIZE = new Dimension(190, 305);
	public static final Dimension SCHEDULEPANELSIZE = new Dimension(500,560);
	//Data
	public static EmployeeManager employeeMonitor;
	public ScheduleScreen() {
		super(Window.SCHEDULESCREEN, Window.MAINSCREEN);
		employeeMonitor = new EmployeeManager();
		setupScreen();
		this.finishPackingScreen();
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
		optionPanel.add(comboBoxEmployee);
		addButton = new JButton("Add");
		addButton.setPreferredSize(Window.SCHEDULEBUTTONSIZE);
		addButton.addActionListener(this);
		optionPanel.add(addButton);
		editButton = new JButton("Edit");
		editButton.setPreferredSize(Window.SCHEDULEBUTTONSIZE);
		editButton.addActionListener(this);
		optionPanel.add(editButton);
		
		scheduleButton = new JButton("Schedule");
		scheduleButton.setPreferredSize(Window.SCHEDULEBUTTONSIZE);
		scheduleButton.addActionListener(this);
		optionPanel.add(scheduleButton);
		
		outsidePanel.add(optionPanel, BorderLayout.WEST);
	}
	
	public void addNewEmployee(Employee newEmployee){
		boolean wasDuplicate;
		int employeeSize = employeeMonitor.getEmployeeList().size();
		Random rand = new Random();
		do{
			wasDuplicate = false;
			for(int i = 0; i < employeeSize; i++){
				if(employeeMonitor.checkIfDublicate(newEmployee, employeeMonitor.getEmployee(i))){
					wasDuplicate = true;
					break;
				}
			}
			if(wasDuplicate){
				newEmployee.setEmployeeNumber(rand.nextInt(Employee.TOTALEMPLOYEENUMBERS));
			}
		}while(wasDuplicate);
		employeeMonitor.addEmployee(newEmployee);
		screenUpdate();
	}
	
	public void employeeUpdate(Employee updateEmployee) {
		for(Employee listEmployee: employeeMonitor.getEmployeeList()){
			if(employeeMonitor.checkIfDublicate(updateEmployee, listEmployee)){
				employeeMonitor.copyNewInformation(updateEmployee, listEmployee);
				break;
			}	
		}
		screenUpdate();
	}
	
	public void screenUpdate(){
		comboBoxEmployee.removeAllItems();
		for(Employee employee: employeeMonitor.getEmployeeList()){
			comboBoxEmployee.addItem(employee.getFirstName() + " " + employee.getLastName());
		}
		SchedulePanel panel = (SchedulePanel) ((JScrollPane) tabbedPane.getSelectedComponent()).getViewport().getComponent(0);
		panel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			window.setEnabled(false);
			boolean employeeListIsEmpty = employeeMonitor.getEmployeeList().isEmpty();
			if(e.getSource().equals( addButton)){
				new NewEmployeeScreen(ScheduleScreen.this);
			}
			else{
				if(employeeListIsEmpty){
					throw new EmployeeNotSelectedException();
				}
				else if(e.getSource().equals(editButton)){
					new EditEmployeeScreen(employeeMonitor.findEmployeeByName(((String) comboBoxEmployee.getSelectedItem())),ScheduleScreen.this);
				}
				else if(e.getSource().equals(scheduleButton)){
					new TimeSheetEmployeeScreen(employeeMonitor.findEmployeeByName(((String) comboBoxEmployee.getSelectedItem())), ScheduleScreen.this);
				}
			}
		}
		catch(EmployeeNotSelectedException ex){
			ex.showMessage();
			window.setEnabled(true);
		}
	}
}
