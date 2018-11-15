// Author: Alex (Wei) Chen Course: CS 420 
package main;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		int populationSize = 100; // population size of each generation
		int boardSize = 8; // size of board
		int numTrials = 150;
		double mutationProbability = 0.7; // probability of mutation
		double selectionFactor = 3.3; // selection probability factor
		double temp = 1000;
		long startTime;
		long endTime;
		long totalTime;
		int[] testState = { 2, 3, 4, 1, 7, 7, 6, 5 };
		String choice;
		GeneticAlgorithm genetic = new GeneticAlgorithm(populationSize, boardSize, mutationProbability,
				selectionFactor);
		SimulatingAnnealing sa = new SimulatingAnnealing(temp, boardSize);
		Scanner scanper = new Scanner(System.in);

		System.out.println("Which Algorithm Would You Like To Test?\n"
				+ "-Press 1: For Genetic\n-Press 2: For Simulating Annealing\n" + "-Press 3: To Solve A Single Puzzle");
		choice = scanper.nextLine();
		if (choice.equals("1")) {
			System.out.println("Please wait for about 30 seconds...");
			startTime = System.nanoTime();
			for (int i = 0; i < numTrials; i++) {
				genetic.startGeneticSearch();
			}
			endTime = System.nanoTime();
			totalTime = endTime - startTime;
			System.out.println("\nAverage Execution Time Of " + numTrials + " Trials: " + totalTime / numTrials);
			System.out.println("Average Number Of States Generated: " + (genetic.getCounter() / numTrials));
			System.out.println("Average Number Of Generations: " + (genetic.getNumGenerations() / numTrials));
			System.out.println("Number Failed: " + (genetic.getNumFailed()));
		} else if (choice.equals("2")) {
			System.out.println("Please wait for about 30 seconds...");
			startTime = System.nanoTime();
			for (int i = 0; i < numTrials; i++) {
				sa.startSASearch();
			}
			endTime = System.nanoTime();
			totalTime = endTime - startTime;
			System.out.println("\nAverage Execution Time Of " + numTrials + " Trials: " + totalTime / numTrials);
			System.out.println("Average Number Of States Generated: " + (sa.getCounter() / numTrials));
			System.out.println("Number Failed: " + (sa.getNumFailed()));
		}
		else if (choice.equals("3")) {

			System.out.print("Initial State: ");
			for (int i = 0; i < testState.length; i++) {
				System.out.print(testState[i]);
			}
			System.out.println();

			sa.startSASearch(testState);
		} else {
			System.out.println("Invalid Input");
		}
		scanper.close();

	} // end main method
} // end class
