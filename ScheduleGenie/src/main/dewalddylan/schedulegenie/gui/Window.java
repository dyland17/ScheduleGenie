package main.dewalddylan.schedulegenie.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;

public abstract class Window implements ActionListener{
	//All GUI components
	protected JFrame window;
	protected JTextField tfEmployeeFirstName;
	protected JTextField tfEmployeeLastName;
	protected JTextField tfAge;
	protected JTextField tfTitle;
	protected JTextField tfTotalHours;
	protected JButton butCancel;
	protected JButton butUpdate;
	//Size fields
	private final int  TFSIZE = 10;
	private final Font BOLDFONT = new Font(Font.SANS_SERIF,Font.BOLD,18);
	private final Font TEXTFONT = new Font(Font.SANS_SERIF,Font.PLAIN,18);
	private final Dimension EMPLOYEESCREEN = new Dimension(420,400);
	private final Dimension JPANELOVERALLSIZE = new Dimension(320,130);
	private final Dimension JPANELINNERSIZE = new Dimension(320,130);
	private final Dimension BUTTONSIZE = new Dimension(140, 60);
	
	public  Window(String name,ScreenType type){
		setupJFrame(name,type);
	}
	private void setupJFrame(String name, ScreenType type) {
		window = new JFrame(name);
		tfEmployeeFirstName = new JTextField(TFSIZE);
		tfEmployeeLastName = new JTextField(TFSIZE);
		tfAge = new JTextField(TFSIZE);
		tfTitle = new JTextField(TFSIZE);
		tfTotalHours = new JTextField(TFSIZE);
		butCancel = new JButton("Cancel");
		butCancel.addActionListener(this);
		if(type == ScreenType.NEWEMPLOYEE)
			butUpdate = new JButton("Create");
		else if(type == ScreenType.EDITEMPLOYEE)
			butUpdate = new JButton("Update");
		createEmployeeScreen(type);
	}
	private void createEmployeeScreen(ScreenType type) {
		window.setPreferredSize(EMPLOYEESCREEN);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = window.getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel jpReqPanel = this.setupRequiredGUIForEmployeeScreen();
		c.add(jpReqPanel);
		
		JPanel jpOptPanel = this.setupOptionalGUIForEmployeeScreen();
		c.add(jpOptPanel);
		
		JPanel jpButPanel = this.setupButtonGUIForEmployeeScreen(type);
		c.add(jpButPanel);
		
		window.requestFocusInWindow();
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
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
		
		butCancel.setPreferredSize(BUTTONSIZE);
		jpButPanel.add(butCancel, BorderLayout.WEST);
		
		butUpdate.setPreferredSize(BUTTONSIZE);
		jpButPanel.add(butUpdate, BorderLayout.EAST);
		return jpButPanel;
	}
		@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == butCancel)
			window.dispose();
	}
	public static void main(String[] args){
		//new NewEmployeeScreen("New Employee");
		new EditEmployeeScreen(new Employee("Danny" , "Phantom",21));
	}

}
