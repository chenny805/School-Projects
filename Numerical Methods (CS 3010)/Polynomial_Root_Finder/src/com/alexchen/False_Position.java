/*  Name: Alex Chen
 *  Professor: Raheja
 *  Class: CS 3010
 *  Date: 11/06/18
 */ 

package com.alexchen;

public class False_Position extends RootFinder {

	static double tempC;

	public False_Position(String f1, String f2) {
		super(f1, f2);
	}

	public void start() {
		
		// setting the bracket values
		double a = 0;
		double b = 1;
		
		printTable(func1);
		System.out.println("Root is: " + calculateNext(a, b, 0, 1) + "\n\n");
		
		// setting the bracket values
		a = 1;
		b = 2;
		printTable(func1);
		System.out.println("Root is: " + calculateNext(a, b, 0, 1) + "\n\n");
		
		// setting the bracket values
		a = 3;
		b = 4;
		printTable(func1);
		System.out.println("Root is: " + calculateNext(a, b, 0, 1) + "\n\n");
		
		// setting the bracket values
		a = 120;
		b = 130;
		printTable(func2);
		System.out.println("Root is: " + calculateNext(a, b, 0, 2) + "\n\n");
	}

	// calculate Xn+1
	private static double calculateNext(double initial0, double initial1, double x1, int function) {
		double a = initial0; // Xn-1
		double b = initial1; // Xn
		double c = x1; // Xn+1
		double fa = 0;
		double fb = 0;
		double fc = 0;
		tempC = c;

		// determine which function to use 1 for first function and 2 for second
		// function
		if (function == 1) {
			try {
				fa = plugInFunction1(a);
				fb = plugInFunction1(b);
				c = a - (   (fa * (a-b)) / (fa-fb) );
				fc = plugInFunction1(c);

			} catch (Exception e) {
				System.out.println("Division by zero error!!! Pick new starting point!");
			}

		} else {
			try {
				fa = plugInFunction2(a);
				fb = plugInFunction2(b);
				c = b - (   (fb * (a-b)) / (fa-fb) );
				fc = plugInFunction2(c);

			} catch (Exception e) {
				System.out.println("Division by zero error!!! Pick new starting point!");
			}
		}
		
		if (approxError < APPROXERROR || counter > MAXITERATION) {
			counter = 0;
			approxError = 100;
			return tempC;
			
		} else {
			// if the root is between [ a, c ]
			if ((fa*fc < 0)) {
				approxError = calcError(tempC, c);
				printContent(counter, a, b, fa, fb, c, fc, approxError);
				counter++;
				return calculateNext(a, c, c, function);
			// if the root is between [ c, b ]
			} else {
				approxError = calcError(tempC, c);
				printContent(counter, a, b, fa, fb, c, fc, approxError);
				counter++;
				return calculateNext(c, b, c, function);
			}
		}
	} // end method

	// print row of updated values
	protected static void printContent(int n, double a, double b, double fa, double fb, double c, double fc, double Ea) {
		System.out.printf("%4s %15s %15s %15s %15s %15s %15s %15s %n", n, df.format(a), df.format(b), df.format(fa),
				df.format(fb), df.format(c), df.format(fc), df.format(Ea));
	} // end method

	protected static void printTable(String function) {
		System.out.println("Table: " + function);
		System.out.printf("%4s %15s %15s %15s %15s %15s %15s %15s %n", "n", "a", "b", "f(a)", "f(b)", "c", "f(c)", "Ea");
		System.out.println("------------------------------------------------------------------------------------------"
				+ "-------------------------------------");
	} // end method

}
