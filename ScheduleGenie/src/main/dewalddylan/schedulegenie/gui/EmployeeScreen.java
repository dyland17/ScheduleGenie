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
	protected JFrame window;
	protected static final Font BOLDFONT = new Font(Font.SANS_SERIF,Font.BOLD,18);
	protected static final Font TEXTFONT = new Font(Font.SANS_SERIF,Font.PLAIN,18);
	
	public EmployeeScreen(String screenName, ScreenType type){
		window.addWindowListener(this);
		initializeWindow(screenName,type);
	}
	
	private void initializeWindow(String screenName,ScreenType type){
			window = new JFrame(screenName);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setPreferredSize(type.myDim());
		}
		protected abstract void styleEmployeeScreen();
		
		protected void finishPackingScreen() {
			window.requestFocusInWindow();
			window.pack();
			window.setLocationRelativeTo(null);
			window.setVisible(true);
		}
		

		@Override
		public void windowOpened(WindowEvent e) {		
		}
		@Override
		public void windowClosing(WindowEvent e) {
		}
		@Override
		public void windowClosed(WindowEvent e) {
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
		
		public static void main(String[] args){
			//new NewEmployeeScreen();
			//new EditEmployeeScreen(new Employee("Danny" , "Phantom",21));
			new ScheduleScreen();
		}
}
