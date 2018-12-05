package Decorator;

//This object will determine how to decorate the
//SalesTicket. This could become a Factory
public class Configuration {

	  public static Component getSalesTicket() {
	    // Return a decorated SalesTicket
	    return
	       new HeaderDecorator1(
	           new HeaderDecorator2(
	              new FooterDecorator1(
	                  new FooterDecorator2(
	                      new SalesTicket() ))));
	  }
	}
