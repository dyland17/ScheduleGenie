package dewalddylan.data.exceptions;

import javax.swing.JOptionPane;

public class TimeException extends Exception{
	public TimeException(int hour, int minute){
		JOptionPane.showMessageDialog(null, "The hour: " + hour + " or the minute: " + minute + " you entered is not possible. Try again.");
	}
	public TimeException(int hour, int minute, String note){
		JOptionPane.showMessageDialog(null, note+ ":\n" + "The hour: " + hour + " or the minute: " + minute + " you entered is not possible. Try again.");
	}
}
