// Author: Alex (Wei) Chen Course: CS 420 
package main;

import java.util.Random;

public class SimulatingAnnealing {
	private double temp;
	private int counter;
	private int numFailed;

	static Random rand = new Random();

	public SimulatingAnnealing(double temp, int boardSize) {
		this.temp = temp;
	}

	public void startSASearch() {
		State neighState = new State();
		State currState = new State();
		int diff;
		double p;
		double k;
		while (currState.getFitness() != 0 || this.temp > 0) {
			counter++;
			neighState = getNeightbor(currState.getBoard());
			diff = currState.getFitness() - neighState.getFitness();
			p = Math.exp(diff / temp);
			k = Math.random();

			// if cost of neighbor < cost of current state
			if (diff > 0) {
				currState = neighState;
			} else if (p >= k) {
				currState = neighState;
			}
			temp--;
		}
	} // end method

	// for testing a single trial
	public void startSASearch(int[] test) {
		State neighState = new State();
		State currState = new State();
		currState.setBoard(test);
		int diff;
		double p;
		double k;
		while (currState.getFitness() != 0 || this.temp > 0) {
			counter++;
			neighState = getNeightbor(currState.getBoard());
			diff = currState.getFitness() - neighState.getFitness();
			p = Math.exp(diff / temp);
			k = Math.random();

			// if cost of neighbor < cost of current state
			if (diff > 0) {
				currState = neighState;
			} else if (p >= k) {
				currState = neighState;
			}
			temp--;
		}
		printState(currState);
	} // end method

	// find a random neighboring state
	private State getNeightbor(int[] board) {
		State neighbor = new State();
		neighbor.setBoard(board);
		int index;
		int sub;
		int[] nb;
		index = rand.nextInt(8 - 0) - 0;
		sub = rand.nextInt(8 - 0) - 0;
		nb = board.clone();
		nb[index] = sub;
		neighbor.setBoard(nb);

		return neighbor;
	}

	public int getCounter() {
		return counter;
	}

	public int getNumFailed() {
		return numFailed;
	}

	// print result
	private void printState(State temp) {
		System.out.print("Solution: ");
		for (int i = 0; i < temp.getBoard().length; i++) {
			System.out.print(temp.getBoard()[i]);
		}
	} // end method

} // end class
