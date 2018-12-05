package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import observer.Observable;
import observer.Observer;

public class AlexStack implements Stack, Observable {

	static final int STACKSIZE = 100;
	private int topOfStack;
	private int counter;
	private LinkedList<Object> stackList;
	private ArrayList<Observer> observerList;
	
	

	AlexStack() {
		topOfStack = -1;
		counter = 0;
		observerList = new ArrayList<Observer>();
		stackList = new LinkedList<Object>();
	}
	
	@Override
	public void Push(Object x) {
		// TODO Auto-generated method stub
		counter++;
		if (topOfStack < (STACKSIZE - 1)) {
			stackList.add(x);
			topOfStack++;
			// notify observers about the change
			notifyObservers();
		
		} else {
			System.out.println("Stack Overflow!");
		}

	}


	@Override
	public Object Pop() {
		counter--;
		if (topOfStack >= 0) {
			Object topValue = stackList.get(topOfStack);
			stackList.remove(topOfStack);
			topOfStack--;
			// notify observers about the change
			notifyObservers();
			return topValue;

		} else {
			System.out.println("Stack Underflow!");
			return null;
		}
	}
	

	@Override
	public Object Top() {
		// TODO Auto-generated method stub
		return stackList.get(topOfStack);
	}

	@Override
	public int Length() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public void addObserver(Observer targetObserver) {
		// TODO Auto-generated method stub
		observerList.add(targetObserver);
		
	}

	@Override
	public void removeObserver(Observer targetObserver) {
		// TODO Auto-generated method stub
		observerList.remove(observerList.indexOf(targetObserver));
		System.out.println("Observer" + observerList.indexOf(targetObserver) + " deleted.");

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		// notify all observers about the change in stack
		
		System.out.println("<<The stack has been changed!>> \n");
		for (Observer o: observerList) {
			o.update(getState());
		}
	}
	
	public void printStack() {
		System.out.println("bottom of stack " + Arrays.toString(stackList.toArray()) + " top of stack");
	}
	
	// return current state of the stack
	private String getState() {
		return Arrays.toString(stackList.toArray());
	}

}
