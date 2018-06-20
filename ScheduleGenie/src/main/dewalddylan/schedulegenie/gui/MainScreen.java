package main.dewalddylan.schedulegenie.gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.EmployeeManager;
import main.dewalddylan.schedulegenie.data.names.*;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.exceptions.EmployeeNotSelectedException;
import main.dewalddylan.schedulegenie.tools.GUIBuilderFactory;

public class MainScreen extends Screen{
	//GUI components
	private OptionPanel optionPanel;
	private JTabbedPane tabbedPane;
	private JPanel outsidePanel;
	private InfoPanel infoPanel;
	//Data fields
	public static EmployeeManager employeeMonitor;
	
	public MainScreen() {
		super(TitleName.MAINSCREENNAME, ScreenType.MAINSCREEN);
		employeeMonitor = new EmployeeManager();
		styleEmployeeScreen();
		super.finishPackingScreen();
	}

	private void setupGraphPanel() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(GUIDim.MAINPANELDIM);
		String[] days = {"Sunday","Monday","Tuesday","Wednesday",
							"Thursday","Friday","Saturday"};
		for(int i = 0; i < 7; i++){
			MainPanel drawPanel = new MainPanel();
			JScrollPane scrollPane = new JScrollPane(drawPanel);
			tabbedPane.add(days[i], scrollPane);
		}
		outsidePanel.add(tabbedPane,BorderLayout.EAST);
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
		JComboBox selectedEmployeeBox = optionPanel.getSelectedEmployeeBox();
		selectedEmployeeBox.removeAllItems();
		for(Employee employee: employeeMonitor.getEmployeeList()){
			selectedEmployeeBox.addItem(employee.getFullName());
		}
		MainPanel panel = (MainPanel) ((JScrollPane) tabbedPane.getSelectedComponent()).getViewport().getComponent(0);
		panel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		try{
//			window.setEnabled(false);
//			Object source = e.getSource();
//			JComboBox<String> selectedEmployeeBox = optionPanel.getSelectedEmployeeBox();
//			if(source.equals( optionPanel.getAddButton())){
//				new NewEmployeeScreen(MainScreen.this);
//			}
//			else if(employeeMonitor.isListEmpty()){
//				throw new EmployeeNotSelectedException();
//			}
//			else if(source.equals(optionPanel.getEditButton())){
//				new EditEmployeeScreen(employeeMonitor.findEmployeeByName(((String) selectedEmployeeBox.getSelectedItem())),MainScreen.this);
//			}
//			else if(source.equals(optionPanel.getScheduleButton())){
//				new TimeSheetEmployeeScreen(employeeMonitor.findEmployeeByName(((String) selectedEmployeeBox.getSelectedItem())), MainScreen.this);
//			}
		}
//		catch(EmployeeNotSelectedException ex){
//			ex.showMessage();
//			window.setEnabled(true);
//			window.toFront();
//		}
//	}

	@Override
	protected void styleEmployeeScreen() {
		Container c = window.getContentPane();
		outsidePanel = new JPanel();
		outsidePanel.setLayout(new GridBagLayout());
		GridBagConstraints rules = new GridBagConstraints();
		rules.insets = new Insets(5,5,5,5);
		
		outsidePanel.setPreferredSize(GUIDim.MAINSCREENDIM);
		Dimension dim = new Dimension((int)(outsidePanel.getPreferredSize().getWidth()*.3),(int)(outsidePanel.getPreferredSize().getWidth()*.3));
		
		rules.gridx = 0;
		rules.gridy = 1;
		infoPanel = new InfoPanel(dim);
		outsidePanel.add(infoPanel,rules);
		c.add(outsidePanel);
	}
}
