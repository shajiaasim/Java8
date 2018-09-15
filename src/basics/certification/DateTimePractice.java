package basics.certification;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.function.Predicate;

public class DateTimePractice {

	
	public static void main (String [] args) {
		
		//Default format yyyy-mm-dd
		LocalDate l = LocalDate.now();
		
		//Another way
		
		LocalDate l2 = LocalDate.of(1988, 12, 06);
		
		
		System.out.println(l);
		Period p = Period.ofDays(1);
		;
		System.out.println(l.plus(p));
		
		System.out.println(l2.plus(p));
		
		
		ArrayList <Integer> list = new ArrayList<>();
		list.add(11);list.add(23);
		list.add(8);list.add(39);
		
		
		
		list.removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				
				return t%2!=0;
			}
			
		});
		
		System.out.println(list);
		
		
	}
	
}
