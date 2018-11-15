/*  Name: Alex Chen
 *  Professor: Raheja
 *  Class: CS 3010
 *  Date: 11/06/18
 */ 

package com.alexchen;

public class Modified_Secant extends RootFinder{

	// default distance factor from assignment
	private static final double d = 0.01;

	// constructor
	public Modified_Secant(String f1, String f2) {
		super(f1, f2);
	}

	// start the method with initial variables
	public void start() {
		
		
		printTable(func1);
		System.out.println("Root is: " + calculateNext(1, 1) + "\n\n");
		printTable(func1);
		System.out.println("Root is: " + calculateNext(1.5, 1) + "\n\n");
		printTable(func1);
		System.out.println("Root is: " + calculateNext(3, 1) + "\n\n");
		
		
		printTable(func2);
		System.out.println("Root is: " + calculateNext(140, 2) + "\n\n");
	}

	// calculate Xn+1
	private static double calculateNext(double initial1, int function) {
		double x1 = initial1;
		double x2 = 0;
		double fxd = 0;
		double fx1 = 0;

		// determine which function to use 1 for first function and 2 for second function
		if (function == 1) {
			try {
				fx1 = plugInFunction1(x1);
				fxd = plugInFunction1(x1 + (d*x1));
				x2 = x1 - ( (d * x1 * fx1) / (fxd - fx1));
			} catch (Exception e) {
				System.out.println("Division by zero error!!! Pick new starting point!");
			}

		} else {
			try {
				fx1 = plugInFunction2(x1);
				fxd = plugInFunction2(x1 + (d*x1));
				x2 = x1 - ( (d * x1 * fx1) / (fxd - fx1));
			} catch (Exception e) {
				System.out.println("Division by zero error!!! Pick new starting point!");
			}
		}
		if (approxError < APPROXERROR || counter > MAXITERATION) {
			counter = 0;
			approxError = 100;
			return x2;
		} else {
			approxError = calcError(x1, x2);
			printContent(counter, x1, (d*x1), x2, fx1, fxd, approxError);
			counter++;
			return calculateNext(x2, function);
		}

	} // end method
	
	// print row of updated values
	protected static void printContent(int n, double X0, double dx, double X1, double fX0, double fdx, double Ea) {
		System.out.printf("%4s %15s %15s %15s %20s %20s %15s %n", n, df.format(X0), 
		df.format(dx), df.format(X1), df.format(fX0), df.format(fdx), df.format(Ea));
	} // end method
	
	
	protected static void printTable(String function) {
		System.out.println("Table: " + function);
		System.out.printf("%4s %15s %15s %15s %20s %20s %15s %n", "n", "Xn", "d*Xn", 
				"Xn+1", "f(Xn)", "f(Xn+(dXn))", "Ea");
		System.out.println("------------------------------------------------------------------------------------------"
				+ "----------------");
	} // end method

} // end class
