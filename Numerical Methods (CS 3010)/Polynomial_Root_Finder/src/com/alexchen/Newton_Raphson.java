/*  Name: Alex Chen
 *  Professor: Raheja
 *  Class: CS 3010
 *  Date: 11/06/18
 */ 

package com.alexchen;

public class Newton_Raphson extends RootFinder {

	public Newton_Raphson(String f1, String f2) {
		super(f1, f2);
	}

	// start the method with the following initial values: 0, 2, 3
	public void start() {

		// initial values for function 1
		double init1 = 0;
		double init2 = 1.5;
		double init3 = 3;

		// initial value for function 2
		double init4 = 140;

		printTable(func1);
		System.out.println("Root is: " + calculateNext(init1, 1) + "\n\n");
		printTable(func1);
		System.out.println("Root is: " + calculateNext(init2, 1) + "\n\n");
		printTable(func1);
		System.out.println("Root is: " + calculateNext(init3, 1) + "\n\n");

		printTable(func2);
		System.out.println("Root is: " + calculateNext(init4, 2) + "\n\n");

	}

	private static double calculateNext(double x, int function) {
		double x0 = x;
		double x1 = 0;
		double fx0 = 0;
		double fx1 = 0;

		// check which function to use
		if (function == 1) {
			try {
				fx0 = plugInFunction1(x0);
				fx1 = solveDerivative1(x0);
				x1 = x0 - ((fx0) / (fx1));
			} catch (Exception e) {
				System.out.println("Division by zero error!!! Pick new starting point!");
			}
		} else {
			try {
				fx0 = plugInFunction2(x0);
				fx1 = solveDerivative2(x0);
				x1 = x0 - ((fx0) / (fx1));
			} catch (Exception e) {
				System.out.println("Division by zero error!!! Pick new starting point!");
			}
		}

		// keep iterating until criteria is met
		if (approxError < APPROXERROR || counter > MAXITERATION) {
			counter = 0;
			approxError = 100;
			return x1;
		} else {
			approxError = calcError(x0, x1);
			printContent(counter, x0, x1, fx0, fx1, approxError);
			counter++;
			return calculateNext(x1, function);
		}
	}

	// method to plug in values for derivative of function 1
	private static double solveDerivative1(double x) {
		double sol = 6 * Math.pow(x, 2) - 23.4 * x + 17.7;
		return sol;
	} // end method

	// method to plug in values for derivative of function 2
	private static double solveDerivative2(double x) {
		double sol = ((50 * Math.sinh(50/x ))/ x) - (Math.cosh(50/x) )+ 1;
		return sol;
	}

	// print row of updated values
	protected static void printContent(int n, double Xn, double Xn1, double fxn, double f1xn, double Ea) {
		System.out.printf("%4s %15s %15s %15s %15s %15s %n", n, df.format(Xn), df.format(Xn1), df.format(fxn),
				df.format(f1xn), df.format(Ea));
	} // end method

	protected static void printTable(String function) {
		System.out.println("Table: " + function);
		System.out.printf("%4s %15s %15s %15s %15s %15s %n", "n", "Xn", "Xn+1", "f(Xn)", "f'(Xn)", "Ea");
		System.out.println("------------------------------------------------------------------------------------------"
				+ "-------------------------------------");
	} // end method

} // end class
