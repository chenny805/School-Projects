package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Support {
	List<Character> list = new ArrayList<>();
	char[] array = new char[9];
	String s = "012345678";
	char [] sArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	int indexZero;

	// return the number of misplaced tiles
	public int numMisplaced(String s) {
		int h = 0;
		char[] charArray = toArray(s);
		//array = s.toArray(state);
		for(int i = 0; i < 9; i++) {
			if (charArray[i] !='0' && charArray[i] != sArray[i]) {
				h++;
			}
		}
		return h;
	} // end method
	
	// convert from string to character array
	public char[] toArray(String state) {
		for (int i = 0; i < state.length(); i++) {
			array[i] = state.charAt(i);
		}
		return array;
	} // end method
	
	public String newPuzzle() {
		boolean solvable;
		list.clear(); // clear the list
		array = toArray(s); // convert it to an array
		// add the state to list
		for (int i = 0; i < 9; i++) {
			list.add(array[i]);
		}
		Collections.shuffle(list); // shuffle list
		// reconstruct the state as a string

		StringBuilder result = new StringBuilder(9);
		for (Character c : list) {
			result.append(c);
		}
		String shuffled = result.toString();
		solvable = checkSolvable(shuffled); // check if list is solvable

		if (solvable == true) {
			System.out.println("index of blank tile: " + indexZero);
			return shuffled;
		} else {
			return newPuzzle();
		}

	} // end method

	// check if the new puzzle is solvable: support method when for newPuzzle()
	// method
	public boolean checkSolvable(String state) {
		array = toArray(state);
		int numInvert = 0;
		for (int i = 0; i < 9 - 1; i++) {
			if (array[i] != '0') {
				for (int j = i + 1; j < 9; j++) {
					if (array[j] != '0') {
						if (array[i] > array[j]) {
							numInvert++;
						}
					}
				}
			} else
				indexZero = i; // record the index of the blank tile/zero
		}
		System.out.println("number of invertibles: " + numInvert);
		// if the number is even then it is invertible
		if (numInvert % 2 == 1) {
			return false;
		} else
			return true;
	} // end method
	

	public void printState(String s) {
		char[] state = toArray(s);
		for (int i = 0; i < state.length; i++) {
			if (i%3 == 0)
				System.out.print("\n"+"|");
			System.out.printf(" " + state[i]+ " |" );
		}
		System.out.println();
	}

} // end class
