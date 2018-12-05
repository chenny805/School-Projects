package observer;

public class StackObserver2 implements Observer{

	private Observable stackState;
	
	@Override
	public void update(String stackState) {
		// TODO Auto-generated method stub
		String state = stackState;
		System.out.println("StackObserver2: Current state of stack is\n						" + state + "\n");
		
	}
	
	public StackObserver2(Observable stackObj) {
		stackState = stackObj;
		// add this observer to subject's observer list
		stackState.addObserver(this);
		System.out.println("StackObserver 2 is added");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "StackObserver2";
	}
	
}
