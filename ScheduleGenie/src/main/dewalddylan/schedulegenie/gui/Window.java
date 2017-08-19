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
import main.dewalddylan.schedulegenie.data.SGTextField;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;

public abstract class Window{
	public static final Dimension EMPLOYEEBUTTONSIZE = new Dimension(140, 60);
	public static final Dimension SCHEDULEBUTTONSIZE = new Dimension(100, 40);
	public static final Dimension EMPLOYEESCREEN = new Dimension(420,400);
	public static final Dimension SCHEDULESCREEN = new Dimension(720,640);
	public static final String MAINSCREEN = "Schedule Screen";
	public static final String EDITSCREEN = "Edit employee screen." ;
	public static final String NEWSCREEN = "New employee screen.";
	protected JFrame window;
	public Window(Dimension dim, String name){
		window = new JFrame(name);
		window.setPreferredSize(dim);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected void finishPackingScreen() {
		window.requestFocusInWindow();
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public static void main(String[] args){
		//new NewEmployeeScreen();
		//new EditEmployeeScreen(new Employee("Danny" , "Phantom",21));
		new ScheduleScreen();
	}

}
