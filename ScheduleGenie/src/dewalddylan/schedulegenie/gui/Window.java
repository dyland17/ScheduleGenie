package dewalddylan.schedulegenie.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dewalddylan.data.enumerations.ScreenType;

public class Window {
	private JFrame window;
	private JTextField tfEmployeeName;
	private JTextField tfAge;
	private final int  TFSIZE = 10;
	private final Font TEXTFONT = new Font(Font.SANS_SERIF,Font.PLAIN,18);
	private final Dimension EMPLOYEESCREEN = new Dimension(480,520);
	public static final String NEWEMPLOYEE = "NEWEMPLOYEE"; 
	
	public Window(String name,ScreenType type){
		setupJFrame(name,type);
	}
	private void setupJFrame(String name, ScreenType type) {
		window = new JFrame(name);
		tfEmployeeName = new JTextField(TFSIZE);
		tfAge = new JTextField(TFSIZE);
		if(type == ScreenType.NEWEMPLOYEE)
			createNewEmployeeScreen();
			
	}
	private void createNewEmployeeScreen() {
		window.setPreferredSize(EMPLOYEESCREEN);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = window.getContentPane();
		c.setLayout(new FlowLayout());
		JLabel jlRequired = new JLabel("Required:");
		jlRequired.setFont(TEXTFONT);
		c.add(jlRequired);
		JLabel jlEmployeeName = new JLabel("Employee's name:");
		jlEmployeeName.setFont(TEXTFONT);
		c.add(jlEmployeeName);
		c.add(tfEmployeeName);
		JLabel jlAge = new JLabel("Employee's age:");
		jlAge.setFont(TEXTFONT);
		c.add(jlAge);
		c.add(tfAge);
		
		window.requestFocusInWindow();
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	public static void main(String[] args){
		new Window("Add new Employee",ScreenType.NEWEMPLOYEE);
	}
}
