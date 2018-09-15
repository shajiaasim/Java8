package basics.certification;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import model.Person;


//Some common use cases
public class TestLambdaExpressions {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// old school threads using anon class
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("running");

			}
		});
		thread.run();

		// Type Inferencing
		// Runnable Interface has only one abstract method, good candidate for
		// implementing lambda expressions.
		// Backward compatibility

		// Lambda way
		Runnable run = () -> System.out.println("Lambda Thread");

		Thread thread2 = new Thread(run);

		try {
			thread2.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.run();

		// Runnable run = ()-> System.out.println("run");

		// in line
		Thread thread3 = new Thread(() -> System.out.println("Lambda Thread with inline implementation"));
		thread3.run();

		Service service = new Service();

		List<Person> peopleList = Arrays.asList(
				new Person(29, "Aasim", "Shaji"), new Person(39, "Charles",
						"Dickens"), new Person(49, "Thomas", "Carlyle"),
				new Person(29, "Charlotte", "Bronte"), new Person(29,
						"Matthew", "Arnold"));

		System.out.println("Sort list using Anon inner classes...");

		// Anon inner classes
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				// TODO Auto-generated method stub
				return p1.getLastName().compareTo(p2.getLastName());
			}
		};

		// Anonymous way
		SortListInterface sortListInterfaceAnon = new SortListInterface() {

			@Override
			public void sortList(List<Person> people) {
				// TODO Auto-generated method stub
				people.sort(comparator);
			}
		};

		sortListInterfaceAnon.sortList(peopleList);

		// Lambda way

		System.out.println("Sort list by last name using lambda...");
		SortListInterface sortListInterface = (people) -> people
				.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		sortListInterface.sortList(peopleList);

		System.out.println(peopleList);
		
		
		System.out.println("Print all names using lambda...");
		PrintPeoplesNamesInterface printPeoplesNamesInterface = (peopleListF) -> {
			for (Person person : peopleListF) {
				System.out.println(person.toString());
			}
		};

		printPeoplesNamesInterface.printNames(peopleList);

		// Complex logic with lambdas

		System.out.println("Sort list using lambda and conditions...");
		service.sendPromotion(peopleList, (person) -> person.getFirstName()
				.startsWith("C"));

		// Out of the box interfaces to address common scenarios
		// Predicate way
		// Predicate<T> - returns a boolean value based on input of type T
		
		System.out.println("Sort list using lambda and predicate interface...");
		service.sendPromotionWithPredicate(peopleList,
				person -> person.getAge() > 30);

		// Send to all

		System.out.println("send to all...");
		service.sendPromotionWithPredicate(peopleList, person -> true);
		

		// Predicate + Consumer way
		// Consumer<T> - performs an action with given object of type T. returns
		// void

		System.out
				.println("Sort list using lambda and predicate and consumer interface...");
		service.sendPromotionWithPredicate(peopleList,
				person -> person.getAge() > 30,
				(person) -> System.out.println(person.getLastName()));

		// Call methods from lambda
		System.out.println("call other methods from lambda...");
		service.sendPromotionWithPredicate(peopleList,
				person -> person.getAge() > 30, (person) -> printName(person));
		System.out.println(peopleList);

		// Method referencing
		/*
		 * Can point to: Static methods. Instance methods. Methods on particular
		 * instances. Constructors *
		 */

		System.out.println("method referencing...");
		service.sendPromotionWithPredicate(peopleList,
				person -> person.getAge() > 30,
				TestLambdaExpressions::printName);

		// Method referencing another way
		System.out.println("method referencing another way...");
		service.sendPromotionWithPredicate(peopleList,
				person -> person.getAge() > 30, System.out::println);

	}

	static void printName(Person p) {
		System.out.println(p.getLastName());
	}

}

interface SortListInterface {
	void sortList(List<Person> people);
}

interface PrintPeoplesNamesInterface {
	void printNames(List<Person> people);
}

interface Condition {
	boolean test(Person p);
}

interface PrintPeoplesNamesWithCInterface {
	void printNames(List<Person> people);
}

class Service {

	// Condition
	void sendPromotion(List<Person> personList, Condition condition) {
		for (Person person : personList) {
			if (condition.test(person)) {
				System.out.println("Sending promotion to "
						+ person.getFirstName());
			}
		}

	}

	// Predicates
	void sendPromotionWithPredicate(List<Person> personList,
			Predicate<Person> predicate) {
		for (Person person : personList) {
			if (predicate.test(person)) {
				System.out.println("Sending promotion to "
						+ person.getFirstName());
			}
		}

	}

	// Predicate and consumer
	void sendPromotionWithPredicate(List<Person> personList,
			Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : personList) {
			if (predicate.test(person)) {
				// System.out.println("Sending promotion to "+
				// person.getFirstName());
				consumer.accept(person);
			}
		}

	}
}
