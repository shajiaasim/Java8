package model;

import java.util.Comparator;

public class Person implements Comparator {

	private int age;
	private String firstName;
	private String lastName;
	public Person(int age, String firstName, String lastName) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
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
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		Person p = (Person) o1;
		Person p2 = (Person) o1;
		
	return p.getFirstName().compareTo(p2.getLastName());
	}
	
}
