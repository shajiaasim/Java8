package basics.certification;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import model.Person;

//With multi core processor we can have portion of a huge collections
//handled by different cores

public class StreamApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Person> peopleList = Arrays.asList(
				new Person(29,"Aasim","Shaji"),
				new Person(39,"Charles","Dickens"),
				new Person(49,"Thomas","Carlyle"),
				new Person(29,"Charlotte","Bronte"),
				new Person(29,"Matthew","Arnold")
				);
		//STREAM API
		//Enables multiple operations on loops
		//Used to create pipeline of operations
		//stream() is a new default method in the Collections Interface
		peopleList.stream()
		
		//Intermediate operations(filter)--lazy, non interfering, stateless
		//Operation pipeLine
		//Can be chained
		//returns stream object
		.filter((person)-> person.getFirstName().startsWith("A"))
		
		//For each Terminal operation
		//Terminal operations causes the stream to act
		.forEach(System.out::println);
		
		
		long count = peopleList.stream()
		.filter((person)-> person.getFirstName().startsWith("A"))
		//Count Terminal operation
		.count();
		
		System.out.println(count);
		
		
		//Parallel processing using multi core
		
		//Map
		
		//Function<T,R> - takes an object of type T and returns R.
		
		Function <Person,String> getFirstName = (person)-> person.getFirstName();
		
		peopleList.stream()
		.filter((person)-> person.getFirstName().startsWith("A"))
		.map(getFirstName)
		.forEach(System.out::println);
		}
	
	//
	String getFirstName(Person p){
		return p.getFirstName();
	}

}
