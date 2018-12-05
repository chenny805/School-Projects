package Decorator;

public class TicketDecorator extends Component{
	
	  private Component component;

	  public TicketDecorator(Component c) {
	    component = c;
	  }

	  public void printTicket() {
	    if(component != null)
	      component.printTicket();
	  }


}
