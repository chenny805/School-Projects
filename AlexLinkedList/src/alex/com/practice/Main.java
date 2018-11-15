package alex.com.practice;

public class Main {
	public static AlexLinkedList myList;
	
	public static void main(String[] args) {
		myList = new AlexLinkedList();
		myList.add("Alex");
		myList.add("John");
		myList.add("Ryan");
		myList.add("Cooper");
		myList.add("Ali");
		
		System.out.println(myList);
		myList.remove(0);
		System.out.println(myList);
		myList.remove(0);
		System.out.println(myList);
		myList.remove(2);
		System.out.println(myList);
	}

}
