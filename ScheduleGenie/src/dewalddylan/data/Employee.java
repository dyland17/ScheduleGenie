package dewalddylan.data;

public class Employee {
	//Most important information
	private String firstName;
	private String lastName;
	private int age;
	//Extra info
	private String title;
	private int totalHours;
	private boolean minor;
	private DayTracker dayTracker;
	
	public Employee(String firstName,String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.minor = false;
		if(age < 18)
			this.minor = true;
		totalHours = 0;
		title = "No title given.";
		dayTracker = new DayTracker();
	}
	public Employee(String firstName,String lastName, int age, int totalHours, String title){
		this(firstName,lastName,age);
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
		return new Employee(firstName,lastName,age,totalHours,title) ;
	}
	/*public DayTracker getDayTracker(){
		return this.getDayTracker;
	}*/
}
