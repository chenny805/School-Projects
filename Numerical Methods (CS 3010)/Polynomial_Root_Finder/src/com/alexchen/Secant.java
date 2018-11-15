/*  Name: Alex Chen
 *  Professor: Raheja
 *  Class: CS 3010
 *  Date: 11/06/18
 */ 

package com.alexchen;

public class Secant extends RootFinder {

	String func1;
	String func2;

	// constructor
	public Secant(String f1, String f2) {
		super(f1, f2);
	}

	// start the method with initial variables
	public void start() {
		printTable(func1);
		System.out.println("Root is: " + calculateNext(0, .5, 1) + "\n\n");
		printTable(func1);
		System.out.println("Root is: " + calculateNext(1.25, 1.5, 1) + "\n\n");
		printTable(func1);
		System.out.println("Root is: " + calculateNext(4, 5, 1) + "\n\n");

		printTable(func2);
		System.out.println("Root is: " + calculateNext(100, 200, 2) + "\n\n");
	}

	// calculate Xn+1
	private static double calculateNext(double initial0, double initial1, int function) {
		double x0 = initial0;
		double x1 = initial1;
		double x2 = 0;
		double fx0 = 0;
		double fx1 = 0;

		// determine which function to use 1 for first function and 2 for second
		// function
		if (function == 1) {
			try {
				fx0 = plugInFunction1(x0);
				fx1 = plugInFunction1(x1);
				x2 = x1 - ((fx1 * (x1 - x0)) / (fx1 - fx0));

			} catch (Exception e) {
				System.out.println("Division by zero error!!! Pick new starting point!");
			}

		} else {
			try {
				fx0 = plugInFunction2(x0);
				fx1 = plugInFunction2(x1);
				x2 = x1 - ((fx1 * (x1 - x0)) / (fx1 - fx0));

			} catch (Exception e) {
				System.out.println("Division by zero error!!! Pick new starting point!");
			}
		}
		if (approxError < APPROXERROR || counter > MAXITERATION) {
			counter = 0;
			approxError = 100;
			return x2;
		} else {
			approxError = calcError(x0, x1);
			printContent(counter, x1, x0, x2, fx1, fx0, approxError);
			counter++;
			return calculateNext(x1, x2, function);
		}

	} // end method

	protected static void printContent(int n, double X1, double X0, double X2, double fX1, double fX0, double Ea) {

		System.out.printf("%4s %15s %15s %15s %15s %15s %15s %n", n, df.format(X1), df.format(X0), df.format(X2),
				df.format(fX1), df.format(fX0), df.format(Ea));
	} // end method

	protected static void printTable(String function) {
		System.out.println("Table: " + function);
		System.out.printf("%4s %15s %15s %15s %15s %15s %15s %n", "n", "Xn", "Xn-1", "Xn+1", "f(Xn)", "f(Xn-1)", "Ea");
		System.out.println("------------------------------------------------------------------------------------------"
				+ "--------");
	} // end method

} // end class
