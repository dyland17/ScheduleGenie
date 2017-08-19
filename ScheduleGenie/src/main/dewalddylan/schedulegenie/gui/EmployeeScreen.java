package main.dewalddylan.schedulegenie.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.SGTextField;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;

public class EmployeeScreen  extends Window implements ActionListener{
	public static final int  TFSIZE = 10;
	//All GUI components
	protected SGTextField tfEmployeeFirstName;
	protected SGTextField tfEmployeeLastName;
	protected SGTextField tfAge;
	protected SGTextField tfTitle;
	protected SGTextField tfTotalHours;
	protected JButton butCancel;
	protected JButton butUpdate;
	//Size fields
	private final Font BOLDFONT = new Font(Font.SANS_SERIF,Font.BOLD,18);
	private final Font TEXTFONT = new Font(Font.SANS_SERIF,Font.PLAIN,18);
	private final Dimension JPANELOVERALLSIZE = new Dimension(320,130);
	private final Dimension JPANELINNERSIZE = new Dimension(320,130);
	public EmployeeScreen(String name, ScreenType type ){
		super(Window.EMPLOYEESCREEN,name);
		setupJFrame(type);
	}
	private void setupJFrame(ScreenType type) {
		tfEmployeeFirstName = new SGTextField(TypeOfTextField.ALPHABETREQ,"First Name");
		tfEmployeeLastName = new SGTextField(TypeOfTextField.ALPHABETREQ,"Last Name");
		tfAge = new SGTextField(TypeOfTextField.NUMBERREQ, "Age");
		tfTitle = new SGTextField(TypeOfTextField.ALPHABETOP,"Title");
		tfTotalHours = new SGTextField(TypeOfTextField.NUMBEROP,"Total Hours");
		butCancel = new JButton("Cancel");
		butCancel.addActionListener(this);
		if(type == ScreenType.NEWEMPLOYEE)
			butUpdate = new JButton("Create");
		else if(type == ScreenType.EDITEMPLOYEE)
			butUpdate = new JButton("Update");
		createEmployeeScreen(type);
	}
	
	private void createEmployeeScreen(ScreenType type) {
		
		Container c = window.getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel jpReqPanel = this.setupRequiredGUIForEmployeeScreen();
		c.add(jpReqPanel);
		
		JPanel jpOptPanel = this.setupOptionalGUIForEmployeeScreen();
		c.add(jpOptPanel);
		
		JPanel jpButPanel = this.setupButtonGUIForEmployeeScreen(type);
		c.add(jpButPanel);
		
		finishPackingScreen();
	}
	private JPanel setupRequiredGUIForEmployeeScreen(){
		JPanel jpReqPanel = new JPanel();
		jpReqPanel.setPreferredSize(JPANELOVERALLSIZE);
		JLabel jlRequired = new JLabel("<HTML><U>Required:</U></HTML>");
		jlRequired.setFont(BOLDFONT);
		jpReqPanel.add(jlRequired,BorderLayout.NORTH);
		
		JPanel jpReqInnerPanel = new JPanel();
		jpReqInnerPanel.setLayout(new FlowLayout());
		jpReqInnerPanel.setPreferredSize(JPANELINNERSIZE);
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
		jpOptPanelOuter.setPreferredSize(JPANELOVERALLSIZE);
		
		JLabel jlOptional = new JLabel("<HTML><U>Optional:</U></HTML>");
		jlOptional.setFont(BOLDFONT);
		jpOptPanelOuter.add(jlOptional, BorderLayout.NORTH);
		
		JPanel jpOptFieldsPanel = new JPanel();
		jpOptFieldsPanel.setPreferredSize(JPANELINNERSIZE);
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
	private JPanel setupButtonGUIForEmployeeScreen(ScreenType type) {
		JPanel jpButPanel = new JPanel();
		jpButPanel.setPreferredSize(JPANELOVERALLSIZE);
		
		butCancel.setPreferredSize(EMPLOYEEBUTTONSIZE);
		jpButPanel.add(butCancel, BorderLayout.WEST);
		
		butUpdate.setPreferredSize(EMPLOYEEBUTTONSIZE);
		jpButPanel.add(butUpdate, BorderLayout.EAST);
		return jpButPanel;
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
		@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == butCancel)
			window.dispose();
	}
	
}
