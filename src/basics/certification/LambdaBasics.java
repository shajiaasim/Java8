package basics.certification;

public class LambdaBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		LambdaBasics lambdaBasics = new LambdaBasics();
		
		
		
		//Hello World lambda
		DoSomethingInterface sayHello = ()->System.out.println("hello");
		
		sayHello.printHello();
	//	DoSomethingInterface sayHello = () -> System.out.println("hello");
		
		
		
		//Lambda with parameters
//		Create interface with one method as the same signature as the lambda expression
//		Cannot add any other methods- because functional interface
//		Execute lambda function by executing interface method on it

		
		 //Lambda with single argument 
	     System.out.println("Lambda single argument...");
	     StringLengthInterface stringLengthInterface = (String s) ->{return s.length();}; 
	     System.out.println(stringLengthInterface.getLength("Hello"));
	     
	   //Lambda with single argument no parenthesis (Shortest way)
	     System.out.println("Lambda single argument shortest way...");
	     StringLengthInterface stringLengthInterface2 = s -> s.length(); 
	     System.out.println(stringLengthInterface2.getLength("Hello world"));
		
	     //Lambda with multiple params
	     System.out.println("Lambda without return keyword...");
	     
	     //Needs parenthesis around as there are two params
	     AddTwoNumInterface addNum2 = (x,y) -> x+y;	
	     System.out.println(addNum2.addTwoNum(3, 5));
	     
	     //Lambda invoked through service class
	      lambdaBasics.invokeInterfaceImplementation(sayHello);
	     
	    //Lambda invoked through service class inline implementation
	      lambdaBasics.invokeInterfaceImplementation(()-> System.out.println("hello again"));
		     
		
	}
	
	
	public void invokeInterfaceImplementation(DoSomethingInterface doSomethingInterface){
		doSomethingInterface.printHello();
	}
     
	
	
	//Hello world method
	public void doSomething(){
		
		System.out.println("hello");
		
	}
	
	public int addNum(int x, int y){
			
			return x+y;
			
		}

}


//@FunctionalInterface

interface DoSomethingInterface{
	void printHello();
	default void doSomethingElse(){
		System.out.println("hi");
	}
}

class A implements DoSomethingInterface{

	@Override
	public void printHello() {
		// TODO Auto-generated method stub
		doSomethingElse();
	}
	
	@Override
	public void doSomethingElse() {
		// TODO Auto-generated method stub
		DoSomethingInterface.super.doSomethingElse();
		System.out.println("Custom implementation");
	}
	
}

interface AddTwoNumInterface{
	int addTwoNum(int a,int b);
}

interface StringLengthInterface{
	int getLength(String s);
	
}
