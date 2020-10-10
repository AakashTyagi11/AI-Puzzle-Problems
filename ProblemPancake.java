import java.util.HashSet;
import java.util.Set;

public class ProblemPancake extends Problem {

	boolean goal_test(Object state) {
		StatePancake pancakeState = (StatePancake) state;
		
     //Final Result Should be a sorted array, 
		for (int i = 0; i < pancakeState.N - 1; i++) {
	        if (pancakeState.pancakeArray[i] > pancakeState.pancakeArray[i + 1]) {
	            return false; // It is proven that the array is not sorted.
	        }
	    }

	    return true; 
	}
	

	Set<Object> getSuccessors(Object state) {
		
		Set<Object> set = new HashSet<Object>();
		StatePancake pancakeState = (StatePancake) state;
		StatePancake successorState;
		
        //We can flip Pancakes through Spatula which can be at any n-1 positions.(n-2,n-3....1)
     
		for(int i=1;i<pancakeState.N;i++) {
			successorState=new StatePancake(pancakeState);
			
			for (int j = 0; j < (i / 2)+1; j++) {
				
				//flip the array for every possible 
		          int temp = successorState.pancakeArray[j];  
		          successorState.pancakeArray[j] = successorState.pancakeArray[i - j];
		          successorState.pancakeArray[i - j] = temp;
		          
		      }
			
			set.add(successorState);
			
		}
		
		return set;
	}


	double step_cost(Object fromState, Object toState) {
		return 1;
	}

	public double h(Object state) { return 0; }
	

	public static void main(String[] args) throws Exception {
		ProblemPancake problem = new ProblemPancake();
		
		//Pass any N number of inputs
		int[] pancakeArray = { 5,2,7,4,1,3,6};
		problem.initialState = new StatePancake(pancakeArray);

		Search search = new Search(problem);

		System.out.println("\n\nQ6 c: Pancake sorting Problem - Uninformed Strategies\n");

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