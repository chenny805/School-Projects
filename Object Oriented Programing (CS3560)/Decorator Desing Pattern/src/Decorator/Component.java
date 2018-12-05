package Decorator;

public abstract class Component {

	  public void printTicket() {
		    // Hard coded here, but simpler than 
		    // adding a new Customer class now
		    System.out.println("Customer: Bob");
		    System.out.println("The sales ticket itself");
		    System.out.println("Total: $123.45");
		  }

}
