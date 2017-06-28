package dewalddylan.schedulegenie.data.exceptions;

import javax.swing.JOptionPane;

public class TimeException extends Exception{
	private int hour, minute;
	private String note = "";
	public static final String EHOUR = "The hour you have entered is wrong";
	public static final String EMINUTE = "The minute you have entered is wrong";
	public TimeException(int hour, int minute){
		this.hour = hour;
		this.minute = minute;
	}
	public TimeException(int hour, int minute, String note){
		this(hour,minute);
		this.note = note;
	}
	public void showMessage(){
		if(note.equals("")){
			JOptionPane.showMessageDialog(null, "The hour: " + hour + " or the minute: " + minute + " you entered is not possible.");
		}
		else{
			JOptionPane.showMessageDialog(null, note + ":\n" + "The hour is: " + hour + "\n The minute is: " + minute);
		}
	}
}
