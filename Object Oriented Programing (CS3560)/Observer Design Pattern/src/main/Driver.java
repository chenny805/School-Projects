package main;
import observer.StackObserver1;
import observer.StackObserver2;


public class Driver {
	public static void main (String[] args) {
		AlexStack stack = new AlexStack();
		
		StackObserver1 so1 = new StackObserver1(stack);
		StackObserver2 so2 = new StackObserver2(stack);
		System.out.println("----------------------------------------------------------------------\n");
		

		stack.Push(12);
		stack.Push(4);
		stack.Push(5039);
		stack.Push("Seven");
		stack.Pop();
		stack.Pop();
		
	}
}
