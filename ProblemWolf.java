import java.util.HashSet;
import java.util.Set;

public class ProblemWolf extends Problem {

	static final int wolfL = 0;
	static final int cabbageL = 1;
	static final int goatL = 2;
	static final int boatL = 3;
	static final int wolfR = 4;
	static final int cabbageR = 5;
	static final int goatR = 6;
	static final int boatR = 7;

	boolean goal_test(Object state) {
		StateWolf wolfState = (StateWolf) state;
      //When all have crossed the river.
		if (wolfState.wolfArray[wolfR] == 1 && wolfState.wolfArray[cabbageR] == 1 && wolfState.wolfArray[goatR] == 1 && wolfState.wolfArray[boatR] == 1)
			return true;
		else
			return false;
	}

	Set<Object> getSuccessors(Object state) {

		Set<Object> set = new HashSet<Object>();
		StateWolf wolfState = (StateWolf) state;

		
		StateWolf successorState;
		//When boat is on the left side.
        if(wolfState.wolfArray[boatL]==1) {
	
	        // Wolf from left to right
			successorState = new StateWolf(wolfState);
			successorState.wolfArray[wolfL] = 0;
			successorState.wolfArray[wolfR] = 1;
			successorState.wolfArray[boatL] = 0;
			successorState.wolfArray[boatR] = 1;
			if (isValid(successorState))
				set.add(successorState);
			
			// Cabbage from left to right
			successorState = new StateWolf(wolfState);
			successorState.wolfArray[cabbageL] = 0;
			successorState.wolfArray[cabbageR] = 1;
			successorState.wolfArray[boatL] = 0;
			successorState.wolfArray[boatR] = 1;
			if (isValid(successorState))
				set.add(successorState);
			
			// Goat from left to right
			successorState = new StateWolf(wolfState);
			successorState.wolfArray[goatL] = 0;
			successorState.wolfArray[goatR] = 1;
			successorState.wolfArray[boatL] = 0;
			successorState.wolfArray[boatR] = 1;
			if (isValid(successorState))
				set.add(successorState);


	
       }else if(wolfState.wolfArray[boatR]==1) {
    	   
	        // Wolf from right to left
			successorState = new StateWolf(wolfState);
			successorState.wolfArray[wolfL] = 1;
			successorState.wolfArray[wolfR] = 0;
			successorState.wolfArray[boatL] = 1;
			successorState.wolfArray[boatR] = 0;
			if (isValid(successorState))
				set.add(successorState);
		

			// Cabbage from right to left
			successorState = new StateWolf(wolfState);
			successorState.wolfArray[cabbageL] = 1;
			successorState.wolfArray[cabbageR] = 0;
			successorState.wolfArray[boatL] = 1;
			successorState.wolfArray[boatR] = 0;
			if (isValid(successorState))
				set.add(successorState);
			
		
			// Goat from right to left
			successorState = new StateWolf(wolfState);
			successorState.wolfArray[goatL] = 1;
			successorState.wolfArray[goatR] = 0;
			successorState.wolfArray[boatL] = 1;
			successorState.wolfArray[boatR] = 0;
			if (isValid(successorState))
				set.add(successorState);
			
	
          }
		
		return set;
	}

	private boolean isValid(StateWolf state) {

	//Can't leave the goat alone with the wolf, nor with the cabbage (or something will be eaten).
		
		if (state.wolfArray[goatL] == 1 && state.wolfArray[cabbageL] == 1 && state.wolfArray[wolfL]==1 && state.wolfArray[boatL]==0 
				|| (state.wolfArray[goatR] == 1 && state.wolfArray[cabbageR] == 1 && state.wolfArray[wolfR]==1 &&  state.wolfArray[boatR]==0))
			return false;
		
		if (state.wolfArray[goatL] == 1 && state.wolfArray[cabbageL] == 1 && state.wolfArray[boatL]==0 
				|| (state.wolfArray[goatR] == 1 && state.wolfArray[cabbageR] == 1 &&  state.wolfArray[boatR]==0))
			return false;
		
		if (state.wolfArray[goatL] == 1 && state.wolfArray[wolfL] == 1 &&  state.wolfArray[boatL]==0 
				|| (state.wolfArray[goatR] == 1 && state.wolfArray[wolfR] == 1 &&  state.wolfArray[boatR]==0))
			
			return false;
		
		return true;
	}

	double step_cost(Object fromState, Object toState) {
		return 1;
	}

	public double h(Object state) { return 0; }
	

	public static void main(String[] args) throws Exception {
		ProblemWolf problem = new ProblemWolf();
		int[] wolfArray = { 1, 1, 1, 1, 0, 0, 0, 0 };
		problem.initialState = new StateWolf(wolfArray);

		Search search = new Search(problem);

		System.out.println("\n\nQ6 a: Wolf-Goat-Cabbage Problem - Uninformed Strategies\n");

		System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());

		System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());

		System.out.println("\nDepthFirstTreeSearch:\t" + search.DepthFirstTreeSearch());
		System.out.println("DepthFirstGraphSearch:\t" + search.DepthFirstGraphSearch());

		System.out.println("\nUniformCostTreeSearch:\t" + search.UniformCostTreeSearch());
		System.out.println("UniformCostGraphSearch:\t" + search.UniformCostGraphSearch());

		System.out.println("\nIterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
		System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
		
        System.out.println("\nGreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
        System.out.println("\nGreedyBestFirstGraphSearch:\t" + search.GreedyBestFirstGraphSearch());

        System.out.println("\nAstarTreeSearch:\t" + search.AstarTreeSearch());
        System.out.println("\nAstarGraphSearch:\t" + search.AstarGraphSearch());


	}
}