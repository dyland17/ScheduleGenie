package dewalddylan.schedulegenie.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dewalddylan.data.enumerations.ScreenType;

public abstract class Window {
	//All GUI components
	protected JFrame window;
	protected JTextField tfEmployeeName;
	protected JTextField tfAge;
	protected JTextField tfTitle;
	protected JTextField tfTotalHours;
	protected JButton butCancel;
	protected JButton butCreate;
	//Size fields
	private final int  TFSIZE = 10;
	private final Font BOLDFONT = new Font(Font.SANS_SERIF,Font.BOLD,18);
	private final Font TEXTFONT = new Font(Font.SANS_SERIF,Font.PLAIN,18);
	private final Dimension EMPLOYEESCREEN = new Dimension(420,400);
	private final Dimension JPANELOVERALLSIZE = new Dimension(320,110);
	private final Dimension JPANELINNERSIZE = new Dimension(320,140);
	private final Dimension BUTTONSIZE = new Dimension(140, 60);
	
	public  Window(String name,ScreenType type){
		setupJFrame(name,type);
	}
	private void setupJFrame(String name, ScreenType type) {
		window = new JFrame(name);
		tfEmployeeName = new JTextField(TFSIZE);
		tfAge = new JTextField(TFSIZE);
		tfTitle = new JTextField(TFSIZE);
		tfTotalHours = new JTextField(TFSIZE);
		butCancel = new JButton("Cancel");
		butCreate = new JButton("Create");
		if(type == ScreenType.NEWEMPLOYEE)
			createNewEmployeeScreen();
			
	}
	private void createNewEmployeeScreen() {
		window.setPreferredSize(EMPLOYEESCREEN);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = window.getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel jpReqPanel = this.setupRequiredGUIForNewEmployeeScreen();
		c.add(jpReqPanel);
		
		JPanel jpOptPanel = this.setupOptionalGUIForNewEmployeeScreen();
		c.add(jpOptPanel);
		
		JPanel jpButPanel = this.setupButtonGUIForNewEmployeeScreen();
		c.add(jpButPanel);
		
		window.requestFocusInWindow();
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	
	private JPanel setupRequiredGUIForNewEmployeeScreen(){
		JPanel jpReqPanel = new JPanel();
		jpReqPanel.setPreferredSize(JPANELOVERALLSIZE);
		JLabel jlRequired = new JLabel("<HTML><U>Required:</U></HTML>");
		jlRequired.setFont(BOLDFONT);
		jpReqPanel.add(jlRequired,BorderLayout.NORTH);
		
		JPanel jpReqInnerPanel = new JPanel();
		jpReqInnerPanel.setLayout(new FlowLayout());
		jpReqInnerPanel.setPreferredSize(JPANELINNERSIZE);
		JLabel jlEmployeeName = new JLabel("Employee's name:");
		jlEmployeeName.setFont(TEXTFONT);
		jpReqInnerPanel.add(jlEmployeeName);
		jpReqInnerPanel.add(tfEmployeeName);
		
		JLabel jlAge = new JLabel("Employee's age:");
		jlAge.setFont(TEXTFONT);
		jpReqInnerPanel.add(jlAge);
		jpReqInnerPanel.add(tfAge);
		jpReqPanel.add(jpReqInnerPanel,BorderLayout.SOUTH);
		return jpReqPanel;
	}
	
	private JPanel setupOptionalGUIForNewEmployeeScreen(){
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
	private JPanel setupButtonGUIForNewEmployeeScreen() {
		JPanel jpButPanel = new JPanel();
		jpButPanel.setPreferredSize(JPANELOVERALLSIZE);
		
		butCancel.setPreferredSize(BUTTONSIZE);
		jpButPanel.add(butCancel, BorderLayout.WEST);
		
		butCreate.setPreferredSize(BUTTONSIZE);
		jpButPanel.add(butCreate, BorderLayout.EAST);
		return jpButPanel;
		
	}
	public static void main(String[] args){
		new NewEmployeeScreen("Add new Employee",ScreenType.NEWEMPLOYEE);
	}
}