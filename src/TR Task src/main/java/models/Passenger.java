package models;

public class Passenger {
	String name, gender;
	String age;
	public Passenger(String name, String gender, String agev) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = agev;
	}
	
	public String toString() {
		return name + " -- " + gender  + " -- " + age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}