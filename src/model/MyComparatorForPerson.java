package model;

import java.util.Comparator;

public class MyComparatorForPerson implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
//		Object o3 = new Person();
//		Person p3 = (Person) o3;
	
	return p1.getLastName().compareTo(p2.getLastName());
	}

}
