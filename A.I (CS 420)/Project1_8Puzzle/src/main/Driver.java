package main;

public class Driver {
	public static void main (String[] args) {
		Support supObj = new Support();
		String start = supObj.newPuzzle();
		Puzzle newGame = new Puzzle(new State(start));
		newGame.solve();
	}

}
