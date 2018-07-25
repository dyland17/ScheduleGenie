package main.dewalddylan.schedulegenie.data;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;

public class Employee {
	private BasicInfo employeeInfo;
	private ExtraInfo employeeExtraInfo;
	private SelectionItem employeeItem;
	private DayTracker dayTracker;
	
	public Employee(String firstName,String lastName, int age){
		employeeInfo = new BasicInfo(firstName,lastName,age);
		boolean isMinor = false;
		if(age < 18)
			isMinor = true;
		employeeExtraInfo = new ExtraInfo("Not given", 0, isMinor);
		employeeItem = new SelectionItem(employeeInfo.fullName());
		dayTracker = new DayTracker();
	}
	
	public Employee(BasicInfo basicInfo, ExtraInfo extraInfo, int yPos){
		employeeInfo = basicInfo;
		employeeExtraInfo = extraInfo;
	//	employeeItem = new SelectionItem(employeeInfo.fullName(), yPos);
		dayTracker = new DayTracker();
	}
	public String firstName() {
		return employeeInfo.firstName();
	}
	

	public String lastName() {
		return employeeInfo.lastName();
	}
	
	public String fullName(){
		return employeeInfo.fullName();
	}
	public int age() {
		return employeeInfo.age();
	}

	public String title() {
		return employeeExtraInfo.title();
	}

	public void setTitle(String title) {
		employeeExtraInfo = employeeExtraInfo.newInstance(title, employeeExtraInfo.totalHours(),
																						employeeExtraInfo.isMinor());
	}

	public int getTotalHours() {
		return employeeExtraInfo.totalHours();
	}

	public void setTotalHours(int totalHours) {
		employeeExtraInfo = employeeExtraInfo.newInstance(employeeExtraInfo.title(), totalHours,
																						employeeExtraInfo.isMinor());
	}

	public boolean isMinor() {
		return employeeExtraInfo.isMinor();
	}

	public Employee clone(){
		BasicInfo basicInfo = new BasicInfo(employeeInfo.firstName(),employeeInfo.lastName(),
																employeeInfo.age());
		ExtraInfo extraInfo = new ExtraInfo(employeeExtraInfo.title(),employeeExtraInfo.totalHours(),
																employeeExtraInfo.isMinor());
		return new Employee(basicInfo,extraInfo,employeeItem.yPos()) ;
	}
	public void setLocation(Position position){
		employeeItem.setLocation(position);
	}
	public void paint(Graphics2D g2d){
		employeeItem.paint(g2d);
	}

	public Time getStartTime(WorkDay day) {
		return dayTracker.getTimeSheetByDay(day).getStartTime();
	}
	
	public Time getEndTime(WorkDay day) {
		return dayTracker.getTimeSheetByDay(day).getEndTime();
	}

	public Rectangle getBounds() {
		return employeeItem.getBounds();
	}
	public void setSelected(boolean selected){
		employeeItem.setSelected(selected);
	}
}
