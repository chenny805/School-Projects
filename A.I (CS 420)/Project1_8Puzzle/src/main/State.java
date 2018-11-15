package main;

import java.util.ArrayList;

public class State implements Comparable<State> {
	int g;
	int h;
	String state;
	State parent;
	int f;
	ArrayList<State> sucessor;

	public State(String currState) {
		state = currState; // set values for new state
		sucessor = new ArrayList<State>();
	}

	// method for arranging priority queue
	public int compareTo(State n) {
		if (this.equals(n))
			return 0;
		else if (getF() > n.getF())
			return 1;
		else
			return -1;
	}

	public void addF(int cost, int estimatedCost) {
		f = g + h;
	}

	public void setSucessor(State s) {
		sucessor.add(s);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<State> getChildern() {
		return sucessor;
	}

	public void setChildern(ArrayList<State> s) {
		this.sucessor = s;
	}

	public State getParent() {
		return parent;
	}

	public void setParent(State parent) {
		this.parent = parent;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

}
