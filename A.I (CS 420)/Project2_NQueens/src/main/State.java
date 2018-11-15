// Author: Alex (Wei) Chen Course: CS 420 
package main;

import java.util.Random;

public class State implements Comparable<State> {

	private int fitness;
	private int[] board = { 0, 1, 2, 3, 4, 5, 6, 7 };
	private static Random rand = new Random();

	public State() {
		this.board = shuffle(this.board);
		fitness = setFitness();
	}

	public State(int[] childBoard) {
		board = childBoard;
		fitness = setFitness();
	}

	public int getFitness() {
		return fitness;
	}

	public int[] getBoard() {
		return board;
	}

	public void setBoard(int[] board) {
		this.board = board;
		fitness = setFitness();
	}

	// calculate the fitness of the given board
	public int setFitness() {
		fitness = 0;
		int temp;
		int b;
		// traverse string
		for (int i = 0; i < board.length; i++) {
			temp = board[i];
			// System.out.println("current value: " + temp);
			b = 1;
			for (int j = i + 1; j < board.length; j++) {
				// check squares to the right
				if (temp == board[j])
					fitness++;
				// check lower diagonal
				if (temp + b == board[j])
					fitness++;
				// upper upper diagonal
				if (temp - b == board[j])
					fitness++;
				b++;
			} // end for
		} // end for
		return fitness;
	}

	@Override
	public int compareTo(State other) {
		// TODO Auto-generated method stub
		if (fitness < other.getFitness())
			return -1;
		if (fitness > other.getFitness())
			return 1;
		else
			return 0;
	} // end method

	// shuffle the array/state without duplicates
	private static int[] shuffle(int[] array) { // mix-up the array
		for (int i = array.length - 1; i > 0; --i) {
			int j = rand.nextInt(i + 1);
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return array;
	}

	// shuffle the array/state with duplicates
	private static int[] shuffle2(int[] array) { // mix-up the array
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(7 - 0) + 0;
		}
		return array;
	} // end method

} // end class
