package main.dewalddylan.schedulegenie.data;

public class BasicInfo {
	private String firstName;
	private String lastName;
	private int age;
	public BasicInfo(String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String firstName(){
		return firstName;
	}
	
	public String lastName(){
		return lastName;
	}
	
	public int age(){
		return age;
	}
	public String fullName(){
		return firstName + " " + lastName;
	}
	public BasicInfo newInstance(String firstName, String lastName, int age){
		return new BasicInfo(firstName,lastName,age);
	}
}
