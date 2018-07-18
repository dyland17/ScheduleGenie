package main.dewalddylan.schedulegenie.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import main.dewalddylan.schedulegenie.data.names.*;
import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;
import main.dewalddylan.schedulegenie.data.manager.PanelManager;
import main.dewalddylan.schedulegenie.gui.panel.*;
import main.dewalddylan.schedulegenie.tools.GridBagHelper;

public class MainScreen extends Screen{
	//GUI components
//	private JTabbedPane tabbedPane;
	private JPanel outsidePanel;
	//New panels that replace old panels
	private PanelManager panelManager;
	public MainScreen() {
		super(TitleName.MAINSCREENNAME, ScreenType.MAINSCREEN);
		styleEmployeeScreen();
		super.finishPackingScreen();
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
		outsidePanel.setPreferredSize(GUIDim.MAINSCREENDIM);
		outsidePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints rules = new GridBagConstraints();
		rules.insets = new Insets(5,5,5,5);
		
		GridBagHelper.setupConstraints(rules, 0, 0, GridBagConstraints.VERTICAL, 0.0 , 1.0);
		EmployeePanel employeePanel = new EmployeePanel();
		outsidePanel.add(employeePanel, rules);
		
		GridBagHelper.setupConstraints(rules, 0, 1);
		InfoPanel infoPanel = new InfoPanel();
		outsidePanel.add(infoPanel,rules);
		
		final int remainder = GridBagConstraints.REMAINDER;
		GridBagHelper.setupConstraints(rules, 1, 0, remainder, remainder);
		GraphPanel graphPanel = new GraphPanel();
		outsidePanel.add(graphPanel, rules);
		c.add(outsidePanel);
		panelManager = new PanelManager(employeePanel, infoPanel,graphPanel);
	}
	public void paintPanels(){
		panelManager.paintPanels();
	}
}
