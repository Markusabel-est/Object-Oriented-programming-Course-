package slidingGame;

import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 */
public class Solver {
	// A queue for maintaining states that are not visited yet.
	private Queue<Configuration> toExamine;
	// A collection of states that have been visited
	private Collection<Configuration> encountered;

	public Solver(Configuration g) {
		toExamine = new PriorityQueue<>();
        encountered = new HashSet<>();
        toExamine.add(g);
        encountered.add(g);
	}

	/**
	 * A skeleton implementation of the solver
	 *
	 * @return a string representation of the solution
	 */
	public String solve() {
		while (!toExamine.isEmpty()) {
			Configuration next = toExamine.remove();
			encountered.add(next);
			if (next.isSolution()) {
				return pathFromRoot(next);
			} else {
				for (Configuration succ : next.successors()) {
					if(!(encountered.contains(succ))){
						toExamine.add(succ);
					}
				}
			}
		}
		return "Failure!";
	}

	private String pathFromRoot (Configuration config) {
		if (config.getParent() == null) {
			return config.toString() + "\n";
		} else {
			return pathFromRoot(config.getParent()) + config.toString() + "\n";
		}
	}


}
