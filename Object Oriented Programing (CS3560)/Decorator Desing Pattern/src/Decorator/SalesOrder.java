package Decorator;

public class SalesOrder {

	public static void main(String[] args) {
		SalesOrder s = new SalesOrder();
		s.printTicket();
	}

	public void printTicket() {
		// Get an object decorated dynamically
		Component myST = Configuration.getSalesTicket();
		myST.printTicket();
	}

	// calcSalesTax ...
}
