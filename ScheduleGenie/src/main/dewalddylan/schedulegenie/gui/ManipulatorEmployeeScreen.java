package main.dewalddylan.schedulegenie.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.GUIDim;
import main.dewalddylan.schedulegenie.data.SGTextField;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;

public abstract class ManipulatorEmployeeScreen extends EmployeeScreen {
	protected SGTextField tfEmployeeFirstName;
	protected SGTextField tfEmployeeLastName;
	protected SGTextField tfAge;
	protected SGTextField tfTitle;
	protected SGTextField tfTotalHours;
	protected ScheduleScreen mainScreen;
	
	public ManipulatorEmployeeScreen(String titleName, ScreenType type, ScheduleScreen mScreen) {
		super(titleName, type);
		mainScreen = mScreen;
		tfEmployeeFirstName = new SGTextField(TypeOfTextField.ALPHABETREQ,"First Name");
		tfEmployeeLastName = new SGTextField(TypeOfTextField.ALPHABETREQ,"Last Name");
		tfAge = new SGTextField(TypeOfTextField.NUMBERREQ, "Age");
		tfTitle = new SGTextField(TypeOfTextField.ALPHABETOP,"Title");
		tfTotalHours = new SGTextField(TypeOfTextField.NUMBEROP,"Total Hours");
	}
	@Override
	protected void styleJFrame() {
		Container c = window.getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel jpReqPanel = setupRequiredGUIForEmployeeScreen();
		c.add(jpReqPanel);
		
		JPanel jpOptPanel = setupOptionalGUIForEmployeeScreen();
		c.add(jpOptPanel);
		
		JPanel jpButPanel = super.setupButtonGUIForEmployeeScreen();
		c.add(jpButPanel);
	}
	
	private JPanel setupRequiredGUIForEmployeeScreen(){
		JPanel jpReqPanel = new JPanel();
		jpReqPanel.setPreferredSize(GUIDim.JPANELOVERALLDIM);
		JLabel jlRequired = new JLabel("<HTML><U>Required:</U></HTML>");
		jlRequired.setFont(BOLDFONT);
		jpReqPanel.add(jlRequired,BorderLayout.NORTH);
		
		JPanel jpReqInnerPanel = new JPanel();
		jpReqInnerPanel.setLayout(new FlowLayout());
		jpReqInnerPanel.setPreferredSize(GUIDim.JPANELINNERDIM);
		JLabel jlEmployeeFirstName = new JLabel("Employee's first name:");
		jlEmployeeFirstName.setFont(TEXTFONT);
		jpReqInnerPanel.add(jlEmployeeFirstName);
		jpReqInnerPanel.add(tfEmployeeFirstName);
		
		JLabel jlEmployeeLastName = new JLabel("Employee's last name:");
		jlEmployeeLastName.setFont(TEXTFONT);
		jpReqInnerPanel.add(jlEmployeeLastName);
		jpReqInnerPanel.add(tfEmployeeLastName);
		
		JLabel jlAge = new JLabel("Employee's age:");
		jlAge.setFont(TEXTFONT);
		jpReqInnerPanel.add(jlAge);
		jpReqInnerPanel.add(tfAge);
		jpReqPanel.add(jpReqInnerPanel,BorderLayout.SOUTH);
		return jpReqPanel;
	}
	
	private JPanel setupOptionalGUIForEmployeeScreen(){
		JPanel jpOptPanelOuter = new JPanel();
		jpOptPanelOuter.setPreferredSize(GUIDim.JPANELOVERALLDIM);
		
		JLabel jlOptional = new JLabel("<HTML><U>Optional:</U></HTML>");
		jlOptional.setFont(BOLDFONT);
		jpOptPanelOuter.add(jlOptional, BorderLayout.NORTH);
		
		JPanel jpOptFieldsPanel = new JPanel();
		jpOptFieldsPanel.setPreferredSize(GUIDim.JPANELINNERDIM);
		jpOptFieldsPanel.setLayout(new FlowLayout());
		
		JLabel jlTitle = new JLabel("Employee's title: ");
		jlTitle.setFont(TEXTFONT);
		jpOptFieldsPanel.add(jlTitle);
		jpOptFieldsPanel.add(tfTitle);
		
		JLabel jlTotalHours = new JLabel("Employee's total hours: ");
		jlTotalHours.setFont(TEXTFONT);
		jpOptFieldsPanel.add(jlTotalHours);
		jpOptFieldsPanel.add(tfTotalHours);
		jpOptPanelOuter.add(jpOptFieldsPanel, BorderLayout.SOUTH);
		return jpOptPanelOuter;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == butCancel){
			mainScreen.window.setEnabled(true);
			mainScreen.window.requestFocus();
			window.dispose();
		}
	}
	@Override
	public void windowClosing(WindowEvent e) {
		mainScreen.window.requestFocus();
		mainScreen.window.setEnabled(true);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		mainScreen.window.requestFocus();
		mainScreen.window.setEnabled(true);
	}
	@Override
	public void windowOpened(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
	public SGTextField[] getAllSGTextFields(){
		SGTextField[] allFields = new SGTextField[5];
		allFields[0] = tfEmployeeFirstName;
		allFields[1] = tfEmployeeLastName;
		allFields[2] = tfAge;
		allFields[3] = tfTitle;
		allFields[4] = tfTotalHours;
		return allFields;
		
	}
}
