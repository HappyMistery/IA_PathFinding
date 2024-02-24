import java.util.List;

public abstract class Search {
    private float[][] costMap;
    private Heuristic heuristic; 

    public Search(float[][] costMap, Heuristic heuristic){
        this.costMap = costMap;
        this.heuristic = heuristic;
    }

    public List<State> DoSearch(State initialState, State targetState){
        /* TODO: Implement search algorithm
         * You CANNOT change the input parameters (i.e., initial and target state).
         * However, feel free to use inheritance, auxiliar methods and/or change the return type. */
    }    

    protected List<State> EvaluateOperators(State currentState, State targetState){
        /* TODO: Obtain the states that can be accessed from the current state.
         * Consider their cost, heuristic...
         * Feel free to change the input parameters and/or return type.
         */
    }
}
