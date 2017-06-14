package dewalddylan.data.exceptions;

import javax.swing.JOptionPane;

public class TimeException extends Exception{
	public TimeException(Exception e, int hour, int minute){
		JOptionPane.showMessageDialog(null, "The hour: " + hour + " or the minute: " + minute + " you entered is not possible. Try again.");
	}
}
