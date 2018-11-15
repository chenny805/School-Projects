// Author: Alex (Wei) Chen Course: CS 420 
package main;

import java.util.Arrays;
import java.util.Random;

public class GeneticAlgorithm {
	private int populationSize;
	private int boardSize;
	private double mutationProbability;
	private double selectionFactor;
	private final int parentSize = 2;
	private Random rand = new Random();
	private int numGenerations;
	private int numFailed = 0;
	private int counter;

	// constructor to send search parameters
	public GeneticAlgorithm(int populationSize, int boardSize, double mutationProbability, double selectionFactor) {
		this.populationSize = populationSize;
		this.boardSize = boardSize;
		this.mutationProbability = mutationProbability;
		this.selectionFactor = selectionFactor;
	}

	// start the search by creating the first generation
	public void startGeneticSearch() {
		numGenerations = 0;
		State[] firstGen = new State[populationSize];
		for (int i = 0; i < populationSize; i++) {
			firstGen[i] = new State();
		}
		geneticSearch(firstGen); // continue search after the first generation
	} // end method

	private int[] geneticSearch(State[] population) {
		State[] state = new State[parentSize];
		Arrays.sort(population); // sort the states from most fit to least fit
		if (numGenerations >= 10000) {
			numFailed++;
			return null;
		}

		for (int i = 0; i < populationSize; i++) {
			state = findParents(population); // return a set of 2 parents
			state = crossOver(state); // cross and mutate two parents
			// check if solution is found!
			if (state[0].getFitness() == 0) {

				return state[0].getBoard();
			}
			if (state[1].getFitness() == 0) {
				return state[1].getBoard();
			}
			population[i].setBoard(state[0].getBoard());
			i++;
			population[i].setBoard(state[1].getBoard());
		}
		numGenerations++;
		return geneticSearch(population); // keep calling function till solution
											// is found
	} // end method

	private State[] findParents(State[] population) {
		int parentIndex;
		double p;
		State[] parentSet = new State[parentSize];

		// find the index of the next parents
		for (int i = 0; i < parentSize; i++) {
			p = Math.random();
			// math equation to give more fit states a higher chance of
			// reproducing
			// index = populationSize*random^3.3
			parentIndex = (int) (100 * Math.pow(p, selectionFactor));
			parentSet[i] = population[parentIndex];
		}
		return parentSet; // return parents
	} // end method

	// take two parent states and cross them for child state
	public State[] crossOver(State[] state) {
		counter += 2;
		int[] parent1 = state[0].getBoard();
		int[] parent2 = state[1].getBoard();

		int crossPoint = rand.nextInt(8 - 0) + 0;
		int[] a = new int[boardSize];
		int[] b = new int[boardSize];

		// to cross two parents
		for (int i = 0; i < crossPoint; i++) {
			a[i] = parent1[i]; // copy parent2
		}
		for (int i = 0; i < crossPoint; i++) {
			b[i] = parent2[i]; // copy parent2
			parent2[i] = a[i]; // cross parent2
			parent1[i] = b[i]; // cross parent1
		}
		for (int i = crossPoint; i < boardSize; i++) {
			a[i] = parent1[i];
		}
		for (int i = crossPoint; i < boardSize; i++) {
			b[i] = parent2[i]; // copy parent2
			parent2[i] = a[i]; // cross parent2
			parent1[i] = b[i]; // cross parent1
		}

		state[0].setBoard(parent1);
		state[1].setBoard(parent2);

		mutation(state);
		return state;
	} // end method

	private State[] mutation(State[] children) {
		double p;
		int index;
		int mut;
		int[] child;
		for (int i = 0; i < children.length; i++) {
			p = Math.random();
			child = children[i].getBoard();
			if (p <= mutationProbability) {
				index = rand.nextInt(8 - 0) - 0;
				mut = rand.nextInt(8 - 0) - 0;
				child[index] = mut;
			}
			children[i].setBoard(child); // save mutation to child
		} // end for
		return children;
	} // end method

	public int getNumFailed() {
		return numFailed;
	}

	public int getCounter() {
		return counter;
	}

	public int getNumGenerations() {
		return numGenerations;
	}

	// print solution and fitness
	public void printState(State temp) {
		System.out.print("Board: ");
		for (int i = 0; i < temp.getBoard().length; i++) {
			System.out.print(temp.getBoard()[i]);
		}
		System.out.println("\n" + "Fitness: " + temp.getFitness());
		System.out.println("Total Number of Generations: " + numGenerations);
	} // end method

} // end class
