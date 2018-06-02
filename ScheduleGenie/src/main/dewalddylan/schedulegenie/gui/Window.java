package main.dewalddylan.schedulegenie.gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

public abstract class Window implements WindowListener, ActionListener{
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

	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowClosing(WindowEvent arg0) {	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}

}
