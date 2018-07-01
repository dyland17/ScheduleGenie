package main.dewalddylan.schedulegenie.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import main.dewalddylan.schedulegenie.data.names.*;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.gui.panel.*;
import main.dewalddylan.schedulegenie.tools.GridBagHelper;

public class MainScreen extends Screen{
	//GUI components
//	private JTabbedPane tabbedPane;
	private JPanel outsidePanel;
	//New panels that replace old panels
	private InfoPanel infoPanel;
	private EmployeePanel employeePanel;
	private GraphPanel graphPanel;
	
	public MainScreen() {
		super(TitleName.MAINSCREENNAME, ScreenType.MAINSCREEN);
//		employeeMonitor = new EmployeeManager();
		styleEmployeeScreen();
		super.finishPackingScreen();
		
		System.out.println("Step 1: prefSize = " + outsidePanel.getPreferredSize());
	}
	
//	public void addNewEmployee(Employee newEmployee){
//		boolean wasDuplicate;
//		int employeeSize = employeeMonitor.getEmployeeList().size();
//		Random rand = new Random();
//		do{
//			wasDuplicate = false;
//			for(int i = 0; i < employeeSize; i++){
//				if(employeeMonitor.checkIfDublicate(newEmployee, employeeMonitor.getEmployee(i))){
//					wasDuplicate = true;
//					break;
//				}
//			}
//			if(wasDuplicate){
//				newEmployee.setEmployeeNumber(rand.nextInt(Employee.TOTALEMPLOYEENUMBERS));
//			}
//		}while(wasDuplicate);
//		employeeMonitor.addEmployee(newEmployee);
//		screenUpdate();
//	}
//	
//	public void employeeUpdate(Employee updateEmployee) {
//		for(Employee listEmployee: employeeMonitor.getEmployeeList()){
//			if(employeeMonitor.checkIfDublicate(updateEmployee, listEmployee)){
//				employeeMonitor.copyNewInformation(updateEmployee, listEmployee);
//				break;
//			}	
//		}
//		screenUpdate();
//	}
//	
//	public void screenUpdate(){
//		JComboBox selectedEmployeeBox = optionPanel.getSelectedEmployeeBox();
//		selectedEmployeeBox.removeAllItems();
//		for(Employee employee: employeeMonitor.getEmployeeList()){
//			selectedEmployeeBox.addItem(employee.getFullName());
//		}
//		MainPanel panel = (MainPanel) ((JScrollPane) tabbedPane.getSelectedComponent()).getViewport().getComponent(0);
//		panel.repaint();
//	}

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
		outsidePanel.setPreferredSize(GUIDim.MAINSCREENDIM);
		outsidePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints rules = new GridBagConstraints();
		rules.insets = new Insets(5,5,5,5);
		
		GridBagHelper.setupConstraints(rules, 0, 0, GridBagConstraints.VERTICAL, 0.0 , 1.0);
		employeePanel = new EmployeePanel();
		outsidePanel.add(employeePanel, rules);
		
		GridBagHelper.setupConstraints(rules, 0, 1);
		infoPanel = new InfoPanel();
		outsidePanel.add(infoPanel,rules);
		
		final int remainder = GridBagConstraints.REMAINDER;
		GridBagHelper.setupConstraints(rules, 1, 0, remainder, remainder);
		graphPanel = new GraphPanel();
		outsidePanel.add(graphPanel, rules);
		c.add(outsidePanel);
	}
	
	public void paintPanels(){
		employeePanel.repaint();
	}
}
