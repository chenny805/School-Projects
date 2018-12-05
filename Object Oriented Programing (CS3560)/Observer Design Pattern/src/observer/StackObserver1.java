package observer;

public class StackObserver1 implements Observer{

	private Observable stackState;
	
	@Override
	public void update(String stackState) {
		// TODO Auto-generated method stub
		System.out.println("StackObserver1: Changed!");
		
	}
	
	public StackObserver1(Observable stackObj) {
		stackState = stackObj;
		// add this observer to subject's observer list
		stackState.addObserver(this);
		System.out.println("StackObserver 1 is added");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "StackObserver1";
	}
	
}
