package alex.com.practice;

public class AlexLinkedList {
	private static int counter;
	private Node head;
	
	// constructor 
	public AlexLinkedList() {
	}
	
	// to add nodes to end of list
	public void add(Object data) {
		incrementCounter();
		// if the list is empty
		if (head == null) {
			head = new Node(data);
		}
		Node tempNode = new Node(data);
		Node currNode = head;
		
		// if the list is not empty
		if (currNode != null) {
			// find the last node in the list
			while (currNode.getNextNode() != null) {
				currNode = currNode.getNextNode(); // iterate through list
			}
			currNode.setNextNode(tempNode);
		}
	} // end add()
	
	// get the object at given index
	public Object get(int index) {
		// invalid index
		if (index < 0) {
			return null;
		}
		Node currNode = null;
		if (head != null) {		// make sure the list is not empty
			currNode = head.getNextNode();
			// iterate to the given index
			for (int i = 0; i < index; i++) {
				// if the index is out of bound
				if (currNode.getNextNode() == null)
					return null;
				currNode = currNode.getNextNode();
			}
			return currNode.getData();
		}
		return currNode;
	} // end get()
	
	// remove the node at given index
	public boolean remove(int index) {
		Node currNode = head;
		// invalid index
		if (index < 0 || index > size()) 
			return false;
		
		if (index == 0) {
			head = head.getNextNode();
		}
		
		if(head != null) { 		// make sure the list is not empty
			// iterate to the given index
			for (int i = 0; i < index; i++) {
				// if index is not in bound
				if (currNode.getNextNode() == null) 
					return false;
				currNode = currNode.getNextNode();
			}
			// to delete node
			currNode.setNextNode(currNode.getNextNode().getNextNode());
			decrementCounter();
			return true;
		}
		return false;
	} // end remove()
	
	private static int getCounter() {
		return counter;
	}
	
	private static void incrementCounter() {
		counter++;
	}
	
	private static void decrementCounter() {
		counter--;
	}
	
	public int size() {
		return getCounter();
	}
	
	public String toString() {
		String output = "";
		if (head != null) {
			Node currNode = head.getNextNode();
			while(currNode != null) {
				output += "[" + currNode.getData().toString() + "]";
				currNode = currNode.getNextNode();
			}
		}
		return output;
	}
	
} // end class
