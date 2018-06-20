package main.dewalddylan.schedulegenie.gui;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import main.dewalddylan.schedulegenie.data.enumerations.ScreenType;

public abstract class Screen implements ActionListener, WindowListener{
	//All GUI components
	protected JFrame window;
	protected static final Font BOLDFONT = new Font(Font.SANS_SERIF,Font.BOLD,18);
	protected static final Font TEXTFONT = new Font(Font.SANS_SERIF,Font.PLAIN,18);
	
	public Screen(String screenName, ScreenType type){
		initializeWindow(screenName,type);
	}
	
	private void initializeWindow(String screenName,ScreenType type){
			window = new JFrame(screenName);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setPreferredSize(type.myDim());
			window.addWindowListener(this);
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
			new MainScreen();
		}
}
