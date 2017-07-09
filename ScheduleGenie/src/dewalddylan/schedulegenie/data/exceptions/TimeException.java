package dewalddylan.schedulegenie.data.exceptions;

import javax.swing.JOptionPane;

public class TimeException extends Exception{
	private int hour, minute;
	private String errorNote = "";
	public static final String EHOUR = "The hour you have entered is wrong";
	public static final String EMINUTE = "The minute you have entered is wrong";
	private final String STRINGATTACHMENT;
	public TimeException(int hour, int minute, String note){
		super(note);
		STRINGATTACHMENT = ":\n" + "The hour is: " + hour + "\n The minute is: " + minute;
		errorNote = note;
	}
	public void showMessage(){
			JOptionPane.showMessageDialog(null, getFinalNote());
	}
	public String getErrorNote(){
		return errorNote;
	}
	public String getFinalNote(){
		return errorNote + STRINGATTACHMENT;
	}
	
}
