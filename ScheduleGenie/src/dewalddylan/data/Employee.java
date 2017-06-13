package dewalddylan.data;

public class Employee {
	//Most important information
	private String name;
	private int age;
	//Extra info
	private String title;
	private int totalHours;
	private boolean minor;
	//private DayTracker dayTracker;
	
	public Employee(String name, int age){
		this.name = name;
		this.age = age;
		this.minor = false;
		if(age < 18)
			this.minor = true;
		totalHours = 0;
		title = "No title given.";
		//dayTracker = new DayTracker();
	}
	public Employee(String name, int age, int totalHours, String title){
		this(name,age);
		this.totalHours = totalHours;
		this.title = title;
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public void setMinor(boolean minor) {
		this.minor = minor;
	}
	/*public DayTracker getDayTracker(){
		return this.getDayTracker;
	}*/
}
