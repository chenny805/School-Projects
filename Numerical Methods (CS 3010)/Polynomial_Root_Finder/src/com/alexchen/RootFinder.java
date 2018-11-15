/*  Name: Alex Chen
 *  Professor: Raheja
 *  Class: CS 3010
 *  Date: 11/06/18
 */ 

package com.alexchen;

import java.text.*;

public abstract class RootFinder {

	// approximate error to stop iteration
	final static double APPROXERROR = 0.00001;
	// set max iteration
	final static int MAXITERATION = 100;
	// counter and start error
	static int counter;
	static double approxError = 100;

	// VARIABLES FOR FUNCTION 1
	// interval to find root
	final double A = 0;
	final double B = 4;
	double root1;
	double root2;
	double root3;
	int numRoots = 3;
	
	String func1;
	String func2;
	
	// formatter for decimal values
	static NumberFormat df = new DecimalFormat("#0.0000");


	// constructor
	public RootFinder(String f1, String f2) {
		this.func1 = f1;
		this.func2 = f2;
	}

	// method to plug in values for function
	protected static double plugInFunction1(double x) {
		double sol = 2 * Math.pow(x, 3) - 11.7 * Math.pow(x, 2) + 17.7 * x - 5;
		return sol;
	} // end method

	protected static double plugInFunction2(double x) {
		double sol = x + 10 - (x * Math.cosh(50 / x));
		return sol;
	} // end method

	protected static void printTable(double a, double b, double fa, double fb, double c, double fc, double error, String function) {	} // end method

	// estimate error
	// might move this to the RootFinder class
	protected static double calcError(double c, double c1) {
		double error = Math.abs((c - c1) / c1);
		return error;
	} // end method
	
	
	
	
	// used for printing data for spreadsheet
	protected static void printIteration(int n) {
		System.out.println(n);
	}
	
	public void printError(double error) {
		System.out.println(error);
	}
	
	

} // end class
