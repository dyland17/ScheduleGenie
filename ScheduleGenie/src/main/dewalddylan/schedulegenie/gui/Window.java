package main.dewalddylan.schedulegenie.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

public abstract class Window{
	public static final Dimension EMPLOYEEBUTTONSIZE = new Dimension(140, 60);
	public static final Dimension SCHEDULEBUTTONSIZE = new Dimension(100, 40);
	public static final Dimension EMPLOYEESCREEN = new Dimension(420,400);
	public static final Dimension EMPLOYEETIMESHEETSCREEN = new Dimension(460,400);
	public static final Dimension SCHEDULESCREEN = new Dimension(720,660);
	public static final String MAINSCREEN = "Schedule Screen";
	public static final String EDITEMPLOYEESCREEN = "Edit employee screen." ;
	public static final String NEWEMPLOYEESCREEN = "New employee screen.";
	public static final String SCHEDULEEMPLOYEESCREEN = "Schedule employee screen.";
	protected JFrame window;
	public Window(Dimension dim, String name){
		window = new JFrame(name);
		window.setPreferredSize(dim);
		window.setResizable(false);
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
