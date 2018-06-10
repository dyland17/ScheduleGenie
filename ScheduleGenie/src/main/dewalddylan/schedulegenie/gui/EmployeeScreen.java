package main.dewalddylan.schedulegenie.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.dewalddylan.schedulegenie.data.GUIDim;
import main.dewalddylan.schedulegenie.data.SGTextField;
import main.dewalddylan.schedulegenie.data.TimeSheetPanel;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;
import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;
import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

//vvvvvvvvv need to split this class into smaller bits because it is to big vvvvvvvvvvvvv
public abstract class EmployeeScreen implements ActionListener, WindowListener{
	//All GUI components
	protected JButton butCancel;
	protected JButton butUpdate;
	protected JFrame window;
	//public static final sizes or consistent styles.
	protected static final Font BOLDFONT = new Font(Font.SANS_SERIF,Font.BOLD,18);
	protected static final Font TEXTFONT = new Font(Font.SANS_SERIF,Font.PLAIN,18);
	
	public EmployeeScreen(String screenName, ScreenType type){
		window.addWindowListener(this);
		initializeButtons(type);
		initializeWindow(screenName,type);
	}
	
	private void initializeButtons(ScreenType type){
		//Buttons getting initialized.
		butCancel = new JButton("Cancel");
		butCancel.addActionListener(this);
		if(type == ScreenType.NEWEMPLOYEE)
			butUpdate = new JButton("Create");
		else
			butUpdate = new JButton("Update");
	}
	
	private void initializeWindow(String screenName,ScreenType type){
		window = new JFrame(screenName);
		window.setResizable(false);
		if(type == ScreenType.SCHEDULESCREEN){
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setPreferredSize(GUIDim.SCHEDULESCREENDIM);
		}
		else{
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setPreferredSize(GUIDim.EMPLOYEESCREENDIM);
		}
	}
	protected JPanel setupButtonGUIForEmployeeScreen() {
		JPanel jpButPanel = new JPanel();
		jpButPanel.setPreferredSize(GUIDim.JPANELOVERALLDIM);
		
		butCancel.setPreferredSize(GUIDim.EMPLOYEEBUTTONDIM);
		jpButPanel.add(butCancel, BorderLayout.WEST);
		
		butUpdate.setPreferredSize(GUIDim.EMPLOYEEBUTTONDIM);
		jpButPanel.add(butUpdate, BorderLayout.EAST);
		return jpButPanel;
	}
	
		protected abstract void styleJFrame();

		protected void finishPackingScreen() {
			window.requestFocusInWindow();
			window.pack();
			window.setLocationRelativeTo(null);
			window.setVisible(true);
		}
		

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public static void main(String[] args){
			//new NewEmployeeScreen();
			//new EditEmployeeScreen(new Employee("Danny" , "Phantom",21));
			new ScheduleScreen();
		}
}
