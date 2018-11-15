package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Puzzle {
	State start;
	Support supObject = new Support();
	public Puzzle(State start) {
		this.start = start;
	}

	public void solve() {
		Set<String> set = new HashSet<String>();
		State s = new State(start.getState());
		s.setF(0);
        NodePriorityComparator comp = new NodePriorityComparator();

		PriorityQueue<State> queue = new PriorityQueue<State>(10, comp);
		State currState = s;
		while (!(currState.getState().equals("0123456789"))) {
			set.add(currState.getState());
			List<String> list = getnextState(currState.getState());
			for (String temp : list) {
				if (set.contains(temp))
					continue;
				set.add(temp);
				State nextState = new State(temp);
				currState.setSucessor(nextState);
				nextState.setParent(currState);
				// add all possible next states
				nextState.addF(
						currState.getF() + Character.getNumericValue(
						nextState.getState().charAt(nextState.getParent().getState().indexOf('0'))),
						supObject.numMisplaced(nextState.getState()));
				queue.add(nextState); // add the next states to priority to be
										// arranged
			} // end for
			currState = queue.poll();
		} // end while/search
		supObject.printState(currState.getState());
	} // end method

	public static List<String> getnextState(String state) {
		List<String> nextState = new ArrayList<String>();

		switch (state.indexOf("0")) {
		case 0: {
			nextState.add(state.replace(state.charAt(0), '$').replace(state.charAt(1), state.charAt(0)).replace('$',
					state.charAt(1)));
			nextState.add(state.replace(state.charAt(0), '$').replace(state.charAt(3), state.charAt(0)).replace('$',
					state.charAt(3)));
			break;
		}
		case 1: {
			nextState.add(state.replace(state.charAt(1), '$').replace(state.charAt(0), state.charAt(1)).replace('$',
					state.charAt(0)));
			nextState.add(state.replace(state.charAt(1), '$').replace(state.charAt(2), state.charAt(1)).replace('$',
					state.charAt(2)));
			nextState.add(state.replace(state.charAt(1), '$').replace(state.charAt(4), state.charAt(1)).replace('$',
					state.charAt(4)));
			break;
		}
		case 2: {

			nextState.add(state.replace(state.charAt(2), '$').replace(state.charAt(1), state.charAt(2)).replace('$',
					state.charAt(1)));
			nextState.add(state.replace(state.charAt(2), '$').replace(state.charAt(5), state.charAt(2)).replace('$',
					state.charAt(5)));
			break;
		}
		case 3: {
			nextState.add(state.replace(state.charAt(3), '$').replace(state.charAt(0), state.charAt(3)).replace('$',
					state.charAt(0)));
			nextState.add(state.replace(state.charAt(3), '$').replace(state.charAt(4), state.charAt(3)).replace('$',
					state.charAt(4)));
			nextState.add(state.replace(state.charAt(3), '$').replace(state.charAt(6), state.charAt(3)).replace('$',
					state.charAt(6)));
			break;
		}
		case 4: {
			nextState.add(state.replace(state.charAt(4), '$').replace(state.charAt(1), state.charAt(4)).replace('$',
					state.charAt(1)));
			nextState.add(state.replace(state.charAt(4), '$').replace(state.charAt(3), state.charAt(4)).replace('$',
					state.charAt(3)));
			nextState.add(state.replace(state.charAt(4), '$').replace(state.charAt(5), state.charAt(4)).replace('$',
					state.charAt(5)));
			nextState.add(state.replace(state.charAt(4), '$').replace(state.charAt(7), state.charAt(4)).replace('$',
					state.charAt(7)));
			break;
		}
		case 5: {
			nextState.add(state.replace(state.charAt(5), '$').replace(state.charAt(2), state.charAt(5)).replace('$',
					state.charAt(2)));
			nextState.add(state.replace(state.charAt(5), '$').replace(state.charAt(4), state.charAt(5)).replace('$',
					state.charAt(4)));
			nextState.add(state.replace(state.charAt(5), '$').replace(state.charAt(8), state.charAt(5)).replace('$',
					state.charAt(8)));
			break;
		}
		case 6: {
			nextState.add(state.replace(state.charAt(6), '$').replace(state.charAt(3), state.charAt(6)).replace('$',
					state.charAt(3)));
			nextState.add(state.replace(state.charAt(6), '$').replace(state.charAt(7), state.charAt(6)).replace('$',
					state.charAt(7)));
			break;

		}
		case 7: {
			nextState.add(state.replace(state.charAt(7), '$').replace(state.charAt(4), state.charAt(7)).replace('$',
					state.charAt(4)));
			nextState.add(state.replace(state.charAt(7), '$').replace(state.charAt(6), state.charAt(7)).replace('$',
					state.charAt(6)));
			nextState.add(state.replace(state.charAt(7), '$').replace(state.charAt(8), state.charAt(7)).replace('$',
					state.charAt(8)));
			break;
		}
		case 8: {
			nextState.add(state.replace(state.charAt(8), '$').replace(state.charAt(5), state.charAt(8)).replace('$',
					state.charAt(5)));
			nextState.add(state.replace(state.charAt(8), '$').replace(state.charAt(7), state.charAt(8)).replace('$',
					state.charAt(7)));
			break;
		}
		}

		return nextState;

	}

} // end class
