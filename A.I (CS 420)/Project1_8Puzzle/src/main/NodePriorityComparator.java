package main;

import java.util.Comparator;

public class NodePriorityComparator implements Comparator<State> {

    @Override
    public int compare(State x, State y) {
        if (x.getF() < y.getF()) {
            return -1;
        }
        if (x.getF() > y.getF()) {
            return 1;
        }
        return 0;
    }
}
