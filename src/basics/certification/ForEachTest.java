package basics.certification;

import java.util.Arrays;
import java.util.List;

import model.Person;

public class ForEachTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Person> peopleList = Arrays.asList(
				new Person(29,"Aasim","Shaji"),
				new Person(39,"Charles","Dickens"),
				new Person(49,"Thomas","Carlyle"),
				new Person(29,"Charlotte","Bronte"),
				new Person(29,"Matthew","Arnold")
				);
		
		//External iterators - we are controlling
		//sequential
		System.out.println("External iterator");
		for (Person p : peopleList){
			System.out.println(p);
		}
		
		//Internal iterators - we are not controlling, runtime will control
		//new method introduced
		//Implement the action for each person object using consumer interface
		//Good for multi threading and parallel processing
		
		System.out.println("Internal iterator");
		//forEach is a default method in the Collections Interface
		peopleList.forEach((person)->System.out.println(person.getFirstName()));
		
		//For each and method referencing
		
		System.out.println("method referencing");
		peopleList.forEach(System.out::println);
		
		
		
		
		
	}

}
