package main.dewalddylan.schedulegenie.data;

import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

public class Employee {
	public static final int TOTALEMPLOYEENUMBERS = 999999;
	//Most important information
	private String firstName;
	private String lastName;
	private int age;
	private int employeeNumber;
	//Extra info
	private String title;
	private int totalHours;
	private boolean minor;
	private DayTracker dayTracker;
	
	public Employee(String firstName,String lastName, int age, int employeeNum){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.employeeNumber = employeeNum;
		this.minor = false;
		if(age < 18)
			this.minor = true;
		totalHours = 0;
		title = "No title given";
		dayTracker = new DayTracker();
	}
	public Employee(String firstName,String lastName, int age, int employeeNum,int totalHours, String title){
		this(firstName,lastName,age,employeeNum);
		this.totalHours = totalHours;
		this.title = title;
		
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		if(age < 18)
			minor = true;
		else
			minor = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public boolean isMinor() {
		return minor;
	}

	public Employee copy(){
		return new Employee(firstName,lastName,age, employeeNumber,totalHours,title) ;
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int newEmployeeNumber){
		employeeNumber = newEmployeeNumber;
	}

	public Time getStartTime(WorkDay day) {
		return dayTracker.getTimeSheetByDay(day).getStartTime();
	}
	
	public Time getEndTime(WorkDay day) {
		return dayTracker.getTimeSheetByDay(day).getEndTime();
	}
}
