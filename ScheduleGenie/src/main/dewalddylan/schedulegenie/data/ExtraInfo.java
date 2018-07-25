package main.dewalddylan.schedulegenie.data;

public class ExtraInfo {
	private final String title;
	private final int totalHours;
	private final boolean minor;
	public ExtraInfo(String title, int totalHours, boolean minor){
		this.title = title;
		this.totalHours = totalHours;
		this.minor = minor;
	}
	
	public String title(){
		return title;
	}
	
	public int totalHours(){
		return totalHours;
	}
	
	public boolean isMinor(){
		return minor;
	}
	
	public ExtraInfo newInstance(String title, int totalHours, boolean minor){
		return new ExtraInfo(title,totalHours,minor);
	}
}
